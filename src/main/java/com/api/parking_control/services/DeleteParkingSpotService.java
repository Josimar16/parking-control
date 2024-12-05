package com.api.parking_control.services;

import com.api.parking_control.models.ParkingSpotModel;
import com.api.parking_control.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteParkingSpotService {
    final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public Object execute(UUID id) {
        Optional<ParkingSpotModel> parkingSpotModel = parkingSpotRepository.findById(id);

        if (parkingSpotModel.isEmpty()) {
            return "Parking spot not found";
        }

        parkingSpotRepository.deleteById(id);

        return "Parking spot deleted";
    }
}
