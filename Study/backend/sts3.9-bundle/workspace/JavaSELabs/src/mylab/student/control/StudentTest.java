package mylab.student.control;

import mylab.student.entity.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student student = new Student("20203049","�۽���","����Ʈ����",4);
		
		System.out.println("�й�: " + student.getStudentId() + "�̸�: " + student.getName() + "����: " + student.getMajor() + "�г�: " + student.getGrade() + "�г�"  );
		
		
		try {
			student.setGrade(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
