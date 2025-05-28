package taxiapp.farecalculator.service

import org.springframework.stereotype.Service
import taxiapp.farecalculator.dto.RideFareTO

@Service
class FareServiceImpl : FareService {
    override fun getFare(distance: Int, duration: Long): RideFareTO {
        val amount = 5 + duration / 60 * .5
        val driverProfit = getDriverProfit(amount)
        return RideFareTO(
            distance = distance,
            duration = duration,
            driverProfit = driverProfit,
            amount = amount
        );
    }

    override fun getDriverProfit(cost: Double): Double {
        return cost * 0.8;
    }

}

