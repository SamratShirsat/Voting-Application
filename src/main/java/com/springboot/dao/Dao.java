package com.springboot.dao;

import com.springboot.model.Candidate;
import com.springboot.model.LoginCandidate;
import com.springboot.model.Vote;
import com.springboot.repository.CandidateRepository;
import com.springboot.repository.VotingRepository;
import com.springboot.service.EmailAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Dao {

    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    VotingRepository votingRepository;

    public void addNewCandidate(Candidate candidate) throws EmailAlreadyExist {
        Optional<Candidate> checkById = candidateRepository.findByEmail(candidate.getEmail());
        if (checkById.isPresent()){
            throw new EmailAlreadyExist("Email is Already Exist");
        }else {
            candidateRepository.save(candidate);
        }
    }
    public boolean checkCandidate(String username,String password){
        Candidate checkUsername = candidateRepository.findByUsername(username);
        if(checkUsername==null){
            return false;
        }else{
            if(checkUsername.getUsername().equals(username) && checkUsername.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public void SaveVote(Vote votes, LoginCandidate loginCandidate){
        Candidate candidate = candidateRepository.findByUsername(loginCandidate.getUsername());
        votes.setCandidate(candidate);
        System.out.println(candidate);
        votingRepository.save(votes);
    }

    public List<Vote> giveMeVotes(){
        return (List<Vote>) votingRepository.findAll();
    }
}

