package com.bestnet.dao;


import com.bestnet.vo.StudentEntity;

import java.util.List;

public interface StudentDao {
    public List<StudentEntity> getStudentEntity();

    public void addStudent();

    public List qryStudentEntityById();
}
