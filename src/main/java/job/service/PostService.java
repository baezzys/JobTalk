package job.service;

import job.model.Post;
import job.web.dto.PageRequestDTO;
import job.web.dto.PageResultDTO;
import job.web.dto.PostDto;

public interface PostService {
    Long register(PostDto dto);

    PageResultDTO<PostDto, Post> getList(PageRequestDTO requestDTO);

    default Post dtoToEntity(PostDto dto) {
        Post entity = Post.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .picture(dto.getPicture())
                .build();

        return entity;
    }

    default PostDto entityToDto(Post entity) {

        PostDto dto = PostDto.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .picture(entity.getPicture())
                .regDate(entity.getRegdate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }
}
