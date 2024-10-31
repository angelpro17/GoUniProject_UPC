package com.studentconnect.gouni.platform.profiles.domain.model.aggregates;

import com.studentconnect.gouni.platform.profiles.domain.model.entities.DriverImage;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.DriverEmail;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.DriverName;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.DriverPhone;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.DriverLicense;
import com.studentconnect.gouni.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Driver extends AuditableAbstractAggregateRoot<Driver> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Setter
    private DriverName driverName;

    @Embedded
    @Setter
    private DriverEmail driverEmail;

    @Embedded
    @Setter
    private DriverLicense driverLicense;

    @Embedded
    @Setter
    private DriverPhone driverPhone;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DriverImage> images = new ArrayList<>();


    @Getter
    @Setter
    private String driverImageProfile;

    @Getter
    @Setter
    private String driverDescription;

    public Driver(String name, String email, Long license, Long phone, String imageProfile, String description){
    this.driverName = new DriverName(name);
    this.driverEmail = new DriverEmail(email);
    this.driverLicense = new DriverLicense(license);
    this.driverPhone = new DriverPhone(phone);
    this.driverImageProfile = imageProfile;
    this.driverDescription = description;
    }

    public Driver(){
    }


    public void addImage(String url) {
        if (this.images.size() >= 6) {
           throw new IllegalArgumentException("Cannot add more than 6 images");
        }

        DriverImage image = new DriverImage(url);
        image.setDriver(this); // establecer la relación bidireccional
        this.images.add(image);
    }

    public void removeImage(Long imageId) {
    this.images.removeIf(image -> image.getId().equals(imageId));
    }

    public List<DriverImage> getImages() {
    return images;
    }

    public void setImages(List<DriverImage> images) {
    if (images.size() > 6) {
        throw new IllegalArgumentException("Cannot have more than 6 images");
    }
    this.images = images;
    }

    public String getName(){
    return this.driverName.getFullName();
    }

    public String getEmail(){
    return this.driverEmail.email();
    }

    public Long getLicense(){
    return this.driverLicense.driverLicense();
    }

    public Long getPhone(){
    return this.driverPhone.getDriverPhone();
    }

    public void setName(String name){
    this.driverName = new DriverName(name);
    }

    public void setEmail(String email){
    this.driverEmail = new DriverEmail(email);
    }

    public void setPhone(Long phone){
    this.driverPhone = new DriverPhone(phone);
    }

    public void setLicense(Long license){
    this.driverLicense = new DriverLicense(license);
    }

    public void setId(Long id) {
    this.id = id;
    }

    public Long getId() {
    return id;
    }
}
