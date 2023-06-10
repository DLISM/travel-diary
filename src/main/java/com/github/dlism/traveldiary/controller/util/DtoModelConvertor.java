package com.github.dlism.traveldiary.controller.util;

import com.github.dlism.traveldiary.model.out.PostRestOut;
import com.github.dlism.traveldiary.service.api.post.out.PostOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DtoModelConvertor {
    public Optional<PostRestOut> convert(PostOut postOut) {
        if (postOut == null) {
            return Optional.empty();
        }
        return Optional.of(
                PostRestOut.builder()
                        .text(postOut.getText())
                        .createDate(postOut.getCreateDate())
                        .updateDate(postOut.getUpdateDate())
                        .build()
        );
    }
}
