package chap04;

public class IfTest {

	public static void main( String[] args ) {

		int distance = 9;
		int fee = 0;
	    String area = new String( "���" );
	    
		if( distance <= 10 ){
			
			if( area.equals( "���" ) ){
				fee = 1200;
			}else{
				fee = 800;
			}
			
		}else if( distance <= 20 ){
			fee = 900;
		}else{
			fee = 1000;
		}
		
		System.out.println( "distance : " + distance + "  fee : " + fee );
 
	}
}
