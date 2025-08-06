package chap06;

import chap06.Employee;
import chap06.Manager;
 
public class PolyTest {
    public static void main( String[] args ){
        Employee e1 = new Employee( "Kim" , 2000 );
        Manager m1 = new Manager( "Lee" , 5000 , "�ѹ�" );
                 
        e1.displayInfo();   
        System.out.println( "===================" );
        m1.displayInfo();
        
        System.out.println( "===================" );
        System.out.println( "<<Polymorphism Test>>" );

        Employee e2 = new Manager( "Yoo" , 50000 , "����" );
        e2.displayInfo();
 
        //�ڽ� reference������ �θ� ��ü�� ����ų�� ���� - compile error 
       // Manager m2 = new Employee( "Kim" , 2000 );
        //m2.displayInfo();  
 
        System.out.println( "===================" );
        System.out.println( "<<Virtual Method Invocation>>" );
        e2.displayInfo();
        //compile �ÿ��� type�� �θ�ü �̱� ������ 
        //�ڽİ�ü���� �ִ� ��������� �޼���� ����� �� ���� 
        //e2.getDepartment();
    }     
}
