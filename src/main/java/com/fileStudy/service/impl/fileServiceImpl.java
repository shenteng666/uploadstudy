package com.fileStudy.service.impl;

import com.fileStudy.entity.file;
import com.fileStudy.mapper.fileMapper;
import com.fileStudy.service.fileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Myriven
 * @date 2020/4/6 21:46
 * @description
 */
@Service
public class fileServiceImpl implements fileService {
    @Autowired
    private fileMapper fileMapper;

    @Override
    public int save(file fileObj) {
        int save = fileMapper.save(fileObj);
        return save;
    }

    @Override
    public List<file> findAll() {
        List<file> fileList = fileMapper.findAll();
        return fileList;
    }

    @Override
    public file findById(int id) {
        file f = fileMapper.findById(id);
        return f;
    }
}
