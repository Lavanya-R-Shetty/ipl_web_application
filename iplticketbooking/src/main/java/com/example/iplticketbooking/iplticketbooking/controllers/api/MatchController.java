package com.example.iplticketbooking.iplticketbooking.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.iplticketbooking.iplticketbooking.Response;
import com.example.iplticketbooking.iplticketbooking.entity.IPLMatch;
import com.example.iplticketbooking.iplticketbooking.repository.MatchRepository;

@RestController
@RequestMapping("/api")
public class MatchController {

  @Autowired
  private MatchRepository matchRepository;

  @GetMapping("/create-match")
  public Response createMatch(@ModelAttribute IPLMatch match) {
    matchRepository.save(match);
    Response response = new Response();
    response.message = "Match Created Successfully";
    response.status = 200;
    return response;
  }

  @GetMapping("/edit-match")
  public Response editMatch(@ModelAttribute IPLMatch match) {
    String matchId = match.getMatchNumber();

    if (matchRepository.existsById(matchId)) {
      IPLMatch existingMatch = matchRepository.findById(matchId).get();
      if (match.getMatchName() != null) {
        existingMatch.setMatchName(match.getMatchName());
      }
      if (match.getLocation() != null) {
        existingMatch.setLocation(match.getLocation());
      }
      if (match.getDate() != null) {
        existingMatch.setDate(match.getDate());
      }
      if (match.getTime() != null) {
        existingMatch.setTime(match.getTime());
      }

      matchRepository.save(existingMatch);
      Response response = new Response();
      response.message = "Match Edited Successfully";
      response.status = 200;
      return response;
    } else {
      Response response = new Response();
      response.message = "Match Not Found";
      response.status = 404;
      return response;
    }
  }

  @GetMapping("/delete-match")
  public Response deleteMatch(@RequestParam String matchId) {
    matchRepository.deleteById(matchId);
    Response response = new Response();
    response.message = "Match Deleted Successfully";
    response.status = 200;
    return response;
  }

  @GetMapping("/all-matches")
  public Iterable<IPLMatch> allMatches() {
    return matchRepository.findAll();
  }

  @GetMapping("/search-match-by-id")
  public IPLMatch searchMatchById(@RequestParam String matchId) {
    return matchRepository.findById(matchId).get();
  }

  @GetMapping("/search-match")
  public Iterable<IPLMatch> searchTicket(
      @RequestParam String location,
      @RequestParam String date) {
    return matchRepository.findAllByLocationAndDate(
        location,
        date);
  }
}
