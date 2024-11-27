package com.qsp.restaurant_management_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_project.dto.Branch;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Integer> {

}
