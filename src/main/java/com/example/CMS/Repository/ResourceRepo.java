package com.example.CMS.Repository;

import com.example.CMS.Entity.Resource;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ResourceRepo extends JpaRepository<Resource, Integer> {

}
