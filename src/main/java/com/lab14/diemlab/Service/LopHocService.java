package com.lab14.diemlab.Service;

import com.lab14.diemlab.Entity.LopHoc;
import com.lab14.diemlab.Repository.LopHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class LopHocService {
    @Autowired
    private LopHocRepository LopHocRepository;

    public List<LopHoc> findAll(){
        return LopHocRepository.findAll();
    }
}
