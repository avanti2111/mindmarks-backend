package com.mindmarks.mindmarks.services;

import com.mindmarks.mindmarks.dto.BookMarkResponse;
import com.mindmarks.mindmarks.dto.BookmarkRequest;
import com.mindmarks.mindmarks.entity.BookMark;
import com.mindmarks.mindmarks.repository.BookMarkRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mindmarks.mindmarks.entity.User;
import com.mindmarks.mindmarks.entity.Collection;
import com.mindmarks.mindmarks.repository.CollectionRepository;

import java.util.List;

@Service
public class BookMarkService {

    private final BookMarkRepository bookmarkRepository;
    private final CollectionRepository collectionRepository;

    public BookMarkService(BookMarkRepository bookmarkRepository,
                           CollectionRepository collectionRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.collectionRepository = collectionRepository;
    }

    public BookMarkResponse create(User user, BookmarkRequest req) {

        BookMark b = new BookMark();
        b.setTitle(req.title);
        b.setUrl(req.url);
        b.setNotes(req.notes);
        b.setUser(user);

        // if (req.collectionId != null) {
        //     Collection c = collectionRepository.findById(req.collectionId)
        //             .orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Collection not found"));
        //     b.setCollection(c);
        // }

        bookmarkRepository.save(b);

        

        return new BookMarkResponse(
            b.getId(),
            b.getTitle(),
            b.getUrl(),
            b.getNotes(),
            b.getCollection() != null ? b.getCollection().getId() : null
        );
    }

    public List<BookMark> search(User user, String keyword) {
        return bookmarkRepository.searchUserBookmarks(user.getId(), keyword);
    }

    public List<BookMarkResponse> getAll(User user) {

        List<BookMark> bookmarks = bookmarkRepository.findByUser(user);
        return bookmarks.stream().map(b -> new BookMarkResponse(
            b.getId(),
            b.getTitle(),
            b.getUrl(),
            b.getNotes(),
            b.getCollection() != null ? b.getCollection().getId() : null
        )).toList();
    }

    public List<BookMarkResponse> searchBookmarks(User user, String query) {

    return bookmarkRepository
            .findByUserAndTitleContainingIgnoreCaseOrUserAndNotesContainingIgnoreCase(
                    user, query,
                    user, query
            )
            .stream()
            .map(bookmark -> new BookMarkResponse(
                    bookmark.getId(),
                    bookmark.getTitle(),
                    bookmark.getUrl(),
                    bookmark.getNotes(),
                    bookmark.getCollection() != null
                            ? bookmark.getCollection().getId()
                            : null
            ))
            .toList();
}
   
}
