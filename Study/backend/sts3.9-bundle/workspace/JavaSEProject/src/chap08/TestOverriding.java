/*------------------------------------------------------------------------------
 * Name : TestOverriding
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

package chap08;

import java.io.IOException;

/**
 * @author ������п� 
 *
 */
public class TestOverriding {

    /**
     * @param args
     */
    public static void main( String[] args ) {

        SuperClass superClass = new SubClass();

        try {
            superClass.method(); //�ڽ�Ŭ������ Exception �߻�
        } catch ( IOException ioe ) { // Exception�� ���� �� ����.
            System.out.println( "IOException occured!") ;
        }
   
    } 

}
