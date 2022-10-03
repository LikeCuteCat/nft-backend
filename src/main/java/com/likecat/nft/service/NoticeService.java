package com.likecat.nft.service;

import com.likecat.nft.entity.notice.NoticeDto;

import java.util.List;

public interface NoticeService {

    NoticeDto getNotice(Long id);

    List<NoticeDto> getNotices();

    NoticeDto saveNotice(NoticeDto noticeDto);

    NoticeDto changeNotice(NoticeDto noticeDto) throws Exception;

    void deleteNotice(Long id) throws Exception;
}
