package com.github.dlism.traveldiary.controller.post;

import com.github.dlism.traveldiary.controller.util.DtoModelConvertor;
import com.github.dlism.traveldiary.model.in.PostRestIn;
import com.github.dlism.traveldiary.model.out.ErrorRestOut;
import com.github.dlism.traveldiary.model.out.PostRestOut;
import com.github.dlism.traveldiary.service.api.post.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1.0/post")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Операция с постами", description = "Создание и удаления постов")
public class PostController {

    private final PostService postService;
    private final DtoModelConvertor  convertor;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Получит все посты")
    @ApiResponse(responseCode = "200", description = "Операци успешно")
    @ApiResponse(responseCode = "400", description = "Не корректный формат запроса",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class)))
    @ApiResponse(responseCode = "500", description = "Внутренная ошибка сервера",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class)))
    public List<PostRestOut> getAllPosts() {
        return postService.findAll().stream()
                .map(convertor::convert)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Создать пост")
    @ApiResponse(responseCode = "200", description = "Операци успешно")
    @ApiResponse(responseCode = "400", description = "Не корректный формат запроса",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class)))
    @ApiResponse(responseCode = "500", description = "Внутренная ошибка сервера",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class)))
    public PostRestOut createPost(
            @Parameter(description = "Тело поста")
            @Valid
            @RequestBody PostRestIn post
            ) {

        return
                convertor.convert(
                postService.createPost(
                        convertor.convert(post)
                )
                ).orElse(null);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Обновить пост")
    @ApiResponse(responseCode = "200", description = "Операци успешно")
    @ApiResponse(responseCode = "400", description = "Не корректный формат запроса",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class)))
    @ApiResponse(responseCode = "500", description = "Внутренная ошибка сервера",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class)))
    public PostRestOut updatePost(
            @Parameter(description = "Тело поста")
            @Valid
            @RequestBody PostRestIn post
    ) {

        return
                convertor.convert(
                        postService.createPost(
                                convertor.convert(post)
                        )
                ).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(description = "Удалить пост")
    @ApiResponse(responseCode = "200", description = "Операци успешно")
    @ApiResponse(responseCode = "400", description = "Не корректный формат запроса",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class)))
    @ApiResponse(responseCode = "500", description = "Внутренная ошибка сервера",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class)))
    public Boolean deletePost(
            @Parameter(description = "Id поста")
            @PathVariable("id") UUID id
            ) {

        return postService.delete(id);
    }
}
