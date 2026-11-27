package com.reynolds.safeguard.shared.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(updatable = false)
    private UUID uuid = Uuids.v7();

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @Column(updatable = false)
    private Timestamp updatedAt;

    @Version
    private Long version;

    public UUID getUuid() {
        return uuid;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public Long getVersion() {
        return version;
    }
}
