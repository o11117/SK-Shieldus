public class TestMovie {
	public static void main( String[] args ) {
    	   Movie m1 = new Movie();
          m1.setTitle( "ŷ��2" );
          m1.playMovie() ;
          String title = m1.getTitle();
          System.out.println( "��ȭ ������ " + 
                                      title + "�Դϴ�.");
    }
}