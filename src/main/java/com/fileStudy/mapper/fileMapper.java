package com.fileStudy.mapper;

import com.fileStudy.entity.file;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Myriven
 * @date 2020/4/6 21:45
 * @description
 */
@Repository
public interface fileMapper {
    int save(file fileObj);

    List<file> findAll();


    file findById(int id);
}
