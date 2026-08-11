package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleMinDTO> searchReport(String minDate, String maxDate, String sellerName, Pageable pageable) {

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

		return repository.searchReport(min_Date, max_Date, sellerName, pageable);

	}
}
