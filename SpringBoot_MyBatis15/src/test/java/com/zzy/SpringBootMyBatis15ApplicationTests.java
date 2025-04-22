package com.zzy;

import com.zzy.mapper.UserMapper;
import com.zzy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMyBatis15ApplicationTests {

    @Autowired
    private UserMapper mapper;
    @Test
    void findAllTest() {

        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    void deleteByIdTest() {
        int i = mapper.deleteById(30);
        System.out.println("influenced row:"+i);

    }

    @Test
    void updateByIdTest() {
        User user = new User(1, "Sheldon", "12345678", "SheldonCooper", 35);
        int i = mapper.updateById(user);
        System.out.println("influenced row:"+i);

    }

    @Test
    void findByUsernameAndPasswordTest() {
        User sophia = mapper.findByUsernameAndPassword("sophia", "123456");
        System.out.println("user:"+sophia);

    }



}
