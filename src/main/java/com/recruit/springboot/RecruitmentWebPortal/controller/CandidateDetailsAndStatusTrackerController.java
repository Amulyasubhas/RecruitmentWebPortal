package com.recruit.springboot.RecruitmentWebPortal.controller;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CandidateDetailsAndStatusTrackerDTO;
import com.recruit.springboot.RecruitmentWebPortal.service.CandidateDetailsAndStatusTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin(origins = "*")
public class CandidateDetailsAndStatusTrackerController {

    @Autowired
    private CandidateDetailsAndStatusTrackerService service;

    @PostMapping
    public CandidateDetailsAndStatusTrackerDTO add(@RequestBody CandidateDetailsAndStatusTrackerDTO dto) {
        return service.saveCandidate(dto);
    }

    @GetMapping
    public List<CandidateDetailsAndStatusTrackerDTO> getAll() {
        return service.getAllCandidates();
    }

    @GetMapping("/{id}")
    public CandidateDetailsAndStatusTrackerDTO getById(@PathVariable Long id) {
        return service.getCandidateById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCandidate(id);
    }

    @PutMapping("/{id}")
    public CandidateDetailsAndStatusTrackerDTO update(@PathVariable Long id, @RequestBody CandidateDetailsAndStatusTrackerDTO dto) {
        return service.updateCandidate(id, dto);
    }
}
