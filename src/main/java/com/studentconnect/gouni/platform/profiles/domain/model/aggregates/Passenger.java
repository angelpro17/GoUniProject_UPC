package com.studentconnect.gouni.platform.profiles.domain.model.aggregates;


import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.PassengerDNI;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.PassengerEmail;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.PassengerName;
import com.studentconnect.gouni.platform.profiles.domain.model.valueobjects.PassengerPhone;
import com.studentconnect.gouni.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Passenger extends AuditableAbstractAggregateRoot<Passenger> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Setter
    private PassengerName passengerName;

    @Embedded
    @Setter
    private PassengerEmail passengerEmail;


    @Embedded
    private PassengerDNI passengerDNI;

    @Embedded
    @Setter
    private PassengerPhone passengerPhone;

    @Getter
    @Setter
    private String passengerPhoto;


    public Passenger(String name, String email, Long dni, Long phone, String photo){
        this.passengerName = new PassengerName(name);
        this.passengerEmail = new PassengerEmail(email);
        this.passengerDNI = new PassengerDNI(dni);
        this.passengerPhone = new PassengerPhone(phone);
        this.passengerPhoto = photo;
    }

    public Passenger(){

    }

    public String getName(){
        return this.passengerName.getFullName();
    }

    public Long getDNI(){
        return this.passengerDNI.getDNI();
    }

    public String getEmail(){
        return this.passengerEmail.email();
    }

    public Long getPhone(){
        return this.passengerPhone.getPhone();
    }

    public String getPhoto(){
        return this.passengerPhoto;
    }

    // setters para actualizar los valores de los atributos
    public void setName(String name){
        this.passengerName = new PassengerName(name);
    }

    public void setEmail(String email){
        this.passengerEmail = new PassengerEmail(email);
    }

    public void setPhone(Long phone){
        this.passengerPhone = new PassengerPhone(phone);
    }

    public void setPhoto(String photo){
        this.passengerPhoto = photo;
    }


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }
}
