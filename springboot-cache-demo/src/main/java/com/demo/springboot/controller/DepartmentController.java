package com.demo.springboot.controller;

import com.demo.springboot.bean.Department;
import com.demo.springboot.service.DepartmentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    @NonNull private DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable Integer id) {
        return departmentService.getDeptById(id);
    }
}
