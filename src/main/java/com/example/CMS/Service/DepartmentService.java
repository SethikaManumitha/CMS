package com.example.CMS.Service;

import com.example.CMS.DTO.DepartmentResourceDTO;
import com.example.CMS.Entity.Department;
import com.example.CMS.Entity.Resource;
import com.example.CMS.Repository.DepartmentRepo;
import com.example.CMS.Repository.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepository;


    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }

    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);
    }

    public List<DepartmentResourceDTO> getAllDepartmentsWithResources() {
        List<Object[]> results = departmentRepository.findAllDepartmentsWithResources();
        List<DepartmentResourceDTO> departmentResourceDTOs = new ArrayList<>();

        for (Object[] row : results) {
            // Handle null values by providing default values
            int deptId = (row[0] != null) ? (int) row[0] : 0;  // Default to 0 if null
            String deptName = (row[1] != null) ? (String) row[1] : " ";  // Default to space if null
            int resourceId = (row[2] != null) ? (int) row[2] : 0;  // Default to 0 if null
            int capacity = (row[3] != null) ? (int) row[3] : 0;  // Default to 0 if null
            String description = (row[4] != null) ? (String) row[4] : " ";  // Default to space if null
            String resourceName = (row[5] != null) ? (String) row[5] : " ";  // Default to space if null
            int status = (row[6] != null) ? (int) row[6] : 0;  // Default to 0 if null
            String type = (row[7] != null) ? (String) row[7] : " ";  // Default to space if null

            // Mapping the query result to the DTO
            DepartmentResourceDTO dto = new DepartmentResourceDTO(
                    deptId, deptName, resourceId, capacity, description, resourceName, status, type
            );
            departmentResourceDTOs.add(dto);
        }
        return departmentResourceDTOs;
    }
}

