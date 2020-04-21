package com.fileStudy.service;

import com.fileStudy.entity.file;

import java.util.List;

/**
 * @author Myriven
 * @date 2020/4/6 21:46
 * @description
 */
public interface fileService {

    int save(file fileObj);

    List<file> findAll();

    file findById(int id);
}
