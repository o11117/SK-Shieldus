/*------------------------------------------------------------------------------
 * Name : MathTest
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

public class MathTest {

    public static void main( String[] args ) {
        
        System.out.println( "�ø�( 5.7 ) : "  + Math.ceil( 5.7 ) );
        System.out.println( "����( 5.7 ) : "  + Math.floor( 5.7 ) );
        System.out.println( "�ݿø�( 5.7 ) : "  + Math.round( 5.7 ) );
        System.out.println( "�ּҰ�( 3, 5 ) : "  + Math.min( 3, 5 ) );
        System.out.println( "�ִ밪( 3, 5 ) : " + Math.max( 3, 5 ) );
        System.out.println( "������( 4 ) : " + Math.sqrt( 4 ) );
        System.out.println( "Random : " + Math.random() );
        
    }
}
