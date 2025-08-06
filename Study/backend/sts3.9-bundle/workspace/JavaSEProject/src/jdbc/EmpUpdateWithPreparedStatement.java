package jdbc;

import java.sql.*;

public class EmpUpdateWithPreparedStatement {
    public static void main( String args[] ) 
              throws SQLException, ClassNotFoundException {
        String url = "jdbc:oracle:thin:@192.168.0.200:1521:VCC";
        Connection conn = null;
        PreparedStatement pstmt = null;
        String query = null;
        int updateCount = 0;

        // Driver ���
        Class.forName( "oracle.jdbc.driver.OracleDriver" );

        // DB Connection
        conn = DriverManager.getConnection( url, "SE17###", "SE17###" );
        
        // Auto Commit �� ���� �ʵ��� �����Ѵ�.��. commit()�� ȣ���ؾ߸� Ŀ��.
        conn.setAutoCommit( false );

        // Statement����
        query = "UPDATE EMP  " + 
                "   SET LAST_NAME  = ? " + 
                " WHERE  ID = ? ";

        pstmt = conn.prepareStatement( query );

        pstmt.setString( 1, "HITE" );
        pstmt.setString( 2, "10004" );

        // Query ����/����
        updateCount = pstmt.executeUpdate();
        System.out.println( "������Ʈ�� ���� ���� : " + updateCount );
        
        conn.commit();
        
        // �ݱ�
        pstmt.close();
        conn.close();
    }
}