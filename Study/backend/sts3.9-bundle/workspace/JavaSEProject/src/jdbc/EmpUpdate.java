package jdbc;

import java.sql.*;

public class EmpUpdate {
    public static void main( String args[] ) throws SQLException,
                    ClassNotFoundException {
        String url = "jdbc:oracle:thin:@192.168.0.200:1521:VCC";
        Connection conn = null;
        Statement stmt = null;
        String query = null;
        int updateCount = 0;


        // Driver ���
        Class.forName( "oracle.jdbc.driver.OracleDriver" );

        // DB Connection
        conn = DriverManager.getConnection( url, "SE17###", "SE17###" );
        
        // Auto Commit �� ���� �ʵ��� �����Ѵ�.��. commit()�� ȣ���ؾ߸� Ŀ��.
        conn.setAutoCommit( false );

        // Statement����
        stmt = conn.createStatement();
        
        String empName = "HITE" ;
        String empId = "10004";
        
         // Query ����/����
        query = "UPDATE EMP  " + 
                 "   SET LAST_NAME  =  '" + empName + "'"+ 
                 " WHERE  ID =  '" + empId + "'";  
        System.out.println( query );
        updateCount = stmt.executeUpdate(query);
        System.out.println( "������Ʈ�� ���� ���� : " + updateCount );

        conn.commit();// cf) conn.rollback();
        stmt.close();
        conn.close();
    }
}