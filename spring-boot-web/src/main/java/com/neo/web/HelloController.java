package com.neo.web;



import javax.servlet.http.HttpSession;

import com.neo.entity.Test;

import com.neo.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}