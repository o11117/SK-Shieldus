
package chap04;

public class ScopeExample {
    private int i = 1;

    public void firstMethod() {

        int i = 4, j = 5; 

        this.i = i + j;
        System.out.println( "firstMethod()�� ���� ���� i ==> " + i );
        System.out.println( "firstMethod()������ this.i  ==> " + this.i );

        secondMethod( 7 );
    }

    public void secondMethod( int i ) {

        int j = 8;

        this.i = i + j;
        System.out.println( "secondMethod()�� ���� ���� i ==> " + i );
        System.out.println( "secondMethod()������ this.i  ==> " + this.i );
    }
}
