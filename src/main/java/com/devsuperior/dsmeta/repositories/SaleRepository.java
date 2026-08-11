package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = """
        SELECT new com.devsuperior.dsmeta.dto.SaleMinDTO(obj.id, obj.amount, obj.date, obj.seller.name) 
        FROM Sale AS obj 
        WHERE obj.date BETWEEN :minDate AND :maxDate AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :sellerName, '%'))
""",
    countQuery = """
            SELECT COUNT(obj) FROM Sale AS obj WHERE obj.date BETWEEN :minDate AND :maxDate AND UPPER(obj.seller.name) 
            LIKE UPPER(CONCAT('%', :sellerName, '%'))
            """
    )
    Page<SaleMinDTO> searchReport(LocalDate minDate, LocalDate maxDate, String sellerName, Pageable pageable);

}
