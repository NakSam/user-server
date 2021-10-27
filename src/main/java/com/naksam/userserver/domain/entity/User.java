package com.naksam.userserver.domain.entity;

import com.naksam.userserver.dto.MemberPayload;
import com.naksam.userserver.dto.UserDetailResponse;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String password;

    @Builder
    public User(Long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public void checkPassword(String password, PasswordEncoder passwordEncoder) {
        if (passwordIsNotEqual(password, passwordEncoder)) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }
    }

    private boolean passwordIsNotEqual(String password, PasswordEncoder passwordEncoder) {
        return !passwordEncoder.matches(password, this.password);
    }

    public MemberPayload createMemberPayload() {
        return new MemberPayload(id, email ,name);
    }

    public UserDetailResponse createUserDetail() {
        return new UserDetailResponse(id, email, name);
    }
}
