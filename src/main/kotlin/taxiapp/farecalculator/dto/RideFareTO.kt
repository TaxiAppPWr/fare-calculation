package taxiapp.farecalculator.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.http.HttpStatus

data class RideFareTO(
    val distance: Int,
    val duration: Long,
    val amount: Int,
    val driverProfit: Int
)