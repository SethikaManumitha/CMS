package com.example.CMS.Service;

import com.example.CMS.Entity.Department;
import com.example.CMS.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling business logic related to Department entity.
 * Provides methods to interact with the Department repository.
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo; // Injecting DepartmentRepo dependency

    /**
     * Saves department details to the database.
     * @param department department entity to be saved
     * @return Saved department entity
     */
    public Department saveDetails(Department department){
        return departmentRepo.save(department);
    }
}
