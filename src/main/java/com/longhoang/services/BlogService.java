package com.longhoang.services;

import com.longhoang.models.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);
}
