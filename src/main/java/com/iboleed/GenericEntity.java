package com.iboleed;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //standard constructors, getters, setters
}