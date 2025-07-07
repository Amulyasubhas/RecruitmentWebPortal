package com.recruit.springboot.RecruitmentWebPortal.serviceimpl;



import com.recruit.springboot.RecruitmentWebPortal.DTO.EmployeeDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.Employee;
import com.recruit.springboot.RecruitmentWebPortal.repository.EmployeeRepository;
import com.recruit.springboot.RecruitmentWebPortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // @Override
    // public String addEmployee(EmployeeDTO dto) {
    //     Employee emp = new Employee();
    //     emp.setName(dto.getName());
    //     emp.setEmail(dto.getEmail());
    //     emp.setPassword(dto.getPassword());
    //     employeeRepository.save(emp);
    //     return "Employee added successfully!";
    // }
    @Override
public String addEmployee(EmployeeDTO dto) {
    // Check if email already exists
    if (employeeRepository.findByEmail(dto.getEmail()).isPresent()) {
        return "Employee with this email already exists!";
    }

    Employee emp = new Employee();
    emp.setName(dto.getName());
    emp.setEmail(dto.getEmail());
    emp.setPassword(dto.getPassword());
    employeeRepository.save(emp);
    return "Employee added successfully!";
}


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public String updateEmployee(Long id, EmployeeDTO dto) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(dto.getName());
            emp.setEmail(dto.getEmail());
            emp.setPassword(dto.getPassword());
            employeeRepository.save(emp);
            return "Employee updated!";
        }).orElse("Employee not found!");
    }

    @Override
    public String deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Deleted successfully!";
        }
        return "Employee not found!";
    }
}
