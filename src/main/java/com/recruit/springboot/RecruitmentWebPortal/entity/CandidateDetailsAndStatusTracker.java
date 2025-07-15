package com.recruit.springboot.RecruitmentWebPortal.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class CandidateDetailsAndStatusTracker {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private LocalDate date;
    private String candidateName;
    private String skills;
   @Column(name = "contact_number") // match the DB
private String contactNo;

@Column(name = "email") // match the DB
private String emailId;

    private Double experience;
    private Double relevantExperience;
    private String ctc;
    private String ectc;
    private String noticePeriod;
    private String preferredLocation;
    private String status;
    private String comment;

   @Enumerated(EnumType.STRING)
private CurrentLocation currentLocation;

 @Enumerated(EnumType.STRING)
private Recruiter recruiter; 

@Enumerated(EnumType.STRING)
private Vendor vendor;

@Enumerated(EnumType.STRING)
private Source source;

   public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getCandidateName() { return candidateName; }
    public void setCandidateName(String candidateName) { this.candidateName = candidateName; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public Double getExperience() { return experience; }
    public void setExperience(Double experience) { this.experience = experience; }

    public Double getRelevantExperience() { return relevantExperience; }
    public void setRelevantExperience(Double relevantExperience) { this.relevantExperience = relevantExperience; }

    public String getCtc() { return ctc; }
    public void setCtc(String ctc) { this.ctc = ctc; }

    public String getEctc() { return ectc; }
    public void setEctc(String ectc) { this.ectc = ectc; }

    public String getNoticePeriod() { return noticePeriod; }
    public void setNoticePeriod(String noticePeriod) { this.noticePeriod = noticePeriod; }

    public String getPreferredLocation() { return preferredLocation; }
    public void setPreferredLocation(String preferredLocation) { this.preferredLocation = preferredLocation; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public CurrentLocation getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(CurrentLocation currentLocation) { this.currentLocation = currentLocation; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public Recruiter getRecruiter() { return recruiter; }
    public void setRecruiter(Recruiter recruiter) { this.recruiter = recruiter; }

    public Source getSource() { return source; }
    public void setSource(Source source) { this.source = source; }

   
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final CandidateDetailsAndStatusTracker instance = new CandidateDetailsAndStatusTracker();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder date(LocalDate date) {
            instance.setDate(date);
            return this;
        }

        public Builder candidateName(String candidateName) {
            instance.setCandidateName(candidateName);
            return this;
        }

        public Builder skills(String skills) {
            instance.setSkills(skills);
            return this;
        }

        public Builder contactNo(String contactNo) {
            instance.setContactNo(contactNo);
            return this;
        }

        public Builder emailId(String emailId) {
            instance.setEmailId(emailId);
            return this;
        }

        public Builder experience(Double experience) {
            instance.setExperience(experience);
            return this;
        }

        public Builder relevantExperience(Double relevantExperience) {
            instance.setRelevantExperience(relevantExperience);
            return this;
        }

        public Builder ctc(String ctc) {
            instance.setCtc(ctc);
            return this;
        }

        public Builder ectc(String ectc) {
            instance.setEctc(ectc);
            return this;
        }

        public Builder noticePeriod(String noticePeriod) {
            instance.setNoticePeriod(noticePeriod);
            return this;
        }

        public Builder currentLocation(CurrentLocation currentLocation) {
            instance.setCurrentLocation(currentLocation);
            return this;
        }

        public Builder preferredLocation(String preferredLocation) {
            instance.setPreferredLocation(preferredLocation);
            return this;
        }

        public Builder vendor(Vendor vendor) {
            instance.setVendor(vendor);
            return this;
        }

        public Builder recruiter(Recruiter recruiter) {
            instance.setRecruiter(recruiter);
            return this;
        }

        public Builder source(Source source) {
            instance.setSource(source);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder comment(String comment) {
            instance.setComment(comment);
            return this;
        }

        public CandidateDetailsAndStatusTracker build() {
            return instance;
        }
    }
}
