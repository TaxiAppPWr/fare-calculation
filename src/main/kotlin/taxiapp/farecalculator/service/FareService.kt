package taxiapp.farecalculator.service

interface FareService {
    fun getFare(distance: Int, duration: Long): Double
}