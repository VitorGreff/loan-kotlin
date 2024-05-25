package greff.loan.controllers

import greff.loan.repositories.CustomerRepository
import greff.loan.schemas.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
    @Autowired
   lateinit var  customerRepo: CustomerRepository

    @RequestMapping("/customer")
    fun ListAllCustomers() = customerRepo.findAll()
}