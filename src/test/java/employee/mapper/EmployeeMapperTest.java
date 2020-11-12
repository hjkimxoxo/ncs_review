package employee.mapper;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import employee.config.ControllerConfig;
import employee.dto.Department;
import employee.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeMapperTest {

	private static final Log log = LogFactory.getLog(EmployeeMapperTest.class);
	
	@Autowired
	private EmployeeMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01GetLists() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Employee> list = mapper.getLists();
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02GetEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = mapper.getEmployee(4377);
		Assert.assertNotNull(emp);
	}

	//@Test
	public void test03RegisterEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = new Employee(1219, "김혜진", "사원", new Employee(4377), 2000000, new Department(2));
		int res = mapper.registerEmployee(emp);
		Assert.assertEquals(1, res);
	}

	//@Test
	public void test04ModifyEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = mapper.getEmployee(1219);
		emp.setEmpName("김혜진변경");
		emp.setTitle("부서변경");
		emp.setManager(new Employee(3426));
		emp.setSalary(2500000);
		emp.setDept(new Department(3));
		int res = mapper.modifyEmployee(emp);
		Assert.assertEquals(1, res);
	}

	//@Test
	public void test05RemoveEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee = mapper.getEmployee(1219);
		int res = mapper.removeEmployee(employee);
		Assert.assertEquals(1, res);
		System.out.println("~~~~확인~~~~");
		List<Employee> list = mapper.getLists();
		list.stream().forEach(System.out::println);
		
	}

}
