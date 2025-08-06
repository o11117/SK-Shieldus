package chap10;

import java.io.*;

public class ReadSerializeTest {

    public static void main( String[] args ) {
        FileInputStream empInputFile = null;
        ObjectInputStream empInputStream = null;
         
        try{
            empInputFile = new FileInputStream("C:/JAVA_DEV/file_test/data.ser");
            empInputStream = new ObjectInputStream(empInputFile);
            
           EmpInfo[] readList = (EmpInfo[])empInputStream.readObject();

            for ( int inx = 0; inx < readList.length; inx++ ){
                System.out.println( "��� : " + readList[inx].getEmpId() +
                                    " �̸� : " + readList[inx].getName());
            }
                 
        //��ü�� �ϳ��ϳ� �д� �͵� ����    
/*            
            EmpInfo emp = (EmpInfo)empInputStream.readObject();
            EmpInfo emp2 = (EmpInfo)empInputStream.readObject();
   
            
            System.out.println( "��� : " + emp.getEmpId() +
                    " �̸� : " + emp.getName());
            System.out.println( "��� : " + emp2.getEmpId() +
                    " �̸� : " + emp2.getName());
*/
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
        
    }

}
