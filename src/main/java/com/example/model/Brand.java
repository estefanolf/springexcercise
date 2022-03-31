package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Brand {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

}
