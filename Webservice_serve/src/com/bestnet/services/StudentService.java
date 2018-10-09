package com.bestnet.services;

import com.bestnet.vo.StudentEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://bestnet.cn")
public interface StudentService {
    public List<StudentEntity> loadStudent();

    public void addStudent();

    public String qryStudentEntityByid();
}
