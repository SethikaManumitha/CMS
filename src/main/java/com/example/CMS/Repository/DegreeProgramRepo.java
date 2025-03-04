package com.example.CMS.Repository;

import com.example.CMS.Entity.DegreeProgram;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for degree Program entity.
 * Extends JpaRepository to provide CRUD operations on the degree Program table.
 */
public interface DegreeProgramRepo extends JpaRepository<DegreeProgram, Integer> {

}