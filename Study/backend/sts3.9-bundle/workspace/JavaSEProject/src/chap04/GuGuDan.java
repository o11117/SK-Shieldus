/*------------------------------------------------------------------------------
 * Name : GuGuDan
 * DESC : 
 * VER  : 1.0
 * PROJ : VCC SE Path
 * Copyright 2006 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   ��        ��        ��        ��
 *------------------------------------------------------------------------------
 *     DATE        AUTHOR                       DESCRIPTION
 *-------------  ----------  --------------------------------------------------- 
 * 2006. 2. 15.  ������п�  ver1.0 �ۼ�
 *----------------------------------------------------------------------------*/

package chap04;


public class GuGuDan {
    public static void main( String[] args ) {
        
        for ( int inx = 2 ; inx <= 9 ; inx++ ) {
            for ( int jnx = 1 ; jnx <= 9 ; jnx ++ ) {
                System.out.print( inx + "*" + jnx + "=" + ( inx*jnx ) + '\t');
            }
            System.out.println();
        }
    }
}
