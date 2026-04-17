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
@Table(name = "hoc_sinh")
@Entity
public class HocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "gioi_tinh")
    private boolean gioiTinh;
    @Column(name = "dia_chi")
    private String diaChi;
    @ManyToOne
    @JoinColumn(name = "lop_hoc_id")
    private LopHoc lopHoc;
}
