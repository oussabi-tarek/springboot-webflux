package com.springboot.webflux.service;

import com.springboot.webflux.dao.CustomerDao;
import com.springboot.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
   @Autowired
   private CustomerDao customerDao;

   public List<Customer> loadAllCustomers(){
       long start = System.currentTimeMillis();
       List<Customer> customers=customerDao.getCustomers();
       long end = System.currentTimeMillis();
       System.out.println("Total time Taken : "+(end-start));
         return customers;
   }
    public Flux<Customer> loadAllCustomersStream(){
        long start = System.currentTimeMillis();
        Flux<Customer> customers=customerDao.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total time Taken stream : "+(end-start));
        return customers;
    }

}
