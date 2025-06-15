package taxiapp.farecalculator.controller;

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import taxiapp.farecalculator.dto.response.RouteLengthTO
import taxiapp.farecalculator.service.FareService

@RestController
@RequestMapping("api/fare")
class FareController @Autowired constructor(
    @Value("\${service.address.maps}")
    private val mapsServiceAddress: String,
    private val fareService: FareService,
    private val restTemplate: RestTemplate
){
    @GetMapping("/calculate")
    fun getRouteLength(@RequestParam originId: String, @RequestParam destinationId: String): ResponseEntity<Any> {
        val routeLengthUri = UriComponentsBuilder
            .fromUriString("$mapsServiceAddress/api/maps/route")
            .queryParam("originId", originId)
            .queryParam("destinationId", destinationId)
            .build()
            .toUri()

        val response = restTemplate.getForEntity(routeLengthUri, RouteLengthTO::class.java)

        if (!response.statusCode.is2xxSuccessful) {
            return ResponseEntity.status(response.statusCode).body(response.body)
        }

        val body = response.body!!

        return ResponseEntity.ok(fareService.getFare(body.distance, body.duration));
    }

    @GetMapping("/health")
    fun health(): ResponseEntity<Map<String, String>> {
        return ResponseEntity.ok(mapOf(
            "status" to "UP",
            "service" to "farecalculator-service"
        ))
    }
}
