package com.startech.computer;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ComputerRepository extends PagingAndSortingRepository<Computer,Long>{
    
}
