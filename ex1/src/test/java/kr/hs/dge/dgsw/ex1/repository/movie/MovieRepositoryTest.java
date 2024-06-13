package kr.hs.dge.dgsw.ex1.repository.movie;

import kr.hs.dge.dgsw.ex1.entity.movie.MovieEntity;
import kr.hs.dge.dgsw.ex1.entity.movie.MovieImageEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieImageRepository movieImageRepository;

    @Test
    void insetMovie() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            MovieEntity movieEntity = MovieEntity.builder()
                    .title("Movie..." + i)
                    .build();
            movieRepository.save(movieEntity);
            int cnt = (int) (Math.random() * 5) + 1;
            for (int j = 0; j < cnt; j++) {
                MovieImageEntity movieImageEntity = MovieImageEntity.builder()
                        .uuid(UUID.randomUUID().toString())
                        .imgName("test" + j + ".jpeg")
                        .movieEntity(movieEntity)
                        .build();
                movieImageRepository.save(movieImageEntity);
            }
        });
    }
}