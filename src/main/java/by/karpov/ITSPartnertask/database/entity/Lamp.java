package by.karpov.ITSPartnertask.database.entity;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

@Entity
@Table(name = "lamps")
@Proxy(lazy = false)
public class Lamp extends BaseEntity {

    @Column(name = "lamp_condition")
    private String lampCondition;

}
