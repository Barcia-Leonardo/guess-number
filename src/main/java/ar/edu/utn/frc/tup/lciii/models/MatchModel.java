package ar.edu.utn.frc.tup.lciii.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchModel {
    private Long id;

    private UserModel userModel;

    private Matchdifficulty difficulty;

    private  Integer numberToGuess;

    private Integer remainingTries;

    private  MatchStatus status;
}
