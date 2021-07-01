package job;


import job.model.Post;
import job.repository.PostRepository;
import job.service.PostService;
import job.web.dto.PageRequestDTO;
import job.web.dto.PageResultDTO;
import job.web.dto.PostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PostServiceTests {

    @Autowired
    private PostService service;


    @Test
    public void testRegister() {

        PostDto postDto = PostDto.builder()
                .title("sample title...")
                .content("sample content...")
                .writer("user0")
                .build();

                System.out.println(service.register(postDto));
    }



    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<PostDto, Post> resultDTO = service.getList(pageRequestDTO);

        for (PostDto postDTO : resultDTO.getDtoList()) {
            System.out.println(postDTO);
        }
    }
}
