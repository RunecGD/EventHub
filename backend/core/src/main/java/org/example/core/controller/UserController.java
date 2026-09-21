package org.example.core.controller;

import lombok.RequiredArgsConstructor;
import org.example.core.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok("Пользователь с id:" + id + " успешно удалено");
    }


}
