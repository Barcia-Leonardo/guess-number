package ar.edu.utn.frc.tup.lciii.services.servicesImpl;

import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.MatchModel;
import ar.edu.utn.frc.tup.lciii.models.Matchdifficulty;
import ar.edu.utn.frc.tup.lciii.models.RoundMatch;
import ar.edu.utn.frc.tup.lciii.models.UserModel;
import ar.edu.utn.frc.tup.lciii.repositories.UserRepository;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import ar.edu.utn.frc.tup.lciii.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MatchService matchService;

    @Override
    public UserModel createUserModel(String userName, String email) {
        Optional<UserEntity> userEntityOptional=userRepository.getByEmail(email);
        if(userEntityOptional.isPresent()){
            //TODO enviar error al usuario
            return null;
        }else{
                UserEntity userEntity= new UserEntity();
                userEntity.setUserName(userName);
                userEntity.setEmail(email);
                UserEntity userEntitySaved=userRepository.save(userEntity);
                return  modelMapper.map(userEntitySaved,UserModel.class);
        }

    }

    @Override
    public MatchModel createUserMatch(Long userId, Matchdifficulty matchdifficulty) {
        Optional<UserEntity> userEntityOptional=userRepository.findById(userId);
        if(userEntityOptional.isEmpty()){
            throw  new EntityNotFoundException();
        }else {
            UserModel userModel= modelMapper.map(userEntityOptional.get(),UserModel.class);
            return  matchService.createMatch(userModel,matchdifficulty);

        }

    }

    @Override
    public RoundMatch playuserMatch(Long userId, Long matchId, Integer numberToPlay) {
        MatchModel matchModel=matchService.getMatchById(matchId);
        if(matchModel.getUserModel().getId().equals(userId)){
            //TODO : error
            return  null;
        }else {
            return  matchService.playMatch(matchModel,numberToPlay);
        }
    }
}
