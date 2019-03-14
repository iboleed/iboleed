package com.iboleed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Member extends GeneralEntity {

    private String firstName;
    private String lastName;
    private String password;
    private String name;
}
