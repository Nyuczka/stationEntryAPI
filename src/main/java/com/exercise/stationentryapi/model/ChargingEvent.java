package com.exercise.stationentryapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="charging_event")
public class ChargingEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "plug_in_event_id")
    private BigInteger pluginEventID;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "total_duration")
    private LocalTime totalDuration;

    @Column(name = "charging_time")
    private LocalTime chargingTime;

    @Column(name = "energy")
    private double energy;

    @Column(name = "ghg_savings")
    private double ghgSavings;

    @Column(name = "gasoline_savings")
    private double gasolineSavings;

    @Column(name = "ended_by")
    private String endedBy;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name="fee")
    private double fee;

    @Column(name="currency")
    private String currency;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "station_name")
    private Station station;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "port")
    private Port port;
}
