package mpn.dev.jpa;

import mpn.dev.jpa.models.Author;
import mpn.dev.jpa.models.Video;
import mpn.dev.jpa.repositories.AuthorRepository;
import mpn.dev.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository repository,
            VideoRepository  videoRepository
    ) {
        return args -> {
            /*
            var author = Author.builder()
                    .firstname("John")
                    .lastname("doe")
                    .email("johndoe@gmail.com")
                    .age(30)
                    .build();
			repository.save(author);

             */
            var video = Video.builder()
                    .name("abc")
                    .length(5)
                    .build();

            videoRepository.save(video);
        };
    }

}
