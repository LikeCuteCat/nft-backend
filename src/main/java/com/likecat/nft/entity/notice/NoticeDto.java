package com.likecat.nft.entity.notice;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeDto {

    private Long id;

    private String title;

    private String content;

    public Notice toEntity() {
        return Notice.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
