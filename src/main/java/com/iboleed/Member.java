package com.iboleed;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Builder
public class Member extends GeneralEntity {

    private String firstName;
    private String lastName;
    private String password;
    private String name;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private FitnessData fitnessData;
}
