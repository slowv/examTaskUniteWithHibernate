package com.fintech.taskunite.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author trinh
 * @version 1.0.1
 * @description Class Schedule
 * @since 23/05/2020 - 12:45
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "Schedule")
@Table(name = "schedule")
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_date")
    private Instant from;

    @Column(name = "to_date")
    private Instant to;

    @Column(name = "duration")
    private Long duration;

    @OneToOne
    private Tasker tasker;
}
