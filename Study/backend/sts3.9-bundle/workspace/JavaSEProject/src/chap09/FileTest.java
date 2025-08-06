/*------------------------------------------------------------------------------
 * Name : FileTest
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

import java.io.*;

public class FileTest {

    public static void main( String[] args ) {

        File f = new File( "C:/JAVA_DEV/file_test/text.txt" );
 
        System.out.println( "���Ͽ���: " + f.isFile() );
        System.out.println( "���丮����: " + f.isDirectory() );
        System.out.println( "�����̸�: " + f.getName() );
        System.out.println( "������ �ִ� ���丮: " + f.getParent() );
        System.out.println( "���丮 ���� �����̸�: " + f.getPath() );
        System.out.println( "����ũ��: " + f.length() + " bytes" );

        // File ����.
        File f2 = new File( "C:/JAVA_DEV/file_test/create.txt" );
        try {
            f2.createNewFile();
            System.out.println( f2.getName() + " file�� �����Ǿ����ϴ�." );
        } catch ( IOException e ) {
            System.out.println( f2.getName() + " ���� ����!!" );
        }

        // ���丮 �����.
        File f3 = new File( "C:/JAVA_DEV/file_test/temp_dir" );
        if ( !f3.exists() ) {
            f3.mkdir();
            System.out.println( f3.getName() + "directory�� �����Ǿ����ϴ�." );
        } else {
            System.out.println( f3.getName() + " directory��  �̹� �����մϴ�." );
        }

        // directory �� File ����.
/*        
        File f4 = new File( "C:/JAVA_DEV/temp_dir"  , "create.txt" );
        try {
            f4.createNewFile();
        } catch ( IOException e ) {
            System.out.println( "����!!!" );
        } 
*/ 
        // ���丮 ����Ʈ .
        File list = new File( "C:/JAVA_DEV/file_test/temp_dir" );

        String[] str = list.list();
        System.out.println( "���� ���丮 ���� ���� ����Ʈ�Դϴ�: " + list.getPath() );
        for ( int inx = 0 ; inx < str.length ; inx++ ) {
            System.out.println( str[inx] ); 
        }
    }
}
