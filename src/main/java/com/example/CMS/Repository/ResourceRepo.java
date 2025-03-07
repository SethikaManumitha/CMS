package com.example.CMS.Repository;

import com.example.CMS.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepo extends JpaRepository<Resource, Integer> {
}
