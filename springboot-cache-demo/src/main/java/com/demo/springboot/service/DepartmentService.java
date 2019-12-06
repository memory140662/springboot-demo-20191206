package com.demo.springboot.service;

import com.demo.springboot.bean.Department;
import com.demo.springboot.repository.DepartmentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    @NonNull private DepartmentRepository departmentRepository;

    @NonNull private CacheManager cacheManager;

//    @Cacheable(cacheNames = "dept")
//    public Department getDeptById(@PathVariable Integer id) {
//        return departmentRepository.findDepartmentById(id);
//    }

    public Department getDeptById(@PathVariable Integer id) {
        System.out.println("getDeptById");
        Cache cache = cacheManager.getCache("dept");
        Department department = cache.get(id, Department.class);
        if (department != null) {
            return department;
        }

        department = departmentRepository.findDepartmentById(id);

        if (department != null) {
            cache.put(id, department);
        }

        return department;
    }
}
