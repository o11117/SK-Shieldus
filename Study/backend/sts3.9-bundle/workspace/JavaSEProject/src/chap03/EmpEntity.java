 /**
 * Class : EmpEntity
 */
package chap03;

/**
 *  ����� ������ ��� EmpEntity Ŭ����
 *
 * @author  LG CNS ������п�
 * @version 1.0, 2005/07/01 
 */
public class EmpEntity {
    // ����� �����ϴ� �������
    private String empId;
    
    // �̸��� �����ϴ� �������
    private String name;
    
    // ��ȭ��ȣ�� �����ϴ� �������
    private String telephone;
    
    // �ּҸ� �����ϴ� �������
    private String address;
    
    // �μ��ڵ带 �����ϴ� �������
    private String deptName;
 
    /**
     * EmpEntity Ŭ������ default ������
     *
     */
    public EmpEntity() {
        
    }
    
    /**
     * ��� ������ ���� EmpEntity Ŭ������ ������
     * 
     * @param empId      ���        
     * @param name       ��� �̸�    
     * @param telephone  ��ȭ��ȣ
     * @param address    �ּ�
     * @param deptName   �μ���
     */
    public EmpEntity( String empId, String name, String telephone, String address, String deptName  ) {
        setEmpId( empId );
        setName( name );
        setTelephone( telephone );
        setAddress( address );
        setDeptName( deptName );
    }
    
    /**
     *����� ���� ���� �޼ҵ�
     *
     * @return ���
     */
    public String getEmpId() {
        return empId;
    }
    
    /**
     * ����� ���� ���� �޼ҵ�
     * 
     * @param empId ���
     */
    public void setEmpId( String empId ) {
        this.empId = empId;
    }

    /**
     * ��� �̸��� ���� ���� �޼ҵ�
     *
     * @return ��� �̸�
     */
    public String getName() {
        if ( name == null )
            return "";
        else
            return name;
    }

    /**
     * ��� �̸��� ���� ���� �޼ҵ�
     * 
     * @param name ��� �̸�
     */
    public void setName( String name ) {
        this.name = name;
    }

    /**
     * ��� ��ȭ��ȣ�� ���� ���� �޼ҵ�
     * @return ��ȭ��ȣ
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * ��� ��ȭ��ȣ�� ���� ���� �޼ҵ�
     * @param telephone ��ȭ��ȣ
     */
    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    /**
     * ��� �ּҿ� ���� ���� �޼ҵ�
     * @return �ּ�
     */
    public String getAddress() {
        return address;
    }

    /**
     * ��� �ּҿ� ���� ���� �޼ҵ�
     * @param address �ּ�
     */
    public void setAddress( String address ) {
        this.address = address;
    }

    /**
     * �μ��� ���� ���� �޼ҵ�
     * @return �μ���
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * �μ��� ���� ���� �޼ҵ�
     * @param deptName �μ���
     */
    public void setDeptName( String deptName ) {
        this.deptName = deptName;
    }
}
