package com.example.CMS.Service;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin getAdminById(int id) {
        return adminRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public Admin updateAdmin(int id, Admin admin) {
        Admin existingAdmin = adminRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // You can update the properties here if necessary
        existingAdmin.setUser(admin.getUser());
        existingAdmin.setDepartment(admin.getDepartment());

        return adminRepo.save(existingAdmin);
    }

    public void deleteAdmin(int id) {
        if (!adminRepo.existsById(id)) {
            throw new RuntimeException("Admin not found");
        }
        adminRepo.deleteById(id);
    }
}
