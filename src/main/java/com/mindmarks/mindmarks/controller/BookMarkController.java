package com.mindmarks.mindmarks.controller;


import com.mindmarks.mindmarks.dto.BookMarkResponse;
import com.mindmarks.mindmarks.dto.BookmarkRequest;
import com.mindmarks.mindmarks.entity.BookMark;
import com.mindmarks.mindmarks.services.BookMarkService;
import org.springframework.web.bind.annotation.*;
import com.mindmarks.mindmarks.entity.User;

import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


@RestController
@RequestMapping("/api/1/bookmarks")
public class BookMarkController {

    private final BookMarkService bookmarkService;

    public BookMarkController(BookMarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    // TEMP: replace with authenticated user later
    private User mockUser() {
        User user = new User();
        user.setId(1L);
        return user;
    }

    @PostMapping
    public BookMarkResponse create(@AuthenticationPrincipal User user, @RequestBody BookmarkRequest req) {
        return bookmarkService.create(user, req);
    }

    @GetMapping("/search")
    public List<BookMark> search(@AuthenticationPrincipal User user, @RequestParam String q) {
        return bookmarkService.search(user, q);
    }

    @GetMapping
    public List<BookMarkResponse> getAll(@AuthenticationPrincipal User user) {
        return bookmarkService.getAll(user);    
    }
}
