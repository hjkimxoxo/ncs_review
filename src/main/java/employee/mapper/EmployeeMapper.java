package employee.mapper;

import java.util.List;

import employee.dto.Employee;

public interface EmployeeMapper {
	List<Employee> getLists(); 
	Employee getEmployee(int empNo);
	int registerEmployee(Employee employee);
	int modifyEmployee(Employee employee); 
	int removeEmployee(Employee employee);
}
