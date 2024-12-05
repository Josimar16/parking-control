package com.api.parking_control.services;

import com.api.parking_control.dtos.ParkingSpotDto;
import com.api.parking_control.models.ParkingSpotModel;
import com.api.parking_control.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateParkingSpotService {
    final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public Object execute(
        UUID id,
        ParkingSpotDto updateParkingSpotDto
    ) {
        Optional<ParkingSpotModel> parkingSpotModelAlreadyExists = parkingSpotRepository.findById(id);

        if (parkingSpotModelAlreadyExists.isEmpty()) {
            return "Parking spot not found";
        }

        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(updateParkingSpotDto, parkingSpotModel);
        parkingSpotModel.setId(parkingSpotModelAlreadyExists.get().getId());
        parkingSpotModel.setRegistrationDate(parkingSpotModelAlreadyExists.get().getRegistrationDate());

        parkingSpotRepository.save(parkingSpotModel);

        return "Parking spot deleted";
    }
}
