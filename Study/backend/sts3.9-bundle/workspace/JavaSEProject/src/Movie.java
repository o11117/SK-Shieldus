public class Movie {
    public String title = "ŷ��";
    public String director = "���� �轼";
    public String starring = "������ ����";
    public int rating = 15;

    public void setTitle( String newTitle ) {
         title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    public void playMovie() {
         System.out.println( title +
                                     "�� ���մϴ�.");
    }

}