package com.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Votes")
public class Vote {
    @Id
    @SequenceGenerator(initialValue = 1, name = "Candidate_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "voteId")
    private int VoteId;
    @Column(name = "vote")
    private String vote;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CandidateId")
    private Candidate candidate;

    public Vote(int voteId, String vote, Candidate candidate) {
        VoteId = voteId;
        this.vote = vote;
        this.candidate = candidate;
    }


    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Vote() {
    }

    public int getVoteId() {
        return VoteId;
    }

    public void setVoteId(int voteId) {
        VoteId = voteId;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Vote(String vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "VoteId=" + VoteId +
                ", vote='" + vote + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}
