package chap05;

public class TestArray {
	public static void main( String[] args ) {
		//primitive �迭
		System.out.println( "1. primitive �迭 ���� ����" );
		int[] numbers = null; 

		numbers = new int[10];
 
		for ( int inx = 0; inx < numbers.length; inx++ ) {
			numbers[inx] = inx + 1;
			System.out.println( numbers[inx] );
		}

		//reference ���� �迭 ���� ����  
		 System.out.println( "2. reference ���� �迭 ���� ����" );
		 MyDate[ ] dates = null;
		 dates = new MyDate[10];
		 dates[0] = new MyDate( 5, 2, 2007 );
		 dates[1] = new MyDate( 6, 2, 2007 );
		 dates[2] = new MyDate( 7, 2, 2007 );
		 dates[3] = new MyDate( 8, 2, 2007 );
		 dates[4] = new MyDate( 9, 2, 2007 );
		 dates[5] = new MyDate( 10, 2, 2007 );
		 dates[6] = new MyDate( 11, 2, 2007 );
		 dates[7] = new MyDate( 12, 2, 2007 );
		 dates[8] = new MyDate( 13, 2, 2007 );
		 dates[9] = new MyDate( 14, 2, 2007 );
		  
		 System.out.println( "1�� : " + dates[0].getDay() );
		 
		 //	access
		 dates[1].setDay( 4 );
		 System.out.println( "2�� : " + dates[1].getDay() );

		 for( int inx = 0; inx < dates.length; inx++ ){
			 dates[inx].print();
		 }

		//������ ���ÿ� �ʱ�ȭ ����
		 System.out.println( "3. ������ ���ÿ� �ʱ�ȭ ����" );

		 MyDate[ ] dates2 = {
				 new MyDate( 5, 2, 2007 ),
				 new MyDate( 6, 2, 2007 ),
				 new MyDate( 7, 2, 2007 )
		 };
		 
		 for( int inx = 0; inx < dates2.length; inx++ ){
			 dates2[inx].print(); 
		 }  

			// �Ʒ��� ���� ����ؼ��� �ȵȴ�.
		 /*
		 int[] num2;
		 num2 = {1, 2, 3};

		 MyDate[ ] dates3;
		 
		 dates3 = {
				 new MyDate( 5, 2, 2007 ),
				 new MyDate( 6, 2, 2007 ),
				 new MyDate( 7, 2, 2007 )
		 };
		 */
		 
	} 
}
