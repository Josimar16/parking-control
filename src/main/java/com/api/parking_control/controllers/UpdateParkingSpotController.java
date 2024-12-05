package com.api.parking_control.controllers;

import com.api.parking_control.dtos.ParkingSpotDto;
import com.api.parking_control.services.UpdateParkingSpotService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spots")
@AllArgsConstructor
public class UpdateParkingSpotController {
    final UpdateParkingSpotService updateParkingSpotService;

    @PutMapping
    public ResponseEntity<Object> handle(
        @PathVariable("id") UUID id,
        @RequestBody @Valid ParkingSpotDto updateParkingSpotDto
    ) {
        Object response = updateParkingSpotService.execute(id, updateParkingSpotDto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
