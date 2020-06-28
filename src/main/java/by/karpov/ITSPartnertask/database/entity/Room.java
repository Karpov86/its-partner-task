package by.karpov.ITSPartnertask.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "rooms")
@Proxy(lazy = false)
public class Room extends BaseEntity {

    @Column(name = "room_name")
    @NotBlank(message = "Room name can't be empty!")
    private String roomName;

    @Column(name = "country")
    @NotBlank(message = "Country can't be empty!")
    private String country;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lamp_id")
    private Lamp lamp;

}
