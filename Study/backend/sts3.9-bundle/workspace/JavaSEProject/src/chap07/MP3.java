package chap07;

public class MP3 extends Appliance implements Recording{
    
    public MP3( String modelNo){
        super(modelNo);
    }

    public void volumeUp() {
        System.out.println( "MP3 �����" );
    }
 
    public void volumeDown() {
        System.out.println( "MP3 ����ٿ�" );
    }

    //interface �ǽ��� ���� ��� 
    public void startRecord() {
        System.out.println( START_MSG );
    }

    public void stopRecord() {
        System.out.println( END_MSG );
    }
 
 }
   