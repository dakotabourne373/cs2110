import java.util.ArrayList;

public class SoftwareDevelopment {

	public static void main(String[] args) {
		// Create some students
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.setName("Mal");
		s2.setName("Inara");
		s3.setName("River");
		
		ArrayList<Student> roster = new ArrayList<Student>();
		roster.add(s1);
		roster.add(s2);
		roster.add(s3);
		
		
		
		
		for(int i = 0; i<roster.size(); i++) {
			Student x = roster.get(i);
			System.out.println("Student " +x.getName() + " earned a grade of " + x.getGrade());
		}
	}
}
