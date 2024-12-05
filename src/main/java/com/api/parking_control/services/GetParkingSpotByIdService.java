package com.api.parking_control.services;

import com.api.parking_control.models.ParkingSpotModel;
import com.api.parking_control.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GetParkingSpotByIdService {
    final ParkingSpotRepository parkingSpotRepository;

    public Object execute(UUID id) {
        Optional<ParkingSpotModel> parkingSpotModel = parkingSpotRepository.findById(id);

        if (parkingSpotModel.isEmpty()) {
            return "Parking spot not found";
        }

        return parkingSpotModel.get();
    }
}
