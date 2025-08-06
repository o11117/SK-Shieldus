package mylab.student.control;

import mylab.student.entity.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student student = new Student("20203049","송승준","소프트웨어",4);
		
		System.out.println("학번: " + student.getStudentId() + "이름: " + student.getName() + "전공: " + student.getMajor() + "학년: " + student.getGrade() + "학년"  );
		
		
		try {
			student.setGrade(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
