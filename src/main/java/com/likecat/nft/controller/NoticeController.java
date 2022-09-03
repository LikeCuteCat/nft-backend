package com.likecat.nft.controller;

import com.likecat.nft.entity.Notice;
import com.likecat.nft.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    // Pagination 추가 예정
    @GetMapping("/notices")
    public List<Notice> getNotices() {
        List<Notice> noticeList = noticeRepository.findAll();
        return noticeList;
    }

    @GetMapping("/notices/{id}")
    public Optional<Notice> getNotice(@PathVariable Long id) {
        Optional<Notice> notice = noticeRepository.findById(id);
        return notice;
    }

    @PostMapping("/notices")
    public Notice postNotice(@RequestBody Notice notice) {
        System.out.println("notice.getTitle() = " + notice.getTitle());
        System.out.println("notice.getContent() = " + notice.getContent());
        return noticeRepository.save(notice);
    }

//    TODO
//    @PutMapping
//    @DeleteMapping
}
