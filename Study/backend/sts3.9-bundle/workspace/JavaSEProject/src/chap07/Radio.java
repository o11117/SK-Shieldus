
package chap07;

public class Radio extends Appliance {

    public Radio( String modelNo ){
        super( modelNo );
    }
    public void volumeUp() {
        System.out.println( "���� �����" );
    }  

    public void volumeDown() {
        System.out.println( "���� ����ٿ�" );
    }
 
} 
 