package com.github.dlism.traveldiary.service.impl.util;

import com.github.dlism.traveldiary.domain.entity.PostEntity;
import com.github.dlism.traveldiary.service.api.post.out.PostOut;
import com.github.dlism.traveldiary.service.impl.post.out.BasePostOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ModelEntityConvertor {

    public Optional<PostOut> converter(PostEntity postEntity) {
        if (postEntity == null) {
            return Optional.empty();
        }

        return Optional.of(
                BasePostOut.builder()
                        .id(postEntity.getId())
                        .text(postEntity.getText())
                        .createDate(postEntity.getCreateDate())
                        .updateDate(postEntity.getUpdateDate())
                        .build()
        );
    }
}
