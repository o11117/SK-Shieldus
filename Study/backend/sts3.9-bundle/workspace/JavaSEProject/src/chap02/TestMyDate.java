package chap02;

import chap02.MyDate;

public class TestMyDate{
 
	public static void main( String[] args ){
	
    /*	
        MyDate date = new MyDate();
        date.setDay( 5 );
        date.setDay( date.getDay() + 1 );

        date.setMonth( 2 );

        date.setYear( 2007 );

        System.out.println( date.getYear() + "�� " + 
	      					date.getMonth() + "�� " + 
	      					date.getDay() + "�� �Դϴ�." ) ;
	      					
        */	  

	  MyDate date = new MyDate( 6, 2, 2007 );
         System.out.println( date.getDay() );
	  MyDate date2 = new MyDate();

    }
}