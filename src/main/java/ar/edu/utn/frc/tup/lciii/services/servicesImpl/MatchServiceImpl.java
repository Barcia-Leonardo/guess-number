package ar.edu.utn.frc.tup.lciii.services.servicesImpl;

import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.*;
import ar.edu.utn.frc.tup.lciii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private ModelMapper modelMapper;
    private final Random random = new Random();


    @Override
    public MatchModel createMatch(UserModel userModel, Matchdifficulty matchdifficulty) {
        MatchEntity matchEntity= new MatchEntity();
        matchEntity.setUserEntity(modelMapper.map(userModel, UserEntity.class));
        matchEntity.setDifficulty(matchdifficulty);
        switch (matchdifficulty){
            case HARD -> matchEntity.setRemainingTries(5);
            case MEDIUM -> matchEntity.setRemainingTries(8);
            case EASY -> matchEntity.setRemainingTries(10);
        }
        matchEntity.setNumberToGuess(random.nextInt(101));
        matchEntity.setStatus(MatchStatus.PLAYING);
        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());
        MatchEntity matchEntitySaved=matchRepository.save(matchEntity);
        return modelMapper.map(matchEntitySaved,MatchModel.class);

    }

    @Override
    public MatchModel getMatchById(Long matchId) {
        Optional<MatchEntity> matchEntityOptional=matchRepository.findById(matchId);
        if(matchEntityOptional.isEmpty()){
            throw  new EntityNotFoundException();
        }else {
            return  modelMapper.map(matchEntityOptional.get(),MatchModel.class);
        }

    }

    @Override
    public RoundMatch playMatch(MatchModel matchModel, Integer number) {
        RoundMatch roundMatch= new RoundMatch();
        roundMatch.setMatch(matchModel);
        if(matchModel.getStatus().equals(MatchStatus.FINISH)){
            //TODO: error
            return null;
        }else {
            if(matchModel.getNumberToGuess().equals(number)){
                //TODO calcular score
                //TODO dar respuesta
                matchModel.setStatus(MatchStatus.FINISH);
                roundMatch.setRespuesta("GANO");

            }else{
                matchModel.setRemainingTries(matchModel.getRemainingTries()-1);
                if(matchModel.getRemainingTries().equals(0)){
                    matchModel.setStatus(MatchStatus.FINISH);
                    roundMatch.setRespuesta("PERDIO");
                }else {
                    if(number > matchModel.getNumberToGuess()){
                        roundMatch.setRespuesta("MENOR");
                        //TODO respuesta menor
                    }else{
                        roundMatch.setRespuesta("MAYOR");
                        //TODO respondel mayor
                    }
                }

            }

        }
        UserEntity userEntity=modelMapper.map(matchModel.getUserModel(),UserEntity.class);
        MatchEntity matchEntity=modelMapper.map(matchModel,MatchEntity.class);
        matchEntity.setUserEntity(userEntity);
        matchEntity.setUpdatedAt(LocalDateTime.now());
        matchRepository.save(matchEntity);
         return roundMatch;
    }
}
