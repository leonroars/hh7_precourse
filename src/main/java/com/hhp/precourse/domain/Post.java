package com.hhp.precourse.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // 수정 날짜 전역으로 처리하기 위해 EntityListener 적용.
@Table(indexes = {
        @Index(name = "idx_lastModified_date", columnList = "lastModifiedDate")
}
)
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    private String title;

    private String body;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

    private String postPw; // 6자리 정수


    /* Utility Methods */

    /**
     * JPA Dirty Checking을 이용한 게시글 수정 적용 메서드.
     * <br></br>
     * 비밀번호에 대한 검증은 Service 단에서 이루어진다.
     */
    public void updatePost(String newTitle, String newBody){
        this.title = newTitle;
        this.body = newBody;
    }

}
