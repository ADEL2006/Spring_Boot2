package kr.hs.dge.dgsw.ex1.repository.movie;

import kr.hs.dge.dgsw.ex1.entity.MemberEntity;
import kr.hs.dge.dgsw.ex1.entity.movie.MovieEntity;
import kr.hs.dge.dgsw.ex1.entity.movie.ReviewEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void insertMovieReviews() {
        IntStream.rangeClosed(1, 200).forEach(i -> {
            long mno = (long) (Math.random() * 100) + 1;
            long mid = (long) (Math.random() * 100) + 1;
            String email = "user" + mid + "@aaa.com";
            MemberEntity memberEntity = MemberEntity.builder()
                    .email(email)
                    .build();

            MovieEntity movieEntity = MovieEntity.builder()
                    .mno(mno)
                    .build();

            ReviewEntity reviewEntity = ReviewEntity.builder()
                    .grade((int) (Math.random() * 5) + 1)
                    .text("Review....." + i)
                    .memberEntity(memberEntity)
                    .movieEntity(movieEntity)
                    .build();

            reviewRepository.save(reviewEntity);
        });
    }
}