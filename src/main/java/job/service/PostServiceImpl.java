package job.service;


import job.model.Post;
import job.repository.PostRepository;
import job.web.dto.PageRequestDTO;
import job.web.dto.PageResultDTO;
import job.web.dto.PostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.function.Function;

@Log4j2
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    @Override
    public Long register(PostDto dto) {
        log.info("DTO----------------");

        log.info(dto);

        Post entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getGno();
    }

    @Override
    public PageResultDTO<PostDto, Post> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        Page<Post> result = repository.findAll(pageable);

        Function<Post, PostDto> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);
    }
}
