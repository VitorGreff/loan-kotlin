package greff.loan.services

import greff.loan.enums.LoanEnum
import greff.loan.schemas.Loan
import org.springframework.stereotype.Service

@Service
class CustomerServices {
    fun handleLoanType(age: Int, income: Float, location: String): ArrayList<Loan>{
        val loans = ArrayList<Loan>()

        if(income <=3000.00 || (income in 3000.0..5000.0 && age <30 && location == "SP") ){
            loans.add(Loan(LoanEnum.PERSONAL, 4))
            loans.add(Loan(LoanEnum.GUARANTEED, 3))
        }

        if(income >=5000.00)
            loans.add(Loan(LoanEnum.CONSIGNMENT, 2))
        return loans
    }
}