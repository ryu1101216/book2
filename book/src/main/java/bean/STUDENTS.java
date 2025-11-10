package bean;

public class STUDENTS implements java.io.Serializable {

	private int student_id;
	private String name;
	private int age;
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String ClassName) {
		this.className = ClassName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}