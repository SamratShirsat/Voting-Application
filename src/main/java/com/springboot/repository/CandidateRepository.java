package com.springboot.repository;
import com.springboot.model.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate,Integer> {


    Optional<Candidate> findByEmail(String email);
    Candidate findByUsername(String username);

}