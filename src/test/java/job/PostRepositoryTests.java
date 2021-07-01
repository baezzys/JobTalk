package job;



import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import job.model.Post;
import job.model.QPost;
import job.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class PostRepositoryTests {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void updateTest() {
        Optional<Post> result = postRepository.findById(300L);

        if (result.isPresent()) {
            Post postbook = result.get();

            postbook.changeTitle("Change Title...");
            postbook.changeContent("Changed Content...");

            postRepository.save(postbook);
        }

    }

    @Test
    public void insertDummies(){

        IntStream.rangeClosed(1,300).forEach(i -> {

            Post post = Post.builder()
                    .title("Title....." + i)
                    .content("Contnent...." + i)
                    .writer("user" + (i % 10))
                    .build();

            postRepository.save(post);
        });

    }

    @Test
    public void testQuery1() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());

        QPost qPost = QPost.post;

        String keyword = "1";

        BooleanBuilder builder = new BooleanBuilder();

        BooleanExpression exContent = qPost.content.contains(keyword);

        BooleanExpression exTitle = qPost.title.contains(keyword);

        BooleanExpression exAll = exTitle.or(exContent);

        builder.and(exAll);

        builder.and(qPost.gno.gt(0L));

        Page<Post> result = postRepository.findAll(builder, pageable);

        result.stream().forEach(post -> {
            System.out.println(post);
        });


    }
}
