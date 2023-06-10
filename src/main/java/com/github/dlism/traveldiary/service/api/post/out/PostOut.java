package com.github.dlism.traveldiary.service.api.post.out;

import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.UUID;

public interface PostOut {
     UUID getId();

     String getText();

     Instant getCreateDate();

     Instant getUpdateDate();
}
