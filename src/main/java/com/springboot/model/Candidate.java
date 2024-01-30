package com.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name ="Candidate")
public class Candidate {
    @Id
    @SequenceGenerator(initialValue = 1, name = "Candidate_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CandidateId")
    private int CandidateId;

    @Column(name = "username",nullable = false,unique = true)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "phoneNo",nullable = false)
    private long phoneNo;
    @OneToOne(mappedBy = "candidate",cascade = CascadeType.ALL)
    private Vote vote;

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public int getId() {
        return CandidateId;
    }

    public void setId(int id) {
        this.CandidateId = id;
    }

    public Candidate() {

    }

    public Candidate(String username, String password, String email, long phoneNo) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }


    @Override
    public String toString() {
        return "Candidate{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

}
