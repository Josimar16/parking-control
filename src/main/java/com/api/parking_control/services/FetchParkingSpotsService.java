package com.api.parking_control.services;

import com.api.parking_control.models.ParkingSpotModel;
import com.api.parking_control.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FetchParkingSpotsService {
    final ParkingSpotRepository parkingSpotRepository;

    public Page<ParkingSpotModel> execute(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }
}
