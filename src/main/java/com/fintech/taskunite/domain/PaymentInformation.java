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
 * @description : Class PaymentInformation
 * @since : 23/05/2020 - 11:56
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "PaymentInformation")
@Table(name = "payment_information")
public class PaymentInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double balance;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;
}
