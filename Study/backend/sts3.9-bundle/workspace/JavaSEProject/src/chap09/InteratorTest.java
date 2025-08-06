/*------------------------------------------------------------------------------
 * Name : InteratorTest
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

import java.util.*;

public class InteratorTest{

    public static void main( String[] args ) {

        List list = new ArrayList();
        list.add( "one" );
        list.add( "second" );
        list.add( "3rd" );
        list.add( new Integer( 4 ) );
        list.add( new Float( 5.0F ) );

        System.out.println( "List�� ����(iterator) " );
 
        Iterator it = list.iterator();

        while ( it.hasNext() ) {
            System.out.println( it.next() );
        }

        System.out.println( "List�� ����(listIterator)" );
        
        ListIterator listIt = list.listIterator();

        if ( listIt.hasNext() ) {
            System.out.println( listIt.next() );
        }

        if ( listIt.hasPrevious() ) {
            System.out.println( listIt.previous() );
        }
    }
}
