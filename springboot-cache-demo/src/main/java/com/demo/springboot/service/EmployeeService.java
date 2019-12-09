package com.demo.springboot.service;

import com.demo.springboot.bean.Employee;
import com.demo.springboot.repository.EmployeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @NonNull
    EntityManager entityManager;

    @NonNull private EmployeeRepository employeeRepository;

    @Cacheable(
//            cacheNames = "emp",
            unless = "#result == null",
            key = "#id"
    )
    public Employee getEmp(Integer id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        return employee;
    }

    @CachePut(
//            cacheNames = "emp",
            key = "#result.id"
    )
    public Employee updateEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @CacheEvict(
//            cacheNames = "emp",
            key="#id")
    public void deleteEmp(Integer id) {
        employeeRepository.deleteById(id);
    }


    @Caching(
            cacheable = {
                    @Cacheable(
//                            cacheNames = "emp",
                            key = "#lastName")
            },
            put = {
                    @CachePut(
//                            cacheNames = "emp",
                            key = "#result.id"),
                    @CachePut(
//                            cacheNames = "emp",
                            key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeRepository.findEmployeeByLastName(lastName);
    }

    public Page<Employee> getAll() {
        val sort = Sort.by("id").descending();
        val pageable = PageRequest.of(0, 100, sort);
        return employeeRepository.findAll(pageable);
    }
}
