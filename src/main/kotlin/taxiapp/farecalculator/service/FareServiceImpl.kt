package taxiapp.farecalculator.service

import org.springframework.stereotype.Service

@Service
class FareServiceImpl : FareService {
    override fun getFare(distance: Int, duration: Long): Double {
        return 5 + duration / 60 * .5;
    }

}

