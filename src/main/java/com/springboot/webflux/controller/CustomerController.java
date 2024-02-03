package com.springboot.webflux.controller;

import com.springboot.webflux.dto.Customer;
import com.springboot.webflux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.loadAllCustomers();
    }

    // to benefit from reactive programming, we need to return a Flux object
    // and set the produces attribute of the
    // @GetMapping annotation to MediaType.TEXT_EVENT_STREAM_VALUE
    @GetMapping(value = "/stream",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream(){
        return customerService.loadAllCustomersStream();
    }


}
