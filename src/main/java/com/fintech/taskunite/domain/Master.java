package com.fintech.taskunite.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : trinh
 * @version : 1.0.1
 * @description : Class Master
 * @since : 23/05/2020 - 11:45
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "Master")
@Table(name = "master")
public class Master implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Integer status;

    @OneToOne
    private User user;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToMany(mappedBy = "master")
    private Set<Room> rooms = new HashSet<>();

    @OneToMany(mappedBy = "master")
    private Set<Task> tasks = new HashSet<>();
}
