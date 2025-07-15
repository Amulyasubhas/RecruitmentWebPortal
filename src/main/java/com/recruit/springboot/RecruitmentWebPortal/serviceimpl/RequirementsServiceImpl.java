package com.recruit.springboot.RecruitmentWebPortal.serviceimpl;

import com.recruit.springboot.RecruitmentWebPortal.DTO.RequirementsDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.Requirements;
import com.recruit.springboot.RecruitmentWebPortal.repository.RequirementsRepository;
import com.recruit.springboot.RecruitmentWebPortal.service.RequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequirementsServiceImpl implements RequirementsService {

    @Autowired
    private RequirementsRepository requirementsRepository;

    @Override
    public RequirementsDTO addRequirement(RequirementsDTO dto) {
        Requirements entity = mapToEntity(dto);
        entity.setSerialNo(getNextSerialNo());
        Requirements saved = requirementsRepository.save(entity);
        return mapToDTO(saved);
    }

    @Override
    public List<RequirementsDTO> getAllRequirements() {
        return requirementsRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private Long getNextSerialNo() {
        return requirementsRepository.findAll().stream()
                .mapToLong(Requirements::getSerialNo)
                .max()
                .orElse(0L) + 1;
    }

    private RequirementsDTO mapToDTO(Requirements entity) {
        RequirementsDTO dto = new RequirementsDTO();
        dto.setId(entity.getId());
        dto.setSerialNo(entity.getSerialNo());
        dto.setRole(entity.getRole());
        dto.setNoOfPositions(entity.getNoOfPositions());
        dto.setSkills(entity.getSkills());
        dto.setYearsOfExperience(entity.getYearsOfExperience());
        dto.setClientName(entity.getClientName());
        dto.setBudget(entity.getBudget());
        dto.setLocation(entity.getLocation());
        dto.setWorkTimings(entity.getWorkTimings());
        dto.setPriority(entity.getPriority());
        dto.setPositionStatus(entity.getPositionStatus());
        return dto;
    }

    private Requirements mapToEntity(RequirementsDTO dto) {
        Requirements entity = new Requirements();
        entity.setId(dto.getId());
        entity.setSerialNo(dto.getSerialNo());
        entity.setRole(dto.getRole());
        entity.setNoOfPositions(dto.getNoOfPositions());
        entity.setSkills(dto.getSkills());
        entity.setYearsOfExperience(dto.getYearsOfExperience());
        entity.setClientName(dto.getClientName());
        entity.setBudget(dto.getBudget());
        entity.setLocation(dto.getLocation());
        entity.setWorkTimings(dto.getWorkTimings());
        entity.setPriority(dto.getPriority());
        entity.setPositionStatus(dto.getPositionStatus());
        return entity;
    }
}
