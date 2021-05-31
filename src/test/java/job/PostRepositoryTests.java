package job;


import job.model.Post;
import job.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class PostRepositoryTests {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void insertDummies(){

        IntStream.rangeClosed(1,300).forEach(i -> {

            Post post = Post.builder()
                    .title("Title....." + i)
                    .content("Contnent...." + i)
                    .writer("user" + (i % 10))
                    .build();

            System.out.println(postRepository.save(post));
        });

        Optional<Post> result = postRepository.findById(300L);

        if (result.isPresent()) {
            Post post = result.get();

            post.changeTitle("Changed Title....!");

            post.changeContent("changed Content....!");

            postRepository.save(post);
        }
    }
}
