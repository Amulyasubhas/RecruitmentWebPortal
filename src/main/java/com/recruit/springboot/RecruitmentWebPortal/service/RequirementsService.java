package com.recruit.springboot.RecruitmentWebPortal.service;

import com.recruit.springboot.RecruitmentWebPortal.DTO.RequirementsDTO;
import java.util.List;

public interface RequirementsService {
    RequirementsDTO addRequirement(RequirementsDTO dto);
    List<RequirementsDTO> getAllRequirements();
}
