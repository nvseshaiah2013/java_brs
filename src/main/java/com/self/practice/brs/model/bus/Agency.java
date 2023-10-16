package com.self.practice.brs.model.bus;

import com.self.practice.brs.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "AGENCY", indexes = @Index(
        name = "IDX_AGENCY_CODE",
        columnList = "code",
        unique = true
))
@Getter
@NoArgsConstructor
@Setter
public class Agency {

    @Id
    @Column(name = "AGENCY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DETAILS")
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_USER_ID")
    private User owner;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private Set<Bus> buses;
}
