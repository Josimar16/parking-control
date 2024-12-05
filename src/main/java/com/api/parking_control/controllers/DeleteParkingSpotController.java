package com.api.parking_control.controllers;

import com.api.parking_control.services.DeleteParkingSpotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spots")
@AllArgsConstructor
public class DeleteParkingSpotController {
    final DeleteParkingSpotService deleteParkingSpotService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> handle(@PathVariable("id") UUID id) {
        Object response = deleteParkingSpotService.execute(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
