package my.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;

import my.jdbc.dao.EmployeeDao;
import my.jdbc.dao.EmployeeDaoimpl;
import my.jdbc.model.Employee;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Employee e = new Employee(6,"JayNarayan Thakur","JayNarayanksp011@gmail.com","8271433469",45456565);
		EmployeeDao empDao = new EmployeeDaoimpl();
		
		// This is for the Creation of the Table if Doesn't Exist in the database
//		empDao.creatingEmployeeTable();
		
		//Employee Save Method
//		empDao.saveEmployeeByPs(e);
		
		//update the table
//		empDao.updateEmployee(e);
		
		// Delete employee by id
//		empDao.deleteAnEmployee(2);
		
		
		// PrintAll Employee at a time
//		empDao.printAllEmployee();
		
//		Employee emp = empDao.getEmpById(1);
//		System.out.println(emp);
		
		
		
//		get all employee in list
//		System.out.println(empDao.getAllEmps());
		
//		or
//		ArrayList<Employee> lists = (ArrayList<Employee>) empDao.getAllEmps();
//		for(Employee emp:lists) {
//			System.out.println(emp);
//		}
		
		
		
		
		
		// Get EmployeeByName
//		System.out.println(empDao.getEmpByName("Rahul thakur"));
		//or
		Employee emp = empDao.getEmpByName("Rahul thakur");
		System.out.println(emp);
		
	}

}
