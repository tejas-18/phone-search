package com.example.phonesearch.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "phones")
public class Phone {

    @Id
private Long id;
private String brand_name;
private String model;
private double price;
private double avg_rating;
private boolean is_5G;
private String processor_brand;
private int num_cores;
private double processor_speed;
private int battery_capacity;
private boolean fast_charging_available;
private String fast_charging;
private int ram_capacity;
private int internal_memory;
private double screen_size;
private int refresh_rate;
private int num_rear_cameras;
private String os;
private String primary_camera_rear;
private String primary_camera_front;
private boolean extended_memory_available;
private int resolution_height;
private int resolution_width;

}
