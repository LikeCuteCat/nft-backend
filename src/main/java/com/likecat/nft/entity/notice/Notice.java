package com.likecat.nft.entity.notice;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public NoticeDto convertToDto() {
        return NoticeDto.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
