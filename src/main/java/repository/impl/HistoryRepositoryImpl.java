package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.History;
import domain.Ticket;
import repository.HistoryRepository;
import util.SecurityUser;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class HistoryRepositoryImpl extends BaseRepositoryImpl<History,Long> implements HistoryRepository {
    public HistoryRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<History> getEntity() {
        return History.class;
    }

    @Override
    public List<History> findCustomerTickets() {
        try{
            return entityManager.createQuery("SELECT h " +
                    "FROM History h " +
                    "JOIN h.customers c " +
                    "WHERE c.id = :id ",History.class).
                    setParameter("id", SecurityUser.getCustomer().getId()).
                    getResultList();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public History findCustomerTicket(Long id) {
        try{
            return entityManager.createQuery("SELECT h " +
                    "FROM History h " +
                    "JOIN h.tickets t " +
                    "JOIN h.customers c " +
                    "WHERE c.id = :customerId " +
                    "AND t.id = :ticketId " +
                    "AND h.isBooked = true " +
                    "AND h.isBought = false ",History.class).
                    setParameter("customerId",SecurityUser.getCustomer().getId()).
                    setParameter("ticketId",id).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public History findDoplicateHistory(Ticket ticket) {
        try{
            return entityManager.createQuery("SELECT h " +
                    "FROM History h " +
                    "JOIN h.customers c " +
                    "JOIN h.tickets t " +
                    "WHERE t.id = :ticketId " +
                    "AND c.id = :customerId ",History.class).
                    setParameter("ticketId",ticket.getId()).
                    setParameter("customerId",SecurityUser.getCustomer().getId()).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
