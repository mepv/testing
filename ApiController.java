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
    
    public String romoteTesting() {
        return "testing from remote repository";   
    }

    @GetMapping
    public ResponseEntity<Collection<HotelResponseDTO>> findAllHotels() {
        return new ResponseEntity<>(hotelServiceImplementation.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> saveHotel(@RequestBody HotelRequestDTO hotelRequest) {
        return new ResponseEntity<>(hotelServiceImplementation.saveHotel(hotelRequest), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteHotel(@RequestParam(value = "hotelCode") String hotelCode) {
        return new ResponseEntity<>(hotelServiceImplementation.deleteHotelByHotelCode(hotelCode), HttpStatus.OK);
    }
}
