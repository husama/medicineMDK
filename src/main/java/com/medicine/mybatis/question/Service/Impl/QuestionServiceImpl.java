package com.medicine.mybatis.question.Service.Impl;

import com.medicine.mybatis.question.Service.QuestionService;
import com.medicine.mybatis.question.dao.DoctorDao;
import com.medicine.mybatis.question.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private DoctorDao doctorDao;

    public Doctor getQuestion(){
        Doctor doctor=new Doctor();
        doctor.setDoctor_id(1);
        doctor.setDoctor_name("aa");
      //  doctorDao.add(Doctor.class.getName(),"setDoctor",null);
        System.out.print(Doctor.class.getName());
        return (Doctor)doctorDao.get(Doctor.class.getName(),"getDoctor",doctor);
      //  return null;
    }
}
