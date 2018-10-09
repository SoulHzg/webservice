package com.bestnet.Controller;

import com.bestnet.services.imp.StudentServiceImp;
import com.bestnet.vo.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class StudentController extends MultiActionController {
    @Autowired
    private StudentServiceImp studentServiceImp;

    public void index(HttpServletRequest request, HttpServletResponse response){
        List<StudentEntity> list =  studentServiceImp.loadStudent();
        System.out.println("In StudentController index StudentEntity:"+list);
    }

    public void add(HttpServletRequest request, HttpServletResponse response){
        studentServiceImp.addStudent();
    }

}
