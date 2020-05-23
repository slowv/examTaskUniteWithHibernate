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
 * @description Class TaskCategory
 * @since 23/05/2020 - 12:52
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "TaskCategory")
@Table(name = "task_category")
public class TaskCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "min_price")
    private Double minPrice;

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

    @OneToMany(mappedBy = "taskCategory")
    private Set<Task> tasks = new HashSet<>();

    @OneToMany(mappedBy = "taskCategory")
    private Set<TaskerCategory> taskerCategories = new HashSet<>();
}
