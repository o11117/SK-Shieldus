package chap10;

import java.io.*;

public class WriteSerializeTest {

    public static void main( String[] args ) {
        FileOutputStream empOutputFile = null;
        ObjectOutputStream empOutputStream = null;
        
        EmpInfo[] empList = {   new EmpInfo("11111" , "ȫ�浿"),
                                new EmpInfo("22222" , "��浿"),
                                new EmpInfo("33333" , "��浿")
                            }; 
        try{ 
            empOutputFile = new FileOutputStream( "C:/JAVA_DEV/file_test/data.ser"); // data.txt�� ���� 
            empOutputStream = new ObjectOutputStream(empOutputFile);
              
            empOutputStream.writeObject(empList);
 
            //��ü�� �ϳ��ϳ� write���� 
/*            
            empOutputStream.writeObject(empList[0]);
            empOutputStream.writeObject(empList[1]);*/
            
            empOutputStream.close();
              
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }finally{
            try {
                if( empOutputStream != null )
                    empOutputStream.close();
            } catch ( IOException e ) {
                 e.printStackTrace();
            }
        }
        
    }

}
