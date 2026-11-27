package com.reynolds.safeguard.access.domain;


import com.reynolds.safeguard.shared.domain.BaseEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "app_user")
public class AppUser extends BaseEntity {

    @Column(updatable = false)
    private UUID pspId;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Status status;


    protected AppUser() {
    }

    public AppUser(UUID pspId, String email, String passwordHash) {
        this.pspId = pspId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.status = Status.ACTIVE;
    }

    public UUID getPspId() {
        return pspId;
    }


    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }


    public Status getStatus() {
        return status;
    }


    public enum Status{
        ACTIVE("Active account"),
        INACTIVE("Inactive account"),
        SUSPENDED("Suspended account");

        final String value;

        Status(String value){
            this.value = value;
        }
    }

}
