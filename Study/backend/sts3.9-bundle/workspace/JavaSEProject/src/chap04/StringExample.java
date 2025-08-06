
package chap04;

public class StringExample {
  
    public static void main( String[] args ) {

        String str1 = "LG CNS";
        String str2 = new String( "LG CNS" );
        String str3 = "lg cns";

        // ���� ���ڿ����� �� equals()
        if ( str1.equals( str2 ) ) {
            System.out.println( "str1 �� str2�� ���� ���ڿ��̴�" );
        } else {
            System.out.println( "str1 �� str2�� �ٸ� ���ڿ��̴�" );
        }
  
        // ���� ���ڿ����� �� equals()
        if ( str1.equals( str3 ) ) {
            System.out.println( "str1 �� str3�� ���� ���ڿ��̴�" );
        } else {
            System.out.println( "str1 �� str3�� �ٸ� ���ڿ��̴�" );
        }

        // ��ҹ��� ���� ���� ���ڿ� �� equalsIgnoreCase()
        if ( str1.equalsIgnoreCase( str3 ) ) {
            System.out.println( "str1 �� str3�� ���� ���ڿ��̴�" );
        } else {
            System.out.println( "str1 �� str3�� �ٸ� ���ڿ��̴�" );
        }

        // ���ڿ� ũ�� �� compareTo()
        if ( str1.compareTo( str3 ) == 0 ) {
            System.out.println( "str1 �� str3�� ���� ���ڿ��̴�" );
        } else if ( str1.compareTo( str3 ) > 0 ) {
            System.out.println( "str1 �� str3���� ũ��" );
        } else {
            System.out.println( "str1 �� str3���� �۴�." );
        }
    }
}
