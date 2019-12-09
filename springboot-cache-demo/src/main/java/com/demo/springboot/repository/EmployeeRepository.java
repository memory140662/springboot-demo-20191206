package com.demo.springboot.repository;

import com.demo.springboot.bean.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findEmployeeById(Integer id);

    Employee findEmployeeByLastName(String lastName);

    @Query(nativeQuery = true,
        value = "SELECT * FROM employee WHERE 1 = 1"
    )
    Page<Employee> findAll(Pageable pageable);
}
