package employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.dto.Employee;
import employee.exception.DuplicateMemberException;
import employee.mapper.EmployeeMapper;
import employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	static final Log log = LogFactory.getLog(EmployeeServiceImpl.class);
		
	@Autowired
	private EmployeeMapper mapper;
	
	
	@Override
	public List<Employee> getLists() {
		List<Employee> list = mapper.getLists();
		return list;
	}

	@Override
	public Employee getEmployee(int empNo) {
		return mapper.getEmployee(empNo);
	}

	@Override
	public int registerEmployee(Employee employee) {
		List<Employee> list = mapper.getLists();
		List<Integer> noList = new ArrayList<Integer>();
		for(Employee emp:list) {
			int no = emp.getEmpNo();
			noList.add(no);
		}
		System.out.println("사원번호: " + noList);
		if(noList.contains(employee.getEmpNo())){
			throw new DuplicateMemberException("사원번호 중복");
		}
		
		return mapper.registerEmployee(employee);	
	}

	@Override
	public int modifyEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return mapper.modifyEmployee(employee);
	}

	@Override
	public int removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return mapper.removeEmployee(employee);
	}
	
}
