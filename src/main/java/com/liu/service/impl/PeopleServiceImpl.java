package com.liu.service.impl;

import com.liu.mapper.PeopleMapper;
import com.liu.model.People;
import com.liu.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujiayu on 2017/9/9.
 */
@Service("peopleService")
public class PeopleServiceImpl implements IPeopleService {

    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public List<People> selectPeople(){
        return peopleMapper.selectPeople();
    }

    @Override
    public void insertPeople(People people){
        peopleMapper.insertPeople(people);
    }

    @Override
    public People selectPeopleByName(String name){
        return peopleMapper.selectPeopleByName(name);
    }

    @Override
    public People selectPeopleByMail(String mail){
        return peopleMapper.selectPeopleByMail(mail);
    }

    @Override
    public People selectPeopleById(int id){
        return peopleMapper.selectPeopleById(id);
    }

    @Override
    public void activePeople(int id){
        peopleMapper.activePeople(id);
    }

}
