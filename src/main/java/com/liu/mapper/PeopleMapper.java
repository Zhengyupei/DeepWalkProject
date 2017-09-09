package com.liu.mapper;

import com.liu.model.People;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liujiayu on 2017/9/9.
 */
@Component
public interface PeopleMapper {

    List<People> selectPeople();

    void insertPeople(People people);

    People selectPeopleByName(String name);

    People selectPeopleByMail(String mail);

    People selectPeopleById(int id);

    void activePeople(int id);
}
