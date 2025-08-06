package jdbc.activity;

import java.sql.*;

public class JDBCTest {

    String url = "jdbc:oracle:thin:@192.168.0.200:1521:VCC";
    String user = "SE17###";
    String passwd = "SE17###";
    
    private Connection conn;

    public JDBCTest() {

        try {
            Class.forName( "oracle.jdbc.driver.OracleDriver" );
            conn = DriverManager.getConnection( url, user, passwd );
            System.out.println( "[DB�� ���������� ����Ǿ����ϴ�!]" );
            conn.setAutoCommit( false );
        } catch ( SQLException e ) {
            System.out.println( "[DB ���ῡ ������ �߻��Ͽ����ϴ�.]" );
            e.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            System.out.println( "[JDBC ����̹� ������ ������ �ֽ��ϴ�.]" );
            e.printStackTrace();
        }
    }

    /**
     * main �޼ҵ�
     * 
     * @param args
     */
    public static void main( String[] args ) {

        JDBCTest jdbcTester = new JDBCTest();

        System.out.println( "############ Statement Example ############" );

        System.out.println( "--- SELECT 1 ----" );
        jdbcTester.statementSelectExam();
        System.out.println( "" );
        System.out.println( "" );

        System.out.println( "--- UPDATE ----" );
        System.out.println( jdbcTester.statementUpdateExam() );
        System.out.println( "" );
        System.out.println( "" );

        System.out.println( "--- SELECT 2 ----" );
        jdbcTester.statementSelectExam();
        System.out.println( "" );
        System.out.println( "" );

        System.out.println( "--- Rollback ----" );
        jdbcTester.rollback();
        System.out.println( "" );
        System.out.println( "" );

        System.out.println( "--- SELECT 3 ----" );
        jdbcTester.statementSelectExam();
        System.out.println( "" );
        System.out.println( "" );

        jdbcTester.closeConnection();
    }

    /**
     * Connection ��ü�� ��´�.
     * 
     * @return Connection ��ü�� Return.
     */
    public Connection getConnection() {

        if ( isConnected() )
            return conn;
        else {
            System.out.println( "[DB ���ῡ ������ �ֽ��ϴ�.]" );
            return null;
        }
    }

    /**
     * DB�� Connect�Ǿ����� ���θ� Return�Ѵ�.
     * 
     * @return DB�� Connect�Ǿ����� ����.
     */
    public boolean isConnected() {

        boolean validConnection = true;

        try {
            if ( conn == null || conn.isClosed() )
                validConnection = false;
        } catch ( SQLException e ) {
            validConnection = false;
            e.printStackTrace();
        }

        return validConnection;
    }

    /**
     * DB�� ������ ����.
     */
    public void closeConnection() {

        try {
            if ( isConnected() ) {
                conn.close();
                System.out.println( "[DB ������ �����Ǿ����ϴ�!]" );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    /**
     * DB Commit �� �����Ѵ�.
     */
    public void commit() {

        try {
            if ( isConnected() ) {
                conn.commit();
                System.out.println( "[Ŀ�� �Ǿ����ϴ�.]" );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    /**
     * DB Ʈ����� �ѹ�.
     */
    public void rollback() {

        try {
            if ( isConnected() ) {
                conn.rollback();
                System.out.println( "[�ѹ� �Ǿ����ϴ�.]" );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    /**
     * Statement ��ü�� �̿��� �⺻���� Select ����
     */
    public void statementSelectExam() {

        Statement stmt = null;
        ResultSet rset = null;
        String query = null;

        try {
            stmt = conn.createStatement();
            query = " SELECT ID,    " + 
                    "        LAST_NAME,  " + 
                    "        FIRST_NAME, " + 
                    "        SALARY   " + 
                    " FROM   EMP     " + 
                    " WHERE  SALARY > 30000 ";

            rset = stmt.executeQuery( query );

            while ( rset.next() ) {
                System.out.print( rset.getString( 1 ) + "\t   " );
                System.out.print( rset.getString( 2 ) + "\t   " );
                System.out.print( rset.getString( 3 ) + "\t   " );
                System.out.print( rset.getInt( 4 ) + "\n" );
            }
        } catch ( SQLException e ) {
            System.out.println( "[statementSelectExam()���� ������ �߻��Ͽ����ϴ�.]" );
            e.printStackTrace();
        } finally {
            try {
                if ( stmt != null ) {
                    rset.close();
                    stmt.close();
                }

            } catch ( SQLException e ) {
                System.out.println( "[statementSelectExam()���� ������ �߻��Ͽ����ϴ�.]" );
                e.printStackTrace();
            }
        }
    }

    /**
     * Statement ��ü�� �̿��� ������ Udate ����
     * 
     * @return boolean
     */
    public boolean statementUpdateExam() {

        Statement stmt = null;
        String query = null;
        boolean returnValue = false;
        int result = 0;

        try {
            stmt = conn.createStatement();

            query = " UPDATE EMP           " + 
                    " SET    SALARY = SALARY * 1.2 " + 
                    " WHERE  SALARY > 10000 ";

            result = stmt.executeUpdate( query );
        } catch ( SQLException e ) {
            System.out.println( "[statementUpdateExam()���� ������ �߻��Ͽ����ϴ�.]" );
            e.printStackTrace();
        } finally {
            try {
                if ( result > 0 )
                    returnValue = true;

                stmt.close();
            } catch ( SQLException e ) {
                System.out.println( "[statementUpdateExam()���� ������ �߻��Ͽ����ϴ�. ]" );
                e.printStackTrace();
            }
        }
        return returnValue;
    }
}
