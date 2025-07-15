package com.recruit.springboot.RecruitmentWebPortal.repository;

import com.recruit.springboot.RecruitmentWebPortal.entity.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementsRepository extends JpaRepository<Requirements, Long> {
}
