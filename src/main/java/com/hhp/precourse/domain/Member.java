package com.hhp.precourse.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String stringId;

    private String name;

    private String encryptedPw;

    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @Builder
    public Member(String stringId, String name, String encryptedPw, String email){
        this.stringId = stringId;
        this.name = name;
        this.encryptedPw = encryptedPw;
        this.email = email;
    }
}
