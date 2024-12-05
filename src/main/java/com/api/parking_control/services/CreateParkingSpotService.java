package com.api.parking_control.services;

import com.api.parking_control.dtos.ParkingSpotDto;
import com.api.parking_control.models.ParkingSpotModel;
import com.api.parking_control.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@AllArgsConstructor
public class CreateParkingSpotService {
    final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public Object execute(ParkingSpotDto createParkingSpotDto) {
        if (parkingSpotRepository.existsByLicensePlateCar(createParkingSpotDto.getLicensePlateCar())) {
            return "License plate already registered";
        }

        if (parkingSpotRepository.existsByParkingSpotNumber(createParkingSpotDto.getParkingSpotNumber())) {
            return "Parking spot number already registered";
        }

        if (parkingSpotRepository.existsByApartmentAndBlock(
            createParkingSpotDto.getApartment(),
            createParkingSpotDto.getBlock())
        ) {
            return "Apartment and block already registered";
        }

        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();

        BeanUtils.copyProperties(createParkingSpotDto, parkingSpotModel);

        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        parkingSpotRepository.save(parkingSpotModel);

        return parkingSpotModel;
    }
}
