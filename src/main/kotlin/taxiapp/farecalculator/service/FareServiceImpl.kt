package taxiapp.farecalculator.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import taxiapp.farecalculator.dto.RideFareTO

@Service
class FareServiceImpl : FareService {
    private val logger = LoggerFactory.getLogger(FareService::class.java)

    override fun getFare(distance: Int, duration: Long): RideFareTO {
        val amount = (500 + duration / 60 * 50).toInt()
        val driverProfit = getDriverProfit(amount)
        logger.info("Calculated fare: $amount | driver profit: $driverProfit")
        return RideFareTO(
            distance = distance,
            duration = duration,
            driverProfit = driverProfit,
            amount = amount
        );
    }

    override fun getDriverProfit(cost: Int): Int {
        return (cost * 0.8).toInt();
    }

}

