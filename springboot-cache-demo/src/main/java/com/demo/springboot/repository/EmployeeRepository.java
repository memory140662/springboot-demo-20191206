package com.demo.springboot.repository;

import com.demo.springboot.bean.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findEmployeeById(Integer id);

    Employee findEmployeeByLastName(String lastName);

}
