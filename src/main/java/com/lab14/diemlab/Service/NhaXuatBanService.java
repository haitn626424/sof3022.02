package com.lab14.diemlab.Service;

import com.lab14.diemlab.Entity.NhaXuatBan;
import com.lab14.diemlab.Repository.NhaXuatBanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhaXuatBanService {

    private final NhaXuatBanRepository nhaXuatBanRepository;

    public List<NhaXuatBan> findAll() {
        return nhaXuatBanRepository.findAll();
    }
}
