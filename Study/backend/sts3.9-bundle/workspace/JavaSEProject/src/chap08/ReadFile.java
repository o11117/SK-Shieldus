/*------------------------------------------------------------------------------
 * Name : ReadFile
 * DESC : 
 * VER  : 1.0
 * PROJ : VCC SE Path
 * Copyright 2006 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   ��        ��        ��        ��
 *------------------------------------------------------------------------------
 *     DATE      AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2006. 9. 6.  ������п�  ver1.0 �ۼ�
 *----------------------------------------------------------------------------*/

package chap08; 

import java.io.*;

/**
 * @author ������п�
 *
 */
public class ReadFile {
    public static void main ( String [] args ) {
        BufferedReader in = null;
        try { 
            in = new BufferedReader( new FileReader( "c:/data/test.txt" ) );  
            String s;
            while ( ( s = in.readLine() ) != null ) 
                System.out.println( s );  
        } catch ( FileNotFoundException e ) {
            System.out.println("������ �����ϴ�.");   
        } catch ( IOException e ) {          
            e.printStackTrace();   
        } finally {       
            try {          
                if ( in != null )         
                    in.close(); 
            } catch ( IOException e ) { }    
        } 
    }
}

