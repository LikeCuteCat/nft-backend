package com.likecat.nft.controller;

import com.likecat.nft.entity.notice.NoticeDto;
import com.likecat.nft.service.NoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/notice")
    public ResponseEntity getNotices() {
        List<NoticeDto> notices = noticeService.getNotices();

        return ResponseEntity.status(HttpStatus.OK).body(notices);
    }

    @GetMapping("/notice/{id}")
    public ResponseEntity<NoticeDto> getNotice(@PathVariable Long id) {
        NoticeDto noticeDto = noticeService.getNotice(id);

        return ResponseEntity.status(HttpStatus.OK).body(noticeDto);
    }

    @PostMapping("/notice")
    public ResponseEntity<NoticeDto> createNotice(@RequestBody NoticeDto noticeDto) {
        NoticeDto savedNoticeDto = noticeService.saveNotice(noticeDto);

        return ResponseEntity.status(HttpStatus.OK).body(savedNoticeDto);
    }

}
