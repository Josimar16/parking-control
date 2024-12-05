package com.api.parking_control.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "parking_spots")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "parking_spot_number", nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(name = "license_plate_car", nullable = false, unique = true, length = 7)
    private String licensePlateCar;

    @Column(name = "brand_car", nullable = false, length = 70)
    private String brandCar;

    @Column(name = "model_car", nullable = false, length = 70)
    private String modelCar;

    @Column(name = "color_car", nullable = false, length = 70)
    private String colorCar;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "responsible_name", nullable = false, length = 130)
    private String responsibleName;

    @Column(name = "apartment", nullable = false, length = 30)
    private String apartment;

    @Column(name = "block", nullable = false, length = 30)
    private String block;
}
