package com.recruit.springboot.RecruitmentWebPortal.service;

import java.util.List;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CandidateDetailsAndStatusTrackerDTO;

public interface CandidateDetailsAndStatusTrackerService {
    CandidateDetailsAndStatusTrackerDTO saveCandidate(CandidateDetailsAndStatusTrackerDTO dto);
    List<CandidateDetailsAndStatusTrackerDTO> getAllCandidates();
    CandidateDetailsAndStatusTrackerDTO getCandidateById(Long id);
    void deleteCandidate(Long id);
    CandidateDetailsAndStatusTrackerDTO updateCandidate(Long id, CandidateDetailsAndStatusTrackerDTO dto);
}
