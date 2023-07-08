package com.saksoftcrud.service;

import com.saksoftcrud.entity.Employee;
import com.saksoftcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    public Employee saveEmployee(Employee employee){
        return empRepo.save(employee);
    }

    public List<Employee> getEmployee(){
        return empRepo.findAll();
    }

    public Employee getEmployeeById(Integer id){
        return empRepo.findById(id).orElse(null);
    }

    public String deleteEmployee(Integer id){
        empRepo.deleteById(id);
        return "Employee Data Removed with : "+ id +" Succefully";
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee=empRepo.findById(employee.getId()).orElse(null);
        existingEmployee.setId(employee.getId());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAge(employee.getAge());
        return empRepo.save(existingEmployee);
    }


}
