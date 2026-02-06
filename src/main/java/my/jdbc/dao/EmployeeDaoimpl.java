package my.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	
	
	@Override
	public void creatingEmployeeTable() throws SQLException {
		
//		Statement statement = connection.createStatement();
//		statement.executeUpdate("CREATE TABLE IF NOT EXISTS employee(empId INT PRIMARY KEY, name VARCHAR(100),email VARCHAR(100),contact BIGINT,salary DOUBLE)");
//		System.out.println("Table created successfully (if not already exists).");
		
		PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS employee(empId INT PRIMARY KEY, name VARCHAR(100),email VARCHAR(100),contact VARCHAR(100),salary INT)");
		ps.executeUpdate();
		System.out.println("Table created successfully (if not already exists).");
		
	}

	@Override
	public void saveEmployeeByPs(Employee e) throws SQLException {
		
//		1.By through the PreparedStatement
//		PreparedStatement ps = connection.prepareStatement("INSERT INTO employee (empId,name,email,contact,salary) VALUES(?,?,?,?,?)");
//		ps.setInt(1,e.getId());
//		ps.setString(2,	e.getName());
//		ps.setString(3, e.getEmail());
//		ps.setString(4,e.getContact());
//		ps.setInt(5, e.getSalary());
//		ps.executeUpdate();
		
		
//2. By through the Statement
		
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO employee(empId, name, email, contact, salary) VALUES ("+ e.getId() + ", '"+ e.getName() + "', '"+ e.getEmail() + "', '" + e.getContact() + "', " + e.getSalary() + ")");
		
		System.out.println("INSERT INTO employee (empId,name,email,contact,salary) VALUES(?,?,?,?,?)");
		
	}

	@Override
	public void updateEmployee(Employee e) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("UPDATE employee SET email = ?,name=?,salary=?,contact=? WHERE empId = ?");
		ps.setString(1,e.getEmail());
		ps.setString(2, e.getName());
		ps.setInt(3,e.getSalary());
		ps.setString(4,e.getContact());
		ps.setInt(5, e.getId());
		
		ps.executeUpdate();
		System.out.println("UPDATE employee SET email = ?,name=?,salary=?,contact=? WHERE empId = ?");
	}

	@Override
	public void deleteAnEmployee(int id) throws SQLException {
	PreparedStatement ps = connection.prepareStatement("Delete from employee where empId=?");
	ps.setInt(1, id);
	ps.executeUpdate();
	
	System.out.println("Delete employee where empId=?");
		
	}

	@Override
	public void printAllEmployee() throws SQLException {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee");
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) {
			System.out.println("empId = "+resultSet.getInt(1)+"name = "+resultSet.getString(2)+"Email = "+resultSet.getString(3)+"Contact = "+resultSet.getString(4)+"Salary = "+resultSet.getInt(5));
		}
		
		System.out.println("\"empId = \"+resultSet.getInt(1)+\"name = \"+resultSet.getString(2)+\"Email = \"+resultSet.getString(3)+\"Contact = \"+resultSet.getString(4)+\"Salary = \"+resultSet.getInt(5)");
		
	}

	@Override
	public Employee getEmpById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee where empId=?");
		ps.setInt(1, id);
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		Employee e = new Employee();
		e.setId(id);
		e.setName(resultSet.getString(2));
		e.setEmail(resultSet.getString(3));
		e.setContact(resultSet.getString(4));
		e.setSalary(resultSet.getInt(5));
		
//		System.out.println("SELECT * FROM employee where empId=?");
		return e;
		
	}

	@Override
	public List<Employee> getAllEmps() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee");
		ResultSet resultSet = ps.executeQuery();
		
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
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee where name=?");
		ps.setString(1, name);
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		Employee e = new Employee();
		e.setId(resultSet.getInt(1));
		e.setName(resultSet.getString(2));
		e.setEmail(resultSet.getString(3));
		e.setContact(resultSet.getString(4));
		e.setSalary(resultSet.getInt(5));
		
//		System.out.println("SELECT * FROM employee where empId=?");
		return e;
	}

}
