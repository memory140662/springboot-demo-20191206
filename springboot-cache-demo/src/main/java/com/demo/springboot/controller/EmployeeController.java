package com.demo.springboot.controller;

import com.demo.springboot.bean.Employee;
import com.demo.springboot.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    @NonNull private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.getEmp(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee) {
        return employeeService.updateEmp(employee);
    }


    @RequestMapping("/emp/del/{id}")
    public String delete(@PathVariable Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }

    @GetMapping("/emp/list")
    public Page<Employee> getAll() {
        return employeeService.getAll();
    }
}
