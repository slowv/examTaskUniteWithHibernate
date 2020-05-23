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

/**
 * @author : trinh
 * @version : 1.0.1
 * @description : Class Statistic
 * @since : 23/05/2020 - 12:33
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "Statistic")
@Table(name = "statistic")
public class Statistic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "level")
    private Integer level;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "completed_task")
    private Integer completedTask;

    @Column(name = "incompleted_task")
    private Integer inCompletedTask;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "bonus")
    private Double bonus;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToOne
    private User user;
}
