package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.MatchModel;
import ar.edu.utn.frc.tup.lciii.models.Matchdifficulty;
import ar.edu.utn.frc.tup.lciii.models.RoundMatch;
import ar.edu.utn.frc.tup.lciii.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
//    MatchModel getMatchModel(Long id);
//    List<MatchModel> getMatchModelList();
//
//    MatchModel createMatchModel(MatchModel matchModel);
//    MatchModel updateMatchModel(MatchModel matchModel);
//    void deleteMatchModel(MatchModel matchModel);

    MatchModel createMatch (UserModel userModel, Matchdifficulty matchdifficulty);
    MatchModel getMatchById(Long matchId);

    RoundMatch playMatch(MatchModel matchModel, Integer number);

}
