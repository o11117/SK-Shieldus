package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) throws InvalidGradeException {
		Student student = new Student("20203049","�۽���","����Ʈ����",4);
		
		System.out.println("�й�: " + student.getStudentId() + "\n�̸�: " + student.getName() + "\n����: " + student.getMajor() + "\n�г�: " + student.getGrade() + "�г�"  );
		
		
		try {
			System.out.println("5�г� ���� �õ�");
			student.setGrade(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
