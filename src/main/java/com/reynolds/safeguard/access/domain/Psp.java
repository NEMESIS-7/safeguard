package com.reynolds.safeguard.access.domain;

import com.reynolds.safeguard.shared.domain.BaseEntity;
import jakarta.persistence.*;

//payment service provider

@Entity
@Table(name = "psp")
public class Psp extends BaseEntity {

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Psp(String name){
        this.name = name;
        this.status = Status.ACTIVE;

    }

    protected Psp() {
    }

    public String getName() {
        return name;
    }


    public Status getStatus() {
        return status;
    }


    public enum Status{
        ACTIVE,
        INACTIVE
    }
}
