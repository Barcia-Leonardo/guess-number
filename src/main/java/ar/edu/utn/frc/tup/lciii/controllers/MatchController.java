package ar.edu.utn.frc.tup.lciii.controllers;


import ar.edu.utn.frc.tup.lciii.dtos.MatchDto;
import ar.edu.utn.frc.tup.lciii.dtos.UserDto;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.MatchModel;
import ar.edu.utn.frc.tup.lciii.models.UserModel;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guess-number/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

//    @GetMapping("")
//    public ResponseEntity<MatchDto> GetMatchEntity(){
//        List<MatchModel> matchModelList = matchService.getMatchModelList();
//        return null;
//    }
//    @GetMapping("")
//    public ResponseEntity<MatchDto> GetMatchList(Long id){
//        MatchModel matchModel=matchService.getMatchModel(id);
//        return null;
//    }
//    @PostMapping("")
//    public ResponseEntity<MatchDto> postMatch(MatchDto matchDto){
//        MatchModel matchModel=matchService.createMatchModel(null);
//        return null;
//    }
//    @PutMapping("")
//    public  ResponseEntity<MatchDto> putMatch(MatchDto matchDto){
//        MatchModel matchModel=matchService.updateMatchModel(null);
//        return null;
//    }
//    @DeleteMapping("")
//    public  ResponseEntity<Void> deleteMatch(MatchDto matchDto){
//        matchService.deleteMatchModel(null);
//        return null;
//    }
}

