package com.saksoftcrud.controller;

import com.saksoftcrud.entity.Employee;
import com.saksoftcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empService;
    
	/* Adding Employee */
    
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
    	System.out.println("Employee adding");
        return empService.saveEmployee(employee);
    }
    
	/* Get ALl Employee Details */
    @GetMapping("/getEmployee")
    public List<Employee> findEmployee(){
        return empService.getEmployee();
    }
    
	/* Get A Specefic Employee by Id */
    @GetMapping("/getEmployee/{id}")
    public Employee findEmployeeById(@PathVariable Integer id){
        return empService.getEmployeeById(id);
    }
    
	/* Updating Employee Details */
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return empService.updateEmployee(employee);
    }
    
	/* Deleting Employee */
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return empService.deleteEmployee(id);
    }
}
