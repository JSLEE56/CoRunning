package com.tjoeun.corunning.controller;

import com.tjoeun.corunning.domain.User;
import com.tjoeun.corunning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //전체 조회
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //한 명 조회
    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    //생성
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    //수정
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User update) {
        return userService.updateUser(userId, update);
    }

    //삭제
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}

