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
 * @description : Class Tasker
 * @since : 23/05/2020 - 11:53
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "Tasker")
@Table(name = "tasker")
public class Tasker implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Integer status;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToMany(mappedBy = "tasker")
    private Set<Room> rooms = new HashSet<>();

    @OneToOne(mappedBy = "tasker")
    private Schedule schedule;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "tasker")
    private Set<Task> tasks = new HashSet<>();

    @OneToMany(mappedBy = "tasker")
    private Set<TaskerCategory> taskerCategories = new HashSet<>();
}


