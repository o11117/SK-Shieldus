/*------------------------------------------------------------------------------
 * Name : TestRuntimeExcepiton
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

public class TestRuntimeExcepiton{
    
    public static void main( String[] args ) {
       
        // ArithmeticException        
            
        int a = 0;
        int b = 10;
        
        if( a != 0){
            b= b /a;         
        }
        
       // NullPointerException
        
        MyDate m = null;
        m.getDay();
        
        
        // NegativeArraySizeException
/*        
        int[] numbers = new int[-1];
        
*/        
        // ArrayIndexOutOfBoundsException
        
        int[] numbers = new int[10];
        numbers[numbers.length-1] = 10;
        
        
        // ClassCastException
/*        
        Employee e = new Employee();
        Manager m = (Manager)e;
        
*/                
    }
}
