package taxiapp.farecalculator.service

import taxiapp.farecalculator.dto.RideFareTO

interface FareService {
    fun getFare(distance: Int, duration: Long): RideFareTO
    fun getDriverProfit(cost: Double): Double
}