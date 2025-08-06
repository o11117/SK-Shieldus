/*------------------------------------------------------------------------------
 * Name : ExceptionTest
 * DESC : 
 * VER  : 1.0
 * PROJ : VCC SE Path
 * Copyright 2006 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   ��        ��        ��        ��
 *------------------------------------------------------------------------------
 *     DATE      AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2006. 9. 7.  ������п�  ver1.0 �ۼ�
 *----------------------------------------------------------------------------*/

package chap08;

import java.io.*;

/**
 * @author ������п�
 *
 */
public class ExceptionTest {

    /**
     * @param args
     */
    public static void main( String[] args ) {

        methodA();
        
        try {
            methodB();
        } catch ( RuntimeException e ) {
            System.out.println( "main()���� ó��" );
        }
    }
    
     public static void methodA() {
         try{
             throw new FileNotFoundException();
         } catch ( FileNotFoundException e ) {
             System.out.println( "FileNotFoundException �߻�!!" );
         } catch ( IOException e ) {
             System.out.println( "IOException �߻�!!" );  
             e.printStackTrace();
         } finally {
             System.out.println( "Finally �Դϴ�!!" );
         }
        
     }
     
     public static void methodB() throws RuntimeException {
         throw new RuntimeException();
     }
}









