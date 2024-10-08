package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long backId; // 사용자 고유 어카운트

    @Column(unique = true, length = 10, nullable = false)
    private String id; // 사용자 어카운트

    @Column(length = 10, nullable = false)
    private String nickName; // 사용자 이름

    @Column(length = 80, nullable = false)
    private String password; // 비밀번호

    @Column(length = 3, nullable = false)
    private String mobile1; // 핸드폰

    @Column(length = 4, nullable = false)
    private String mobile2; // 핸드폰

    @Column(length = 4, nullable = false)
    private String mobile3; // 핸드폰

    @Column(length = 10, nullable = false)
    private String email1; // 메일

    @Column(length = 8, nullable = false)
    private String email2; // 메일

    @Column(nullable = false)
    private LocalDateTime regDate; // 가입일

    @Column
    private LocalDateTime lastLoginDate; // 최근 접속일

    @Column
    private LocalDateTime exitDate; // 회원탈퇴일
}
