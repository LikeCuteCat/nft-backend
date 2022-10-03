package com.likecat.nft.service.impl;

import com.likecat.nft.entity.notice.Notice;
import com.likecat.nft.entity.notice.NoticeDto;
import com.likecat.nft.repository.NoticeRepository;
import com.likecat.nft.service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public NoticeDto getNotice(Long id) {
        Notice notice = noticeRepository.findById(id).get();

        NoticeDto noticeDto = NoticeDto.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .build();

        return noticeDto;
    }

    @Override
    public List<NoticeDto> getNotices() {
        List<Notice> notices = noticeRepository.findAll();
        List<NoticeDto> noticeDtos = notices.stream().map(Notice::convertToDto).collect(Collectors.toList());
        return noticeDtos;
    }

    @Override
    public NoticeDto saveNotice(NoticeDto noticeDto) {
        Notice notice = noticeDto.toEntity();
        Notice savedNotice = noticeRepository.save(notice);

        NoticeDto savedNoticeDto = NoticeDto.builder()
                .id(savedNotice.getId())
                .title(savedNotice.getTitle())
                .content(savedNotice.getContent())
                .build();

        return savedNoticeDto;
    }

    @Override
    public NoticeDto changeNotice(NoticeDto noticeDto) throws Exception {
        return null;
    }

    @Override
    public void deleteNotice(Long id) throws Exception {

    }
}
