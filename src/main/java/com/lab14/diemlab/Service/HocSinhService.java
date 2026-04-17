package com.lab14.diemlab.Service;

import com.lab14.diemlab.Entity.HocSinh;
import com.lab14.diemlab.Repository.HocSinhRepository;
import com.lab14.diemlab.Repository.LopHocRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocSinhService {
    @Autowired
    private HocSinhRepository hocSinhRepository;

    public Page<HocSinh> findAll (int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<HocSinh> pageHocSinh = hocSinhRepository.findAll(pageable);
          return pageHocSinh;
    }
    public HocSinh findById(Integer id){
        return hocSinhRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hoc sinh not found"));
    }
    public void save(HocSinh hocSinh){
        hocSinhRepository.save(hocSinh);
    }
    public long count(){
        return hocSinhRepository.count();
    }
}
