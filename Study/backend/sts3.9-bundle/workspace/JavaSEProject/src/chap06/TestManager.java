package chap06;

public class TestManager {

	public static void main( String[] args ) {
	    Manager m = new Manager( "������" , 50000.0, "���������" );
	    System.out.println( m.getDetails() );
 
        Manager m2 = new Manager();
        m2.setName("������"); 
        System.out.println( m2.getDetails() ); 
    }
}
 