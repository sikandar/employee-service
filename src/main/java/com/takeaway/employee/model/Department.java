package com.takeaway.employee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(indexes = {@Index(columnList = "name", unique = true)})
@NoArgsConstructor
public class Department {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department(UUID id) {
        this.id = id;
    }
}
