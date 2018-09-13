package com.bestnet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import com.bestnet.services.imp.PeopleServiceImp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping("people")
public class PeopleController extends MultiActionController {

    @Autowired
    private PeopleServiceImp peopleServiceImp;

    public String index(HttpServletRequest request, HttpServletResponse response){
        return "index";
    }

    //@RequestMapping(value = { "/toRunning" })
    public void toRunning(HttpServletRequest request, HttpServletResponse response){
        peopleServiceImp.running();
    }
}
