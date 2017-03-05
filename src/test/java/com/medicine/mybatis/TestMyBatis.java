package com.medicine.mybatis;

import com.medicine.mybatis.question.Service.QuestionService;
import com.medicine.mybatis.question.entity.Doctor;
import com.medicine.neo4j.dao.GoogleProfileRepository;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:beans.xml"})

public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    @Resource
    private QuestionService questionService;
 //   @Autowired
  //  GoogleProfileRepository googleProfileRepository;

    @Test
    public void test1() {
        Doctor doctor = questionService.getQuestion();
         System.out.println(doctor.getHelpnum());
         logger.info("值："+doctor.getHelpnum());
   //     logger.info(JSON.toJSONString(user));
    }
}