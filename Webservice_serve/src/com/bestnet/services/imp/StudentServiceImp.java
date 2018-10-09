package com.bestnet.services.imp;

import com.bestnet.dao.imp.StudentDaoImp;
import com.bestnet.services.StudentService;
import com.bestnet.vo.StudentEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebService;
import java.util.List;

@Service
@WebService(serviceName = "/student",targetNamespace = "http://bestnet.cn")
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDaoImp studentDaoImp;

    @Override
    public List<StudentEntity> loadStudent() {
        List<StudentEntity> list = studentDaoImp.getStudentEntity();
        System.out.println("In StudentServiceImp loadStudent StudentEntity:"+list);
        return list;
    }

    @Override
    public void addStudent() {
        studentDaoImp.addStudent();
    }

    @Override
    public String qryStudentEntityByid() {
        List list = studentDaoImp.qryStudentEntityById();
        //JSONObject jsonObject = JSONObject.fromObject(list);
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println("jsonArray.toString():"+jsonArray.toString());
        return jsonArray.toString();
    }


}
