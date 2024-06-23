package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.*;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.*;
import ar.edu.utn.frc.tup.lciii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guess-number/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("")
    public  ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserModel userModel = userService.createUserModel(userDto.getUserName(),userDto.getUserEmail());
        UserDto userDtoCreated = modelMapper.map(userModel,UserDto.class);
        return ResponseEntity.ok(userDtoCreated);
    }

    @PostMapping("{userId}/matches")
    public  ResponseEntity<MatchDto> createUserMatch(@PathVariable Long userId,
                                                     @RequestBody CreateUserMatchDto createUserMatchDto){
        MatchModel matchModel=userService.createUserMatch(userId,createUserMatchDto.getDifficulty());
        MatchDto matchDto=modelMapper.map(matchModel,MatchDto.class);
        return ResponseEntity.ok(matchDto);
    }
    @PostMapping("{userId}/matches/{matchId}")
    public  ResponseEntity<RoundMatchDto> playUserMatch(@PathVariable Long userId,
                                                        @PathVariable Long matchId,
                                                        @RequestBody PlayMatchDto playMatchDto){
        RoundMatch roundMatch = userService.playuserMatch(userId,matchId,playMatchDto.getNumber());
        MatchDto matchDto = modelMapper.map(roundMatch.getMatch(),MatchDto.class);
        RoundMatchDto roundMatchDto = modelMapper.map(roundMatch,RoundMatchDto.class);
        roundMatchDto.setMatchDto(matchDto);

        return  ResponseEntity.ok(roundMatchDto);
    }




}
