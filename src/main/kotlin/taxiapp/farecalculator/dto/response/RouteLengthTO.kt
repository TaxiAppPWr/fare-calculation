package taxiapp.farecalculator.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.http.HttpStatus

data class RouteLengthTO(
    val distance: Int,
    val duration: Long,

    @JsonIgnore
    override val httpStatus: HttpStatus = HttpStatus.OK,
    @JsonIgnore
    override val messages: List<String>? = null,
    
) : ResponseInterface
