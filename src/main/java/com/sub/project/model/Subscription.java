package com.sub.project.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String serviceName; // name of the service e.g. prime
    private double price;
    private String currency; // e.g. USD, CAD
    private String paymentPeriod;
    private LocalDate nextRenewalDate; // very important, date of the next payment
}
