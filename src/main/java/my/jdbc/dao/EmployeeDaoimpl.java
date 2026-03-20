package my.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import my.jdbc.model.Employee;

public class EmployeeDaoimpl implements EmployeeDao  {

	private static Connection connection;
	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static final String UPDATE_QUERY = "update employee set name = '%s' , email = '%s', contact = '%s', salary = %d where empId = %d";
	public static final String DELETE_QUERY = "delete from employee where empId=%d";
	public static final String SELECT_BY_NAME_QUERY = "SELECT * FROM employee where name = '%s'";
	public static final String SELECT_BY_NAME_QUERY_SQL_INJECTION  = "SELECT * FROM employee where name = '%s'";
	
	
	
	@Override
	public void creatingEmployeeTable() throws SQLException {
		
		Statement statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS employee(empId INT PRIMARY KEY, name VARCHAR(100),email VARCHAR(100),contact BIGINT,salary DOUBLE)");
		System.out.println("Table created successfully (if not already exists).");
	}

	@Override
	public void saveEmployeeByPs(Employee e) throws SQLException {		
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO employee(empId, name, email, contact, salary) VALUES ("+ e.getId() + ", '"+ e.getName() + "', '"+ e.getEmail() + "', '" + e.getContact() + "', " + e.getSalary() + ")");
		
		System.out.println("INSERT INTO employee (empId,name,email,contact,salary) VALUES(?,?,?,?,?)");
		
	}

	@Override
	public void updateEmployee(Employee e) throws SQLException {	
		Statement statement = connection.createStatement();
		statement.executeUpdate(String.format(UPDATE_QUERY, e.getName(),e.getEmail(),e.getContact(),e.getSalary(),e.getId()));
		
		
		System.out.println("UPDATE_QUERY, e.getName(),e.getEmail(),e.getContact(),e.getSalary(),e.getId())");
	}

	@Override
	public void deleteAnEmployee(int id) throws SQLException {
	Statement statement = connection.createStatement();
	statement.executeUpdate(String.format(DELETE_QUERY,id));
	
	System.out.println("Delete Query by id");
		
	}

	@Override
	public void printAllEmployee() throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
		
		while(resultSet.next()) {
			System.out.println("empId = "+resultSet.getInt(1)+"name = "+resultSet.getString(2)+"Email = "+resultSet.getString(3)+"Contact = "+resultSet.getString(4)+"Salary = "+resultSet.getInt(5));
		}
		
		System.out.println("\"empId = \"+resultSet.getInt(1)+\"name = \"+resultSet.getString(2)+\"Email = \"+resultSet.getString(3)+\"Contact = \"+resultSet.getString(4)+\"Salary = \"+resultSet.getInt(5)");
		
	}

	@Override
	public Employee getEmpById(int id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM employee where empId="+id);
		resultSet.next();
		Employee e = new Employee();
		e.setId(id);
		e.setName(resultSet.getString(2));
		e.setEmail(resultSet.getString(3));
		e.setContact(resultSet.getString(4));
		e.setSalary(resultSet.getInt(5));
		
		System.out.println("SELECT * FROM employee where empId="+id);
		return e;
		
	}

	@Override
	public List<Employee> getAllEmps() throws SQLException {
		// TODO Auto-generated method stub
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
		
		ArrayList<Employee> listOfEmps = new ArrayList<>();
		while(resultSet.next()) {
			Employee e = new Employee();
			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setEmail(resultSet.getString(3));
			e.setContact(resultSet.getString(4));
			e.setSalary(resultSet.getInt(5));
			
			listOfEmps.add(e);
		}
		
		
		System.out.println("SELECT * FROM employee");
		return listOfEmps;
	}

	@Override
	public Employee getEmpByName(String name) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format(SELECT_BY_NAME_QUERY,name));
		resultSet.next();
		Employee e = new Employee();
		e.setId(resultSet.getInt(1));
		e.setName(resultSet.getString(2));
		e.setEmail(resultSet.getString(3));
		e.setContact(resultSet.getString(4));
		e.setSalary(resultSet.getInt(5));
		return e;
	}
	
	@Override
	public Employee getEmpByNameSQL(String name) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format(SELECT_BY_NAME_QUERY_SQL_INJECTION,name));
		resultSet.next();
		Employee e = new Employee();
		e.setId(resultSet.getInt(1));
		e.setName(resultSet.getString(2));
		e.setEmail(resultSet.getString(3));
		e.setContact(resultSet.getString(4));
		e.setSalary(resultSet.getInt(5));
		return e;
	}

}
