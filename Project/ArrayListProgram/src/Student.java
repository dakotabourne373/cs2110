public class Student {

	String name;
	String grade = "f";
	
	public Student() {
		System.out.println("Creating a student!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
