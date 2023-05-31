package com.startech.brand;

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
@RequestMapping("brands")
public class BrandController {
    
    BrandRepository brandRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Brand register(@RequestBody @Valid Brand brand) {
        return this.brandRepository.save(brand);
    }

    @GetMapping
    public Page<Brand> list(Pageable pageable) {
        return this.brandRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Brand> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.brandRepository.findById(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.brandRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Brand edit(@PathVariable Long id, @RequestBody @Valid Brand brand) {
        brand.setId(id);
        return brandRepository.save(brand);
    }
}
