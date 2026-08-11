package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query(value = """
        SELECT new com.devsuperior.dsmeta.dto.SellerMinDTO(obj.seller.name, SUM(obj.amount)) 
        FROM Sale AS obj 
        WHERE obj.date BETWEEN :minDate AND :maxDate 
        GROUP BY obj.seller.name
""")
    List<SellerMinDTO> searchSummary(LocalDate minDate, LocalDate maxDate);

}
