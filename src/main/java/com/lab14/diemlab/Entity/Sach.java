package com.lab14.diemlab.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "sach")
@Entity
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ten_sach")
    private String tenSach;
    @Column(name = "gia")
    @Min(value = 1000,message = "Giá là số nguyên dương và lowbs hơn 1000")
    private int gia;
    @Column(name = "con_hang")
    private boolean conHang;
    @Column(name = "ngay_xuat_ban")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayXuatBan;
    @ManyToOne
    @JoinColumn(name = "nha_xuat_ban_id")
    private NhaXuatBan nhaXuatBan;

}
