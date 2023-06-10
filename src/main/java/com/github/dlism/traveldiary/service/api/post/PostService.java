package com.github.dlism.traveldiary.service.api.post;

import com.github.dlism.traveldiary.service.api.post.out.PostOut;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PostService {
    List<PostOut> findAll();
}
