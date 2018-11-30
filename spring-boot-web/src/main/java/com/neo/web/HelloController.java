package com.neo.web;



import javax.servlet.http.HttpSession;

import com.neo.entity.Demo;
import com.neo.entity.Test;

import com.neo.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    Logger logger= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    TestService testServiceImpl;

    @RequestMapping(value="/hello", method={RequestMethod.POST})
	public int hello(@RequestBody Test test) {
        logger.error("error"+test);
        logger.warn("warn"+test);
        logger.info("info"+test);
        logger.debug("test"+test);
        return testServiceImpl.insertOne(test);
	}
    
    @RequestMapping("/uid")
    String uid(HttpSession session) {
//        UUID uid = (UUID) session.getAttribute("uid");
//        if (uid == null) {
//            uid = UUID.randomUUID();
//        }
//        session.setAttribute("uid", uid);
//        return session.getId();
        return "123";
    }

    @RequestMapping(value = "/test",method = {RequestMethod.POST})
    @ResponseBody
    public String testPostMan(@RequestBody String id){
        logger.info("id:"+id);
        return null;
    }
}