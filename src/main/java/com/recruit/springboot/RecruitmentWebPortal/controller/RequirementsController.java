package com.recruit.springboot.RecruitmentWebPortal.controller;

import com.recruit.springboot.RecruitmentWebPortal.DTO.RequirementsDTO;
import com.recruit.springboot.RecruitmentWebPortal.service.RequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requirements")
@CrossOrigin
public class RequirementsController {

    @Autowired
    private RequirementsService requirementsService;

    @PostMapping
    public RequirementsDTO addRequirement(@RequestBody RequirementsDTO dto) {
        return requirementsService.addRequirement(dto);
    }

    @GetMapping
    public List<RequirementsDTO> getAllRequirements() {
        return requirementsService.getAllRequirements();
    }
}
