package com.demo.springboot.repository;

import com.demo.springboot.bean.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    Department findDepartmentById(Integer id);
}
