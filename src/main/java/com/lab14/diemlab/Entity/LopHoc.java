package com.lab14.diemlab.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "lop_hoc")
@Entity
public class LopHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ten_lop")
    private String tenLop;
    @Column(name = "khoi")
    private int khoi;
    @Column(name = "si_so")
    private int siSo;
    @OneToMany(mappedBy = "lopHoc",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<HocSinh> hocSinhs = new HashSet<>();


}
