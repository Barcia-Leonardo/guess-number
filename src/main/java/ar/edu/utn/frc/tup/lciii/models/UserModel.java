package ar.edu.utn.frc.tup.lciii.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    private Long id;
    private  String userName;
    private String email;
}
