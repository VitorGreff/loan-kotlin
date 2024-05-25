package greff.loan.controllers

import greff.loan.repositories.CustomerRepository
import greff.loan.schemas.Loan
import greff.loan.services.CustomerServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerServices
    @Autowired
    private lateinit var customerRepo: CustomerRepository

    data class CustomerResponse(
        val name: String,
        val loans: List<Loan>
    )

    @GetMapping
    @RequestMapping("/customer")
    fun listAllCustomers() = customerRepo.findAll()

    @PostMapping
    @RequestMapping("customer-loans")
    fun checkLoans(@RequestBody customer: greff.loan.schemas.Customer): ResponseEntity<CustomerResponse>{
        customerRepo.save(customer)
        val loans = customerService.handleLoanType(customer.age, customer.income, customer.location)
        return ResponseEntity.ok().body(CustomerResponse(customer.name, loans))
    }
}