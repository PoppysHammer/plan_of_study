package org.example.springframework.test.bean;

public class UserService {
    private String name;

    public void queryUserService() {
        System.out.println("查询用户信息");
    }

    public UserService(String name) {
        this.name = name;
    }
}
