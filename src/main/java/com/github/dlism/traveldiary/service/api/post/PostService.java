package com.github.dlism.traveldiary.service.api.post;

import com.github.dlism.traveldiary.model.in.PostRestIn;
import com.github.dlism.traveldiary.service.api.post.in.PostIn;
import com.github.dlism.traveldiary.service.api.post.out.PostOut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<PostOut> findAll();

    PostOut createPost(PostIn post);
    PostOut updatePost(PostIn post) throws Exception;

    Boolean delete(UUID id);
}
