package com.fintech.taskunite.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : trinh
 * @version : 1.0.1
 * @description : Class User
 * @since : 23/05/2020 - 11:10
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "User")
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String login;

    @Column(name = "password_hash", length = 60, nullable = false)
    private String passwordHash;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(length = 191, unique = true)
    private String email;

    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @Column(nullable = false)
    private boolean activated = false;

    @Column(name = "lang_key", length = 10)
    private String langKey;

    @Column(name = "activation_key", length = 20)
    private String activationKey;

    @Column(name = "reset_key", length = 20)
    private String resetKey;

    @Column(name = "reset_date")
    private Instant resetDate = null;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @Column(name = "created_date")
    @CreationTimestamp
    private Instant createdDate;

    @Column(name = "last_modified_by", length = 50)
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    @OneToMany(mappedBy = "user")
    private Set<PaymentInformation> paymentInformations = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Notification> notifications = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private Statistic statistic;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews = new HashSet<>();
}

