package chap03;

import chap03.MyDate;

public class PassTest{

	//Method to change the current values
	public static void changeInt( int value ){
		value = 55;
	}
	
	public static void changeObjectRef( MyDate ref ){
		ref = new MyDate( 1, 1, 2000 );
	}
	
	public static void changeObjectAttr( MyDate ref ){
		ref.setDay( 4 );
	}
	
	public static void main( String[] args ) {
		MyDate date;
		int val;
		
		//Assing the int
		val = 11;
		
		//Try to change it 
		changeInt( val ) ;
		
		//What is the current value?
		System.out.println( "Int value is: " + val );
		
		//Assign the date
		date = new MyDate( 22, 7, 1964 );
		
		//Try to change it
		changeObjectRef( date );
		
		//What is the current value?
		date.print();
		
		//Now change the day attribute
		//throuth the object reference
		changeObjectAttr( date );
		
		//What is the current value?
		date.print();
	}
}