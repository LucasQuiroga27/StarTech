package com.startech.user;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    UserRepository userRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User register(@RequestBody @Valid User user) {
        return this.userRepository.save(user);
    }

    @GetMapping
    public Page<User> list(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.userRepository.findById(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.userRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public User edit(@PathVariable Long id, @RequestBody @Valid User user) {
        user.setId(id);
        return userRepository.save(user);
    }
    
}
