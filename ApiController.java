package me.mepv.hotel.controller;

import me.mepv.hotel.dto.ApiResponse;
import me.mepv.hotel.dto.HotelRequestDTO;
import me.mepv.hotel.dto.HotelResponseDTO;
import me.mepv.hotel.service.HotelServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/hotels")
public class ApiController {

    private final HotelServiceImplementation hotelServiceImplementation;

    public ApiController(HotelServiceImplementation hotelServiceImplementation) {
        this.hotelServiceImplementation = hotelServiceImplementation;
    }

    @GetMapping
    public ResponseEntity<Collection<HotelResponseDTO>> getAllHotels() {
        return new ResponseEntity<>(hotelServiceImplementation.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> saveHotel(@RequestBody HotelRequestDTO hotelRequest) {
        return new ResponseEntity<>(hotelServiceImplementation.saveHotel(hotelRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ApiResponse> updateHotel(@RequestBody HotelRequestDTO hotelRequest,
                                                   @RequestParam(value = "hotelCode") String hotelCode) {
        return new ResponseEntity<>(hotelServiceImplementation.updateHotelByHotelCode(hotelCode, hotelRequest), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteHotel(@RequestParam(value = "hotelCode") String hotelCode) {
        return new ResponseEntity<>(hotelServiceImplementation.deleteHotelByHotelCode(hotelCode), HttpStatus.OK);
    }
}
