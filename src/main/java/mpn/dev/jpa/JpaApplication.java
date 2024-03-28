package mpn.dev.jpa;

import com.github.javafaker.Faker;
import mpn.dev.jpa.models.Author;
import mpn.dev.jpa.repositories.AuthorRepository;
import mpn.dev.jpa.repositories.VideoRepository;
import mpn.dev.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

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
            for(int i=0 ; i < 50 ; i++){
                Faker faker = new Faker();
                var author = Author.builder()
                        .firstName(faker.name().firstName())
                        .lastname(faker.name().lastName())
                        .email("johndoe" + i +"@gmail.com")
                        .age(faker.number().numberBetween(19,50))
                        .build();
//                repository.save(author);
            }

            var author = Author.builder()
                    .id(1)
                    .firstName("John")
                    .lastname("doe")
                    .email("johndoe@gmail.com")
                    .age(30)
                    .build();
//			repository.save(author);

            //update author a set a.age = 22 where a.id = 1
//            repository.updateAuthor(22,1);

//            repository.updateAllAuthorsAges(99);

//
//            repository.findByNamedQuery(70)
//                    .forEach(System.out::println);

//            repository.updateByNamedQuery(12);



//            var video = Video.builder()
//                    .name("abc")
//                    .length(5)
//                    .build();
//
//            videoRepository.save(video);

            Specification<Author> spec = Specification
                    .where(AuthorSpecification.hasAge(22))
                    .and(AuthorSpecification.firstnameContains("Mi"));

            repository.findAll(spec).forEach(System.out::println);
        };

    }

}
