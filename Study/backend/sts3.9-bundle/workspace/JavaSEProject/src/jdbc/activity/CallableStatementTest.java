package jdbc.activity;

/*
create or replace function get_doday_func( day_plus in NUMBER ) 
return VARCHAR2 
is Result1 VARCHAR2(100); 
   Result2 VARCHAR2(100); 
begin SELECT TO_CHAR(sysdate,'YYYY-MM-DD' ), TO_CHAR((sysdate + day_plus),'YYYY-MM-DD')
   into Result1, Result2 
   from dual; 
   
   return(Result1 ||'___' ||Result2 ); 
end;
*/
import java.sql.*;

public class CallableStatementTest {

    String url = "jdbc:oracle:thin:@192.168.0.200:1521:VCC";
    String user = "SE17###";
    String passwd = "SE17###";
 
    private Connection conn;

    public CallableStatementTest() {

        try {
            Class.forName( "oracle.jdbc.driver.OracleDriver" );
            conn = DriverManager.getConnection( url, user, passwd );
            System.out.println( "[Message] : DB Successfully Connected!" );
            conn.setAutoCommit( false );
        } catch ( SQLException e ) {
            System.out.println( "[DB Ŀ�ؼ� ���ῡ ������ �߻��Ͽ����ϴ�. ]" );
            e.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            System.out.println( "[JDBC ����̹� ������ ������ �ֽ��ϴ�. ]" );
            e.printStackTrace();
        }
    }

    /**
     * Connection ��ü�� ��´�.
     * 
     * @return Connection ��ü�� Return.
     */
    public Connection getConnection() {

        return conn;
    }
    
    /**
     * Conncetion Close
     */
    public void closeConnection() {

        try {
            if ( conn != null ) {
                conn.close();
                System.out.println( "[Message] : DB Successfully Closed!" );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }

    }

    /**
     * Statement ��ü�� �̿��� �⺻���� Select ����
     */
    public void useCallableStatement() {

        CallableStatement csmt = null;
        String query = null;

        try {
            query = "{ ? = call get_doday_func(?) }";
            csmt = conn.prepareCall( query );

            csmt.setInt( 2, 5 );
            csmt.registerOutParameter( 1, Types.VARCHAR );
            csmt.execute();

            System.out.println( "��� : " + csmt.getString( 1 ) );
        } catch ( SQLException e ) {
            System.out.println( "[CallableStatement ���࿡ ������ �߻��Ͽ����ϴ�.]" );
            e.printStackTrace();
        } finally {
            try {
                if ( csmt != null ) {
                    csmt.close();
                }
            } catch ( SQLException e ) {
                System.out.println( "[CallableStatement.close() ȣ��� ������ �߻��Ͽ����ϴ�. ]" );
                e.printStackTrace();
            }
        }
    }

    /**
     * main method
     * 
     * @param args
     */
    public static void main( String[] args ) {

        CallableStatementTest db = new CallableStatementTest();
        db.useCallableStatement();
        db.closeConnection();
    }
}
