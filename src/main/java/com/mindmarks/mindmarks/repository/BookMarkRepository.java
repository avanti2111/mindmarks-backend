package com.mindmarks.mindmarks.repository;

import com.mindmarks.mindmarks.entity.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mindmarks.mindmarks.entity.User;

import java.util.List;

@Repository
public interface BookMarkRepository extends JpaRepository<BookMark, Long> {

    List<BookMark> findByUser(User user);

    List<BookMark> findByUserIdAndCollectionIsNull(User user);

    @Query("""
        SELECT b FROM BookMark b
        WHERE b.user.id = :userId
        AND (
            LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR LOWER(b.notes) LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR LOWER(b.url) LIKE LOWER(CONCAT('%', :keyword, '%'))
        )
    """)
    List<BookMark> searchUserBookmarks(Long userId, String keyword);

    List<BookMark> findByUserAndTitleContainingIgnoreCaseOrUserAndNotesContainingIgnoreCase(
            User user1, String title,
            User user2, String notes
    );

}

