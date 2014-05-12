package com.juzhi.controller;

import com.juzhi.dao.TestDao;
import com.juzhi.entity.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by xjwan on 5/10/14.
 */
@Controller
public class TestController {
    @Autowired
    private TestDao testDao;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String testHello(){
        Hello hello = new Hello();
        hello.setName("helloworld");
        testDao.saveHello(hello);
        return "hello";
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public ModelAndView findHello(Model model){
        int id=27 ;
       List<Hello> hellos = testDao.findHelloById(id);
        model.addAttribute("tests",hellos);
        return new ModelAndView("success");
    }
}
