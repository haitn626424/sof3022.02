package com.lab14.diemlab.Service;

import com.lab14.diemlab.Entity.Sach;
import com.lab14.diemlab.Repository.SachRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SachService {
    private final SachRepository sachRepository;

    public List<Sach> findAllSachASC() {
        return sachRepository.findAllSachASC();
    }

    public List<Sach> findAll(){
        return sachRepository.findAll();
    }

    public  Sach findById(Integer id) {
        return sachRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sach not found"));

    }
    public void addSachOrUpdate(Sach sach) {
        sachRepository.save(sach);
    }
    public void deleteSachById(Integer id) {
        if (sachRepository.findById(id).isPresent()) {
            sachRepository.deleteById(id);
        }
    }
}
