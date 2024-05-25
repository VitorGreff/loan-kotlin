package greff.loan.schemas

import jakarta.persistence.*
import java.io.Serializable
import java.util.UUID

@Entity
@Table(name = "customer")
class Customer(
    val age: Int,
    val cpf: String,
    val name: String,
    val income: Float,
    val location: String,
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?
): Serializable {
}