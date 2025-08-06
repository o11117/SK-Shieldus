/*------------------------------------------------------------------------------
 * Name : TestStringBuffer
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

public class TestStringBuffer {
    public static void main( String[] args ) {

        StringBuffer sb = new StringBuffer( "ROM" );

        System.out.println( sb );
        System.out.println( sb.append( "A" ) );
        System.out.println( sb.insert( 3, "R" ) );
        System.out.println( sb.reverse() );
        
        String s = sb.toString();
        
        System.out.println( s ); 
        
        StringBuffer sb1 = new StringBuffer( "LG CNS" );
        StringBuffer sb2 = new StringBuffer( "LG CNS" );
        String str = "LG CNS";

        if ( sb1.equals( sb2 ) ) {
            System.out.println( "sb1 �� sb2�� ���� ���ڿ��̴�" );
        } else {
            System.out.println( "sb1 �� sb2�� �ٸ� ���ڿ��̴�" );
        }
        
        if ( sb1.toString().equals( sb2.toString() ) ) {
            System.out.println( "sb1 �� sb2�� ���� ���ڿ��̴�" );
        } else {
            System.out.println( "sb1 �� sb2�� �ٸ� ���ڿ��̴�" );
        }

        if ( str.equals( sb1 ) ) {
            System.out.println( "sb �� str�� ���� ���ڿ��̴�" );
        } else {
            System.out.println( "sb �� str�� �ٸ� ���ڿ��̴�" );
        }
        
        if ( str.equals( sb1.toString() ) ) {
            System.out.println( "sb �� str�� ���� ���ڿ��̴�" );
        } else {
            System.out.println( "sb �� str�� �ٸ� ���ڿ��̴�" );
        }
        
        if ( str.contentEquals( sb1 ) ) {
            System.out.println( "sb �� str�� ���� ���ڿ��̴�" );
        } else {
            System.out.println( "sb �� str�� �ٸ� ���ڿ��̴�" );
        }
        

    }
}
