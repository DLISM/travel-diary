package com.github.dlism.traveldiary.model.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Builder
@Schema(description = "Объект поста")
public class PostRestIn {
    @Schema(description = "Id поста")
    private UUID id;

    @Schema(description = "Текст поста")
    @NotNull
    private String text;
}
