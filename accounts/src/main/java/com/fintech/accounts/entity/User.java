package com.fintech.accounts.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Column(name = "contact_number")
    private String contactNumber;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "payee_id", referencedColumnName = "id")
    private List<Payee> payee;

}
