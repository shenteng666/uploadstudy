package com.fileStudy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author Myriven
 * @date 2020/4/6 21:45
 * @description
 */
public class file implements Serializable {

    private int id;
    private String oldFileName;
    private String newFileName;
    private String ext;
    private String path;
    private String size;
    private String type;


    public file() {
    }

    public file(int id, String oldFileName, String newFileName, String ext, String path, String size, String type) {
        this.id = id;
        this.oldFileName = oldFileName;
        this.newFileName = newFileName;
        this.ext = ext;
        this.path = path;
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return "file{" +
                "id=" + id +
                ", oldFileName='" + oldFileName + '\'' +
                ", newFileName='" + newFileName + '\'' +
                ", ext='" + ext + '\'' +
                ", path='" + path + '\'' +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof file)) return false;
        file file = (file) o;
        return id == file.id &&
                Objects.equals(oldFileName, file.oldFileName) &&
                Objects.equals(newFileName, file.newFileName) &&
                Objects.equals(ext, file.ext) &&
                Objects.equals(path, file.path) &&
                Objects.equals(size, file.size) &&
                Objects.equals(type, file.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oldFileName, newFileName, ext, path, size, type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldFileName() {
        return oldFileName;
    }

    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
