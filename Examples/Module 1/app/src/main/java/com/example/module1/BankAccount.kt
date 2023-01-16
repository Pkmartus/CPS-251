package com.example.module1

fun main() {
    val account1 = BankAccount(456456234, 342.98)
    val account2 = BankAccount(455565325, 456.28, "Martus")
    val balance1 = account1.balanceLessFees
    val savings1 = SavingsAccount(12311, 600.00, "Patrick",0.07)
    account1.balanceLessFees= 12123.12
    account1.displayBalance()
    println(savings1.calculateInterest())
    savings1.displayBalance()
}
//the open keyword allows other classes to inherit from this one
open class BankAccount(val accountNumber: Int, var accountBalance: Double) {

    var lastName: String = ""
    val fees: Double = 25.00
    var balanceLessFees: Double

        get() {
            return accountBalance-fees
        }
        set(value) {
            accountBalance=value-fees
        }


    constructor(accountNumber: Int, accountBalance: Double, name: String) : this(accountNumber, accountBalance) {
        lastName = name
    }

    open fun displayBalance() {
        println("Number $accountNumber")
        println("Current balance is $accountBalance")
    }
}
class SavingsAccount(accountNumber: Int, accountBalance: Double) : BankAccount(accountNumber, accountBalance) {

    var interestRate: Double = 0.0

    constructor(accountNumber: Int, accountBalance: Double, name: String, rate: Double): this(accountNumber, accountBalance){
        super.lastName= name
        interestRate=rate
    }

    fun calculateInterest(): Double{
        return interestRate*accountBalance
    }

    override fun displayBalance() {
        super.displayBalance()
        println("interest rate is $interestRate")
    }

}