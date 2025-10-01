package com.register.userregistration.DAO;

import com.register.userregistration.model.Transaction;
import com.register.userregistration.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionDAO {

    @PersistenceContext
    private EntityManager entityManager;



    public List<Transaction> findTransactionsByUser(User user, int page, int size, LocalDate filterDate, String searchText) {
        StringBuilder queryStr = new StringBuilder("SELECT t FROM Transaction t WHERE t.userId = :userId");
        if (filterDate != null) {
            queryStr.append(" AND t.transactionDate = :filterDate");
        }
        if (searchText != null && !searchText.isEmpty()) {
            queryStr.append(" AND (CAST(t.amount AS string) LIKE :searchText OR t.narration LIKE :searchText)");
        }
        queryStr.append(" ORDER BY t.transactionDate DESC");

        TypedQuery<Transaction> query = entityManager.createQuery(queryStr.toString(), Transaction.class);
        query.setParameter("userId", user.getDeviceId());
        if (filterDate != null) {
            query.setParameter("filterDate", filterDate);
        }
        if (searchText != null && !searchText.isEmpty()) {
            query.setParameter("searchText", "%" + searchText + "%");
        }
        query.setFirstResult(page * size);
        query.setMaxResults(size);

        return query.getResultList();
    }

    public Transaction findById(Long userId) {
        return entityManager.find(Transaction.class, userId);
    }
}
