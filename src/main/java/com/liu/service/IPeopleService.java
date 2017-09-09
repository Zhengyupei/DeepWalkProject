package com.liu.service;

import com.liu.model.People;

import java.util.List;

/**
 * Created by liujiayu on 2017/9/9.
 */
public interface IPeopleService {

    List<People> selectPeople();

    void insertPeople(People people);

    People selectPeopleByName(String name);

    People selectPeopleByMail(String mail);

    People selectPeopleById(int id);

    void activePeople(int id);
}
