package com.example.CMS.Service;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    /**
     * Saves admin details to the database.
     * @param admin Admin entity to be saved
     * @return Saved Admin entity
     */
    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

}
