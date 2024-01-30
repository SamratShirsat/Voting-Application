package com.springboot.repository;

import com.springboot.model.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface VotingRepository extends CrudRepository<Vote,Integer> {

    List<Vote> listOfVotes = new ArrayList<>();
}
