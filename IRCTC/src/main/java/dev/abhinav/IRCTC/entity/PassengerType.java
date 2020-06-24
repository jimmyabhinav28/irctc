package dev.abhinav.IRCTC.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PassengerType extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="type_name")
    String typeName;

    @Column(name="type_desc")
    String typeDesc;
    @Column(name="discount_percentage")
    Float discountPercentage;
}
/*
id int not null primary key auto_increment,
type_name varchar(20),
type_desc varchar(200),
discount_percentage decimal(4,2),
created_at timestamp,
updated_at timestamp
 */