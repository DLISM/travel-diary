package com.github.dlism.traveldiary.model.out;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.Instant;

@Data
@Builder
@Schema(description = "Объект поста")
public class PostRestOut {
    @Schema(description = "Теккст поста")
    private String text;

    @Schema(description = "Время создания поста")
    private Instant createDate = Instant.now();

    @Schema(description = "Время обновления")
    private Instant updateDate;
}
