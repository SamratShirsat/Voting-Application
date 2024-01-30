package com.springboot.candidateController;

import com.springboot.dao.Dao;
import com.springboot.model.Candidate;
import com.springboot.model.LoginCandidate;
import com.springboot.model.Vote;
import com.springboot.service.EmailAlreadyExist;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CandidateController {

    @Autowired
    Dao dao;
    @GetMapping("/Welcome")
    public String welcomePage(){
        return "Welcome";
    }
    @GetMapping("/Register")
    public String registerPage() {
        return "Register";
    }
    @PostMapping("/login")
    public String loginPage(@RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam long phoneNo) throws EmailAlreadyExist {
        Candidate candidate = new Candidate(username,password,email,phoneNo);
        dao.addNewCandidate(candidate);
        System.out.println("Candidate is Added Successfully");
        return "login";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @PostMapping("/VotingPage")
    public String votingPage(ModelMap model,@RequestParam String username, @RequestParam String password,HttpSession session) {
        boolean checkUser = dao.checkCandidate(username,password);
        LoginCandidate loginCandidate = new LoginCandidate(username,password);
        session.setAttribute("username",loginCandidate);
        if(checkUser){
            model.put("username", username);


            return "VotingPage";
        }
        else {
            return "login";
        }
    }
    @PostMapping("/Final")
    public String finalPage(@RequestParam("fav_language")String candidate_vote,HttpSession session){
        Vote votes = new Vote(candidate_vote);
        LoginCandidate loginCandidate = (LoginCandidate) session.getAttribute("username");
        dao.SaveVote(votes,loginCandidate);
        return "Final";
    }
    public String ResultPage(){
        List<Vote> listOfVotes = dao.giveMeVotes();
        return "";
    }
}
