package chap04;

public class CastingTest {
 
	public static void main( String[] args ) {

		short a, b, c;
		a = 1;
		b = 2;

		// int ���� ���� data type ������ ���� ����� int
		//c = a + b;

		c = (short) ( a + b );

		// casting �� ������ ����
		//c = (short)a + b;

		// local ������ ��� ���� check
		System.out.println( c );
	}

}
