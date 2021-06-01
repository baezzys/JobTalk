package job.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {

    private long gno;

    private String title;

    private String content;

    private String writer;

    private byte[] picture;

    private LocalDateTime regDate, modDate;
}
