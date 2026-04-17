package com.lab14.diemlab.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "bill_details")
@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private int price;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;
}
