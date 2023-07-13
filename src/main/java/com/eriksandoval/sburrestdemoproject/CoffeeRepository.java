package com.eriksandoval.sburrestdemoproject;

import org.springframework.data.repository.CrudRepository;

interface CoffeeRepository extends CrudRepository<Coffee, String> {
    
}
