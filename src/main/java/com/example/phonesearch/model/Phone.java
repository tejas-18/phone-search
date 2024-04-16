package com.example.phonesearch.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand_name;
    private String model;
    private Double price;
    private Double avg_rating;
    private Boolean is_5G;
    private String processor_brand;
    private Integer num_cores;
    private Double processor_speed;
    private Integer battery_capacity;
    private Boolean fast_charging_available;
    private Integer fast_charging;
    private Integer ram_capacity;
    private Integer internal_memory;
    private Double screen_size;
    private Integer refresh_rate;
    private Integer num_rear_cameras;
    private String os;
    private Double primary_camera_rear;
    private Double primary_camera_front;
    private Boolean extended_memory_available;
    private Integer resolution_height;
    private Integer resolution_width;

}
