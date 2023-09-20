package com.techreturners.apilab1.controller;

import com.techreturners.apilab1.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CoffeeController {
    private final AtomicLong counter = new AtomicLong();
    @GetMapping(value="/coffeelover")
    public String coffee(){
        return "I like coffee!";
    }

    @GetMapping(value="/coffee")
    public Coffee getCoffee(@RequestParam(value="name", defaultValue="latte")
                                String name){
       return new Coffee(counter.incrementAndGet(), name);
    }

    @GetMapping(value="/coffeeflavour")
    public String getCoffeeFlavour(@RequestParam(value="name", defaultValue="latte")
                                   String name){

        return "I like "+new Coffee(counter.incrementAndGet(), name).getName();
    }

}
