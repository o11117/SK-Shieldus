
package chap06;

public class Manager extends Employee{
    private String department;
 
    public Manager(){
    }  
    
    public Manager( String name, double salary, String department){
        super( name, salary );
        this.department = department;
    } 

    /**
     * @return Returns the department.
     */
    public String getDepartment() {
    
        return department;
    }

    /**
     * @param department The department to set.
     */
    public void setDepartment( String department ) {
    
        this.department = department;
    }
 
    public String getDetails() {
        return super.getDetails()  +     
              "\nManager of: " + department;
   }
     
    //Polymorphism �ǽ��� ���Ͽ�  �߰� 
    public void displayInfo(){
        System.out.println( "�̸�" + getName() );
        System.out.println( "����" + getSalary() );
        System.out.println( "�����μ�" + getDepartment() );        
    }

}
 