package com.example.mInt_BE.repository.entity;


import lombok.*;

import javax.persistence.*;

@ToString(exclude = "index")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(schema = "mint1")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long index;

    @Column(name = "id")
    public String id;

    @Column(name = "ps")
    public String ps;

    @Column(name = "email")
    public String email;
}