package by.karpov.ITSPartnertask.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "lamps")
@Proxy(lazy = false)
public class Lamp extends BaseEntity {

    @Column(name = "lamp_condition")
    private String lampCondition;

}
