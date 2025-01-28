package com.bcnc.alejandro.infraestructura.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bcnc.alejandro.infraestructura.entity.PriceEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PriceRepositoryImpl implements PriceRepository{

	@PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Optional<PriceEntity> findPriceByProductIdBrandIandApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate) {
        String jpql = "SELECT p FROM PriceEntity p " +
                      "WHERE p.productId = :productId " +
                      "AND p.brandId = :brandId " +
                      "AND :applicationDate BETWEEN p.startDate AND p.endDate " +
                      "ORDER BY p.priority DESC";

        TypedQuery<PriceEntity> query = entityManager.createQuery(jpql, PriceEntity.class);
        query.setParameter("productId", productId);
        query.setParameter("brandId", brandId);
        query.setParameter("applicationDate", applicationDate);
        query.setMaxResults(1);

        List<PriceEntity> results = query.getResultList();
        return results.stream().findFirst();
    }

}
