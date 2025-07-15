package com.recruit.springboot.RecruitmentWebPortal.DTO;

import java.time.LocalDate;

import com.recruit.springboot.RecruitmentWebPortal.entity.CandidateDetailsAndStatusTracker.Builder;
import com.recruit.springboot.RecruitmentWebPortal.entity.CurrentLocation;
import com.recruit.springboot.RecruitmentWebPortal.entity.Recruiter;
import com.recruit.springboot.RecruitmentWebPortal.entity.Source;
import com.recruit.springboot.RecruitmentWebPortal.entity.Vendor;




public class CandidateDetailsAndStatusTrackerDTO {
    private Long id;
    private LocalDate date;
    private String candidateName;
    private String skills;
    private String contactNo;
    private String emailId;
    private Double experience;
    private Double relevantExperience;
    private String ctc;
    private String ectc;
    private String noticePeriod;
    private CurrentLocation currentLocation;
    private String preferredLocation;
    private Vendor vendor;
    private Recruiter recruiter;
    private Source source;
    private String status;
    private String comment;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public Double getExperience() {
        return experience;
    }
    public void setExperience(Double experience) {
        this.experience = experience;
    }
    public Double getRelevantExperience() {
        return relevantExperience;
    }
    public void setRelevantExperience(Double relevantExperience) {
        this.relevantExperience = relevantExperience;
    }
    public String getCtc() {
        return ctc;
    }
    public void setCtc(String ctc) {
        this.ctc = ctc;
    }
    public String getEctc() {
        return ectc;
    }
    public void setEctc(String ectc) {
        this.ectc = ectc;
    }
    public String getNoticePeriod() {
        return noticePeriod;
    }
    public void setNoticePeriod(String noticePeriod) {
        this.noticePeriod = noticePeriod;
    }
    public CurrentLocation getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(CurrentLocation currentLocation) {
        this.currentLocation = currentLocation;
    }
    public String getPreferredLocation() {
        return preferredLocation;
    }
    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }
    public Vendor getVendor() {
        return vendor;
    }
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    public Recruiter getRecruiter() {
        return recruiter;
    }
    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
    public Source getSource() {
        return source;
    }
    public void setSource(Source source) {
        this.source = source;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
   

}
