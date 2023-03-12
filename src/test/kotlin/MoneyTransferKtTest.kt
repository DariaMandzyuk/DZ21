import org.junit.Assert.assertEquals
import org.junit.Test


class MoneyTransferKtTest {

    @Test
    fun shouldCalculateCommissionForMirAndVisa() {
        val actualTransfer = 5000
        val typeOfCard = "Mir"
        val previousTransfers = 0

        val result = calculateCommission(actualTransfer, typeOfCard, previousTransfers)

        assertEquals(37.5, result, 0.0)
    }

    @Test
    fun shouldCalculateMinimalCommissionForMirAndVisa() {
        val actualTransfer = 1000
        val typeOfCard = "Mir"
        val previousTransfers = 0

        val result = calculateCommission(actualTransfer, typeOfCard, previousTransfers)

        assertEquals(35.0, result, 0.0)
    }

    @Test
    fun shouldCalculateCommissionForVKPay() {
        val actualTransfer = 5000
        val typeOfCard = "VKPay"
        val previousTransfers = 0

        val result = calculateCommission(actualTransfer, typeOfCard, previousTransfers)

        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun shouldCalculateCommissionForMastercardAndMaestro() {
        val actualTransfer = 5000
        val typeOfCard = "Maestro"
        val previousTransfers = 0

        val result = calculateCommission(actualTransfer, typeOfCard, previousTransfers)

        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun shouldCalculateMaxCommissionForMastercardAndMaestro() {
        val actualTransfer = 76000
        val typeOfCard = "Maestro"
        val previousTransfers = 0

        val result = calculateCommission(actualTransfer, typeOfCard, previousTransfers)

        assertEquals(476.0, result, 0.0)
    }

    @Test
    fun shouldCalculateMaxCommissionForMastercardAndMaestroWithPrevTransfers() {
        val actualTransfer = 86000
        val typeOfCard = "Maestro"
        val previousTransfers = 10000

        val result = calculateCommission(actualTransfer, typeOfCard, previousTransfers)

        assertEquals(536.0, result, 0.0)
    }

    @Test
    fun shouldCalculateCommissionWhenWrongCard() {
        val actualTransfer = 86000
        val typeOfCard = "M"
        val previousTransfers = 10000

        val result = calculateCommission(actualTransfer, typeOfCard, previousTransfers)

        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun shouldCalculateCommissionWhenNoCard() {
        val actualTransfer = 86000

        val result = calculateCommission(actualTransfer)

        assertEquals(0.0, result, 0.0)
    }
}