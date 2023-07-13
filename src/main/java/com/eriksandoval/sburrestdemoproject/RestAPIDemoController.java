package com.eriksandoval.sburrestdemoproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation tells Spring that this class is a REST controller
class RestAPIDemoController {

	private List<Coffee> coffees = new ArrayList<>();

    public RestAPIDemoController() {
        coffees.addAll(List.of(
            new Coffee("Café Cereza"),
            new Coffee("Café Ganador"),
            new Coffee("Café Lareño"),
            new Coffee("Café Três Pontas")
        ));
    }

    // Get Mapping for all coffees
    @GetMapping("/coffees")
    Iterable getCoffees() {
        return coffees;
    }

    // Get Mapping for a single coffee
    // If coffee is found, return it within the Optional, otherwise return empty Optional
    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee c: coffees) {
            if (c.getId().equals(id)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    // Post Mapping for a single coffee
    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }

    // Put Mapping for a single coffee
    // If coffee already exists, update it, otherwise add it
    @PutMapping("/coffees/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int index = -1;
        for (Coffee c: coffees) {
            if (c.getId().equals(id)) {
                index = coffees.indexOf(c);
                coffees.set(index, coffee);
            }
        }
        return (index == -1) ? postCoffee(coffee) : coffee;

    }

    // Delete Mapping for a single coffee
    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(c -> c.getId().equals(id));
    }





	
}
