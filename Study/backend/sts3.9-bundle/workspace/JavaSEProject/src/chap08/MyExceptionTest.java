/*------------------------------------------------------------------------------
 * Name : MyExceptionTest
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
   
public class MyExceptionTest extends Exception{
    public static void main(String[] args){
        int age = 18;
        
        try{
            if ( age < 19 ){
                throw new MyException( "����Ұ�." );
                        
            }else{
                System.out.println( "��̰� �����ϼ���~" );
            }  
        } catch( MyException me ){
            System.out.println( "MyException �߻� : " + me );
        } finally{
            System.out.println( "��~" );
        }
    }
}