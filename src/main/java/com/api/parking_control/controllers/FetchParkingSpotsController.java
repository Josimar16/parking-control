package com.api.parking_control.controllers;

import com.api.parking_control.models.ParkingSpotModel;
import com.api.parking_control.services.FetchParkingSpotsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spots")
@AllArgsConstructor
public class FetchParkingSpotsController {
    final FetchParkingSpotsService fetchParkingSpotsService;

    @GetMapping
    public ResponseEntity<Page<ParkingSpotModel>> handle(
        @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<ParkingSpotModel> parkingSpotModels = fetchParkingSpotsService.execute(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModels);
    }
}
