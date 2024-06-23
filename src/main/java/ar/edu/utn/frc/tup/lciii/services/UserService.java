package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.MatchModel;
import ar.edu.utn.frc.tup.lciii.models.Matchdifficulty;
import ar.edu.utn.frc.tup.lciii.models.RoundMatch;
import ar.edu.utn.frc.tup.lciii.models.UserModel;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
//    UserModel GetUserModel(Long id);
//
//    List<UserModel> GetUserModelList();

    UserModel createUserModel(String userName,String email);

    MatchModel createUserMatch(Long userId, Matchdifficulty matchdifficulty);

    RoundMatch playuserMatch(Long userId, Long matchId, Integer numberToPlay);

//    UserModel updateUserModel(UserModel userModel);
//
//    void deleteUserModel(UserModel userModel);

}
