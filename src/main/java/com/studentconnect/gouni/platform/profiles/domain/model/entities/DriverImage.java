package com.studentconnect.gouni.platform.profiles.domain.model.entities;

import com.studentconnect.gouni.platform.profiles.domain.model.aggregates.Driver;
import com.studentconnect.gouni.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class DriverImage extends AuditableModel {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String url;

    @ManyToOne
    @Getter
    @JoinColumn(name="driver_id", nullable = false)
    private Driver driver;

    public DriverImage(){
    }

    public DriverImage(String url) {
        this.url = url;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
