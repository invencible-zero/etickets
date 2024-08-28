package com.invencible_zero.etickets.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId")
    @JsonBackReference("city-theatres")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partnerId")
    @JsonBackReference("partner-theaters")
    private Partner partner;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("theater-screens")
    private List<Screen> screens;
}
