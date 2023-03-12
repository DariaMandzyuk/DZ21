fun main() {
    calculateCommission(86000, "M", 10000)
}

var commission: Double = 0.0

fun calculateCommission(
    actualTransfer: Int,
    typeOfCard: String = "VKPay",
    previousTransfers: Int = 0
): Double {
    when (typeOfCard) {
        "VKPay" -> return calculateCommissionForVKPay()
        "MasterCard", "Maestro" -> return calculateCommissionForMasterCardOrMaestro(previousTransfers, actualTransfer)
        "Visa", "Mir" -> return calculateCommissionForVisaOrMir(actualTransfer)
    }
    return commission
}

fun calculateCommissionForVisaOrMir(actualTransfer: Int): Double {
    val minLimit = 35
    commission = actualTransfer * 0.0075
    if (commission <= minLimit) {
        commission = 35.0
    }
    println("Ваша комиссия составляет $commission рублей")
    return commission
}

fun calculateCommissionForMasterCardOrMaestro(previousTransfers: Int, actualTransfer: Int): Double {
    val allTransfers: Int = previousTransfers + actualTransfer
    val limit = 75000
    commission = if (allTransfers >= limit) {
        ((actualTransfer / 100) * 0.6) + 20
    } else {
        0.0
    }
    println("Ваша комиссия составляет $commission рублей")
    return commission
}

fun calculateCommissionForVKPay(): Double  {
    commission = 0.0
    println("Ваша комиссия составляет $commission рублей")
    return commission
}
