package com.simulcreare.domain.entity;

import com.simulcreare.domain.type.ArtworkType;

import javax.persistence.*;

@Entity
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ArtworkType type;

    @ManyToOne
    private User op;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArtworkType getType() {
        return type;
    }

    public void setType(ArtworkType type) {
        this.type = type;
    }

    public User getOp() {
        return op;
    }

    public void setOp(User op) {
        this.op = op;
    }
}
