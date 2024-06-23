package ar.edu.utn.frc.tup.lciii.dtos;

import ar.edu.utn.frc.tup.lciii.models.MatchStatus;
import ar.edu.utn.frc.tup.lciii.models.Matchdifficulty;
import ar.edu.utn.frc.tup.lciii.models.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchDto {

    private Long id;

    private Matchdifficulty difficulty;

    private Integer remainingTries;

}
