package com.example.CMS.Repository;

import com.example.CMS.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ResourceRepo extends JpaRepository<Resource, Integer> {
    List<Resource> findByStatus(int status);
}
