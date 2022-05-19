package com.example.firstspringboot.service;

import com.example.firstspringboot.model.Il;
import com.example.firstspringboot.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Component
@AllArgsConstructor
public class IlService {

    private final IlRepository ilRepository;

    public  void delete(String id) {
        ilRepository.deleteById(id);
    }

    public List<Il> getIller() {
        return (List<Il>) ilRepository.findAll();
    }

    public Il createIl(Il newIl) {
        newIl.setCreateDate(new Date());
        return ilRepository.save(newIl);
    }

    public Il getIlById(String id) {
       return ilRepository.findById(id)
                .orElseThrow(()->new RuntimeException("il bulunamadı"));
    }
}
