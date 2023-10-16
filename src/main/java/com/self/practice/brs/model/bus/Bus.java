package com.self.practice.brs.model.bus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BUS", indexes = @Index(
        name = "IDX_BUS_CODE",
        columnList = "code",
        unique = true
))
@Getter
@Setter
@NoArgsConstructor
public class Bus {

    @Id
    @Column(name = "BUS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "CAPACITY")
    private int capacity;

    @Column(name = "MAKE")
    private String make;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGENCY_ID")
    private Agency agency;
}
