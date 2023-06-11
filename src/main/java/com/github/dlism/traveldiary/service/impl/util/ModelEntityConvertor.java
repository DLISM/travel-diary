package com.github.dlism.traveldiary.service.impl.util;

import com.github.dlism.traveldiary.domain.entity.PostEntity;
import com.github.dlism.traveldiary.service.api.post.in.PostIn;
import com.github.dlism.traveldiary.service.api.post.out.PostOut;
import com.github.dlism.traveldiary.service.impl.post.out.BasePostOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

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

    public PostEntity converter(PostIn post) {
        var postEntity = new PostEntity();
        postEntity.setId(
                Optional.of(post)
                        .map(PostIn::getId)
                        .orElse(UUID.randomUUID())
        );

        postEntity.setText(post.getText());

        return postEntity;
    }
}
