package greff.loan.repositories

import greff.loan.schemas.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CustomerRepository : CrudRepository<Customer, Long>{
}