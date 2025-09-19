package com.real_taxi.service.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "license_plate", unique = true)
    private String licensePlate;

    private String model;
    private String type; // Sedan, SUV, Mini, etc.

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}

