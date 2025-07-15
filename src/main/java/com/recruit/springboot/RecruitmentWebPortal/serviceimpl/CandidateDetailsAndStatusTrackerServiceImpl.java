package com.recruit.springboot.RecruitmentWebPortal.serviceimpl;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CandidateDetailsAndStatusTrackerDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.CandidateDetailsAndStatusTracker;
import com.recruit.springboot.RecruitmentWebPortal.repository.CandidateDetailsAndStatusTrackerRepository;
import com.recruit.springboot.RecruitmentWebPortal.service.CandidateDetailsAndStatusTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateDetailsAndStatusTrackerServiceImpl implements CandidateDetailsAndStatusTrackerService {

    @Autowired
    private CandidateDetailsAndStatusTrackerRepository repository;

    private CandidateDetailsAndStatusTracker dtoToEntity(CandidateDetailsAndStatusTrackerDTO dto) {
        return CandidateDetailsAndStatusTracker.builder()
                .id(dto.getId())
                .date(dto.getDate())
                .candidateName(dto.getCandidateName())
                .skills(dto.getSkills())
                .contactNo(dto.getContactNo())
                .emailId(dto.getEmailId())
                .experience(dto.getExperience())
                .relevantExperience(dto.getRelevantExperience())
                .ctc(dto.getCtc())
                .ectc(dto.getEctc())
                .noticePeriod(dto.getNoticePeriod())
                .currentLocation(dto.getCurrentLocation())
                .preferredLocation(dto.getPreferredLocation())
                .vendor(dto.getVendor())
                .recruiter(dto.getRecruiter())
                .source(dto.getSource())
                .status(dto.getStatus())
                .comment(dto.getComment())
                .build();
    }

    private CandidateDetailsAndStatusTrackerDTO entityToDto(CandidateDetailsAndStatusTracker entity) {
        CandidateDetailsAndStatusTrackerDTO dto = new CandidateDetailsAndStatusTrackerDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setCandidateName(entity.getCandidateName());
        dto.setSkills(entity.getSkills());
        dto.setContactNo(entity.getContactNo());
        dto.setEmailId(entity.getEmailId());
        dto.setExperience(entity.getExperience());
        dto.setRelevantExperience(entity.getRelevantExperience());
        dto.setCtc(entity.getCtc());
        dto.setEctc(entity.getEctc());
        dto.setNoticePeriod(entity.getNoticePeriod());
        dto.setCurrentLocation(entity.getCurrentLocation());
        dto.setPreferredLocation(entity.getPreferredLocation());
        dto.setVendor(entity.getVendor());
        dto.setRecruiter(entity.getRecruiter());
        dto.setSource(entity.getSource());
        dto.setStatus(entity.getStatus());
        dto.setComment(entity.getComment());
        return dto;
    }

    @Override
    public CandidateDetailsAndStatusTrackerDTO saveCandidate(CandidateDetailsAndStatusTrackerDTO dto) {
        CandidateDetailsAndStatusTracker savedEntity = repository.save(dtoToEntity(dto));
        return entityToDto(savedEntity);
    }

    @Override
    public List<CandidateDetailsAndStatusTrackerDTO> getAllCandidates() {
        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CandidateDetailsAndStatusTrackerDTO getCandidateById(Long id) {
        return repository.findById(id)
                .map(this::entityToDto)
                .orElse(null);
    }

    @Override
    public void deleteCandidate(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CandidateDetailsAndStatusTrackerDTO updateCandidate(Long id, CandidateDetailsAndStatusTrackerDTO dto) {
        CandidateDetailsAndStatusTracker existing = repository.findById(id).orElseThrow();
        CandidateDetailsAndStatusTracker updated = dtoToEntity(dto);
        updated.setId(existing.getId());
        CandidateDetailsAndStatusTracker saved = repository.save(updated);
        return entityToDto(saved);
    }
}
