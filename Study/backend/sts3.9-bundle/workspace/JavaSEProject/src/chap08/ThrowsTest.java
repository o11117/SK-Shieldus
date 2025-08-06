/*------------------------------------------------------------------------------
 * Name : ThrowsTest
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

public class ThrowsTest {

    public static void main( String[] args ) {

        ThrowsTest t = new ThrowsTest();
         
        try {
            t.methodA(); 
            System.out.println( "���� ����" );
        } catch ( IOException e ) {
            System.out.println( "IOException �߻�" );
        } finally{
            System.out.println( "���α׷� ����" );
        }
    }

    public void methodA() throws IOException {
        methodB();
    }

    public void methodB() throws IOException {
        methodC();
    }

    public void methodC() throws IOException {
        throw new IOException();
    }
}
