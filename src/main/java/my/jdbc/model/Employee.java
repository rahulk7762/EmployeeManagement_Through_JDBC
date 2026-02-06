package my.jdbc.model;

public class Employee {

	private  int id,salary;
	private String name,email,contact;
	
	public Employee() {
		// Non-Parameterized Constructor
	}
	
	public Employee(int id,String name,String email,String contact,int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + ", email=" + email + ", contact="
				+ contact + "]";
	}


	
	
}
