package com.startech.computer;

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
@RequestMapping("computers")
public class ComputerController {

    ComputerRepository computerRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Computer register(@RequestBody @Valid Computer computer) {
        return this.computerRepository.save(computer);
    }

    @GetMapping
    public Page<Computer> list(Pageable pageable) {
        return this.computerRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Computer> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.computerRepository.findById(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.computerRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Computer edit(@PathVariable Long id, @RequestBody @Valid Computer computer) {
        computer.setId(id);
        return computerRepository.save(computer);
    }
    
}
