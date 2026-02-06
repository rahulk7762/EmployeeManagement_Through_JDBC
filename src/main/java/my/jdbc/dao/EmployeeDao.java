package my.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import my.jdbc.model.Employee;

public interface EmployeeDao {
	
	public void creatingEmployeeTable() throws SQLException;
	
	public void saveEmployeeByPs(Employee e)throws SQLException;

	public void updateEmployee(Employee e) throws SQLException;

	public void deleteAnEmployee(int id) throws SQLException ;

	public void printAllEmployee() throws SQLException;

	public Employee getEmpById(int id)throws SQLException;
	
	public List<Employee> getAllEmps()throws SQLException;

	public Employee getEmpByName(String name)throws SQLException;


}
