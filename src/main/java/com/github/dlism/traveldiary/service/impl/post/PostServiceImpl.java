package com.github.dlism.traveldiary.service.impl.post;

import com.github.dlism.traveldiary.domain.entity.PostEntity;
import com.github.dlism.traveldiary.domain.repository.PostRepository;
import com.github.dlism.traveldiary.service.api.post.PostService;
import com.github.dlism.traveldiary.service.api.post.out.PostOut;
import com.github.dlism.traveldiary.service.impl.util.ModelEntityConvertor;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelEntityConvertor convertor;

    @PostConstruct
    private void fillDb(){
        if(!postRepository.findAll().isEmpty()){
            return;
        }
        List<PostEntity> postEntities = new ArrayList<>();
        for (int i=0; i<10; i++){
            var post = new PostEntity();
            post.setId(UUID.randomUUID());
            post.setText("Random string"+ i+1);
            post.setCreateDate(Instant.now());
            postEntities.add(post);
        }
        postRepository.saveAll(postEntities);
    }

    @Override
    public List<PostOut> findAll() {
        return postRepository.findAll().stream()
                .map(convertor::converter)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
