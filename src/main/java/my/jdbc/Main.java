package my.jdbc;

import java.sql.SQLException;

import my.jdbc.dao.EmployeeDao;
import my.jdbc.dao.EmployeeDaoimpl;
import my.jdbc.model.Employee;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Employee e = new Employee(1,"Rahul Kumar","rahulkusaiya456@gmail.com","6204923300",30000);
		EmployeeDao empDao = new EmployeeDaoimpl();
		
//		------------------------------------------------------ Creation of the Table -------------------------------
//		empDao.creatingEmployeeTable();
		
		//Employee Save Method
//		empDao.saveEmployeeByPs(e);
		
		//update the table
//		empDao.updateEmployee(e);
		
		// Delete employee by id
//		empDao.deleteAnEmployee(3);
		
		
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
//		System.out.println(empDao.getEmpByName("Rahul Kumar"));
		//or
//		Employee emp = empDao.getEmpByName("Rahul Kumar");
//		System.out.println(emp);
		
		
		
//		SQL INJETION 
		
		
		
		// Get EmployeeByName
//		System.out.println(empDao.getEmpByName("Rahul Kumar"));
		//or
//		Employee emp = empDao.getEmpByNameSQL("Rahul kumar");
//		Employee emp = empDao.getEmpByNameSQL("Rahul");
		Employee emp = empDao.getEmpByNameSQL("Rahul' OR '1'='1");
		System.out.println(emp);
		
		
		
		
		
	}

}
