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
@RequestMapping("roles")
public class RoleController {

    RoleRepository roleRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Role register(@RequestBody @Valid Role role) {
        return this.roleRepository.save(role);
    }

    @GetMapping
    public Page<Role> list(Pageable pageable) {
        return this.roleRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.roleRepository.findById(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.roleRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Role edit(@PathVariable Long id, @RequestBody @Valid Role role) {
        role.setId(id);
        return roleRepository.save(role);
    }
    
}
