package chap04;

public class PromotionTest {

	public static void main( String[] args ) {

		long longVal = 99L;
		//int intVal1 = longVal;    // compile error
		int intVal2 = (int)longVal;  // Casting �����Ƿ� OK (������ ���� ����)
		 
	    int intVal = 128;
	    byte byteVal = (byte)intVal; // byteVal�� ����� �� ���� ����
	    
	    System.out.println( "intVal2 : " + intVal2 );	 
	    System.out.println( "byteVal : " + byteVal );	    
	} 

}
