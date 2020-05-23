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
 * @author trinh
 * @version 1.0.1
 * @description Class Task
 * @since 23/05/2020 - 12:55
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "Task")
@Table(name = "task")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "estimated_time")
    private Double estimatedTime;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToOne
    private Room room;

    @ManyToOne
    private Schedule schedule;

    @ManyToOne
    private Tasker tasker;

    @ManyToOne
    private Master master;

    @ManyToOne
    @JoinColumn(name = "task_categoty_id")
    private TaskCategory taskCategory;

    @OneToMany(mappedBy = "task")
    private Set<Review> reviews = new HashSet<>();
}
