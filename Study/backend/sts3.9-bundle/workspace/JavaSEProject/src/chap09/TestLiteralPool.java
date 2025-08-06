/*------------------------------------------------------------------------------
 * Name : TestLiteralPool
 * DESC : 
 * VER  : 1.0
 * PROJ : VCC SE Path
 * Copyright 2006 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   ��        ��        ��        ��
 *------------------------------------------------------------------------------
 *     DATE      AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2006. 8. 4.  ������п�  ver1.0 �ۼ�
 *----------------------------------------------------------------------------*/

package chap09;

public class TestLiteralPool {

    public static void main( String[] args ) {

        String str1 = "LG CNS";
        String str2 = "LG CNS";
        String str3 = new String( "LG CNS" );
        String str4 = new String( "LG CNS" );
                
        if ( str1 == str2 ) {
            System.out.println( "str1 �� str2�� ���� ��ü�̴�" );
        } else {
            System.out.println( "str1 �� str2�� �ٸ� ��ü�̴�" );
        }

        if ( str2 == str3 ) {
            System.out.println( "str2 �� str3�� ���� ��ü�̴�" );
        } else {
            System.out.println( "str2 �� str3�� �ٸ� ��ü�̴�" );
        }

        if ( str3 == str4 ) {
            System.out.println( "str3 �� str4�� ���� ��ü�̴�" );
        } else {
            System.out.println( "str3 �� str4�� �ٸ� ��ü�̴�" );
        }
        
        if ( str1.equals( str4 ) ) {
            System.out.println( "str1 �� str4�� ���� ���ڿ��̴�" );
        } else {
            System.out.println( "str1 �� str4�� �ٸ� ���ڿ��̴�" );
        }
        
    }
}
 