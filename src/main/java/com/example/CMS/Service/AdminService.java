package com.example.CMS.Service;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepository;

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> getAdminById(int id) {
        return adminRepository.findById(id);
    }
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void deleteAdmin(int id){
        adminRepository.deleteById(id);
    }
}
