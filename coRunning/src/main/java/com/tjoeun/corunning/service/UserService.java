package com.tjoeun.corunning.service;

import com.tjoeun.corunning.domain.User;
import com.tjoeun.corunning.repository.UserRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 1) 전체 조회 (이미 있을 수도 있음)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 2) 한 명 조회
    public User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다. id=" + userId));
    }

    // 3) 회원 생성
    public User createUser(User user) {
        // 여기서 userId 중복 체크, 비밀번호 암호화 등 나중에 넣을 수 있음
        return userRepository.save(user);
    }

    // 4) 회원 수정
    public User updateUser(String userId, User update) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다. id=" + userId));

        user.setUserPw(update.getUserPw());
        user.setUserName(update.getUserName());
        user.setBirthDate(update.getBirthDate());
        user.setHireDate(update.getHireDate());
        user.setPhone(update.getPhone());
        user.setUserAddress(update.getUserAddress());

        return userRepository.save(user);
    }

    // 5) 회원 삭제
    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("사용자를 찾을 수 없습니다. id=" + userId);
        }
        userRepository.deleteById(userId);
    }
}
