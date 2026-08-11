package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerMinDTO> searchSummary(String minDate, String maxDate) {

        LocalDate min_Date;
        LocalDate max_Date;

        if(maxDate == null || maxDate.isBlank()) {
            max_Date = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        } else {
            max_Date = LocalDate.parse(maxDate);
        }

        if(minDate == null || minDate.isBlank()) {
            min_Date = max_Date.minusYears(1L);
        } else {
            min_Date = LocalDate.parse(minDate);
        }

        return repository.searchSummary(min_Date, max_Date);

    }

}
