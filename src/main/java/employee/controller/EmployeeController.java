package employee.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.dto.Employee;
import employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	//리스트
	@GetMapping
	public ResponseEntity<Object> list(){
		List<Employee> list = service.getLists();
		list.stream().forEach(System.out::println);
		System.out.println("리스트");
		return ResponseEntity.ok(service.getLists());
	}
	
	//정보
	@GetMapping("/{empNo}")
	public ResponseEntity<Object> getEmployee(@PathVariable int empNo, HttpServletResponse response){
		Employee employee = service.getEmployee(empNo);
		if(employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(employee);
	}
	
	//추가
	@PostMapping
	public ResponseEntity<Object> registerEmp(@RequestBody Employee employee){
		service.registerEmployee(employee);
		System.out.println("등록:" + employee);
		URI uri = URI.create("/api/employees"+employee.getEmpNo());
		return ResponseEntity.created(uri).body(employee.getEmpNo());
	}
	
	//수정
	@PutMapping("/{empNo}")
	public ResponseEntity<Object> updateEmp(@PathVariable int empNo, @RequestBody Employee employee){
		System.out.println("수정:" + employee);
		return ResponseEntity.ok(service.modifyEmployee(employee));
	}
	
	//삭제 
	@DeleteMapping("/{empNo}")
	public ResponseEntity<Object> deleteEmp(@PathVariable int empNo){
		System.out.println("삭제:" + empNo);
		Employee emp = service.getEmployee(empNo);
		return ResponseEntity.ok(service.removeEmployee(emp));
	}
}
