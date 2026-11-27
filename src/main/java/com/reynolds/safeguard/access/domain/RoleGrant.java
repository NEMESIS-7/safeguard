package com.reynolds.safeguard.access.domain;

import com.reynolds.safeguard.shared.domain.BaseEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "role_grant")
public class RoleGrant extends BaseEntity {

    @Column(updatable = false)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false)
    private UserRole role;

    @Column(updatable = false)
    private UUID grantedBy;


    protected RoleGrant() {
    }

    public RoleGrant(UUID userId, UserRole role, UUID grantedBy) {
        this.userId = userId;
        this.role = role;
        this.grantedBy = grantedBy;
    }

    public UUID getUserId() {
        return userId;
    }


    public UserRole getRole() {
        return role;
    }


    public UUID getGrantedBy() {
        return grantedBy;
    }


    public enum UserRole{
        ADMINISTRATOR("Provider Administrator"),
        PLATFORM_OPERATOR("Platform Operator"),
        OPS_OFFICER("Operations Officer"),
        FIN_APPROVER("Finance Approver"),
        COMP_OFFICER("Compliance Officer"),
        AUDITOR("Auditor");

        final String value;

        UserRole(String value){
            this.value  = value;
        }
    }
}
