package com.api.parking_control.controllers;

import com.api.parking_control.dtos.ParkingSpotDto;
import com.api.parking_control.services.CreateParkingSpotService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spots")
@AllArgsConstructor
public class CreateParkingSpotController {
    final CreateParkingSpotService createParkingSpotService;

    @PostMapping
    public ResponseEntity<Object> handle(@RequestBody @Valid ParkingSpotDto createParkingSpotDto) {
        Object response = createParkingSpotService.execute(createParkingSpotDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
