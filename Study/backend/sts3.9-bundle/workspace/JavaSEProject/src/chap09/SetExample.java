/*------------------------------------------------------------------------------
 * Name : SetExample
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

import java.util.HashSet;

public class SetExample {

    public static void main( String[] args ) {

        // ���� ���� ���� �ʴ´�
        // �߰��Ǵ� �����ʹ� �����Ѵ�.
        HashSet set = new HashSet();
        set.add( "one" );
        set.add( "second" );
        set.add( "3rd" );
        set.add( new Integer( 4 ) );
        set.add( new Float( 5.0F ) );
        set.add( "second" );
        set.add( new Integer( 4 ) );
        System.out.println( set );

        set.remove( "second" );
        set.remove( new Float( 5.0F ) );
        System.out.println( set );
    }
}
