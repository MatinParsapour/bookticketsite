package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Ticket;
import repository.TicketRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket, Long> implements TicketRepository {

    public TicketRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntity() {
        return Ticket.class;
    }

    @Override
    public List<Ticket> findAllTicketsByOriginAndDestination(String origin, String destination) {
        try {
            return entityManager.createQuery("SELECT t " +
                    "FROM Ticket t " +
                    "WHERE t.origin = :origin " +
                    "AND t.destination = :destination ", Ticket.class).
                    setParameter("origin", origin).
                    setParameter("destination", destination).
                    getResultList();
        } catch (NoResultException exception) {
            return null;
        }
    }

    @Override
    public List<Ticket> findTicketsByOrder(String field, String position, String origin, String destination) {
        List<Ticket> tickets = new ArrayList<>();
        if (position.equals("ascending")) {
            if (field.equals("price")) {
                tickets = entityManager.createQuery("SELECT t " +
                        "FROM Ticket t " +
                        "WHERE t.origin = :origin " +
                        "AND t.destination = :destination " +
                        "AND t.departureDate > :now " +
                        "AND t.numberOfPassengers > 0 " +
                        "ORDER BY t.amount ASC ",Ticket.class).setParameter("origin", origin).
                        setParameter("destination", destination).
                        setParameter("now",LocalDateTime.now()).
                        getResultList();
            }
            if (field.equals("companyName")) {
                tickets = entityManager.createQuery("SELECT t " +
                        "FROM Ticket t " +
                        "JOIN t.company c " +
                        "WHERE t.origin = :origin " +
                        "AND t.destination = :destination " +
                        "AND t.departureDate > :now " +
                        "AND t.numberOfPassengers > 0 " +
                        "ORDER BY c.companyName ASC ",Ticket.class).setParameter("origin", origin).
                        setParameter("destination", destination).
                        setParameter("now",LocalDateTime.now()).
                        getResultList();
            }
            if (field.equals("origin")) {
                tickets = entityManager.createQuery("SELECT t " +
                        "FROM Ticket t " +
                        "WHERE t.origin = :origin " +
                        "AND t.destination = :destination " +
                        "AND t.departureDate > :now " +
                        "AND t.numberOfPassengers > 0 " +
                        "ORDER BY t.origin ASC ",Ticket.class).setParameter("origin", origin).
                        setParameter("destination", destination).
                        setParameter("now",LocalDateTime.now()).
                        getResultList();
            }
            if (field.equals("destination")) {
                tickets = entityManager.createQuery("SELECT t " +
                        "FROM Ticket t " +
                        "WHERE t.origin = :origin " +
                        "AND t.destination = :destination " +
                        "AND t.departureDate > :now " +
                        "AND t.numberOfPassengers > 0 " +
                        "ORDER BY t.destination ASC ",Ticket.class).setParameter("origin", origin).
                        setParameter("destination", destination).
                        setParameter("now",LocalDateTime.now()).
                        getResultList();
            }
        }
        if (position.equals("descending")) {
            if (field.equals("price")) {
                tickets = entityManager.createQuery("SELECT t " +
                        "FROM Ticket t " +
                        "WHERE t.origin = :origin " +
                        "AND t.destination = :destination " +
                        "AND t.departureDate > :now " +
                        "AND t.numberOfPassengers > 0 " +
                        "ORDER BY t.amount DESC ",Ticket.class).setParameter("origin", origin).
                        setParameter("destination", destination).
                        setParameter("now",LocalDateTime.now()).
                        getResultList();
            }
            if (field.equals("companyName")) {
                tickets = entityManager.createQuery("SELECT t " +
                        "FROM Ticket t " +
                        "JOIN t.company c " +
                        "WHERE t.origin = :origin " +
                        "AND t.destination = :destination " +
                        "AND t.departureDate > :now " +
                        "AND t.numberOfPassengers > 0 " +
                        "ORDER BY c.companyName DESC ",Ticket.class).setParameter("origin", origin).
                        setParameter("destination", destination).
                        setParameter("now",LocalDateTime.now()).
                        getResultList();
            }
            if (field.equals("origin")) {
                tickets = entityManager.createQuery("SELECT t " +
                        "FROM Ticket t " +
                        "WHERE t.origin = :origin " +
                        "AND t.destination = :destination " +
                        "AND t.departureDate > :now " +
                        "AND t.numberOfPassengers > 0 " +
                        "ORDER BY t.origin DESC ",Ticket.class).setParameter("origin", origin).
                        setParameter("destination", destination).
                        setParameter("now",LocalDateTime.now()).
                        getResultList();
            }
            if (field.equals("destination")) {
                tickets = entityManager.createQuery("SELECT t " +
                        "FROM Ticket t " +
                        "WHERE t.origin = :origin " +
                        "AND t.destination = :destination " +
                        "AND t.departureDate > :now " +
                        "AND t.numberOfPassengers > 0 " +
                        "ORDER BY t.destination DESC ",Ticket.class).setParameter("origin", origin).
                        setParameter("destination", destination).
                        setParameter("now",LocalDateTime.now()).
                        getResultList();
            }
        }
        return tickets;
    }

    @Override
    public Ticket findTicketByIdForCustomer(long id,String origin, String destination) {
        try{
            return entityManager.createQuery("SELECT t " +
                    "FROM Ticket t " +
                    "WHERE t.id = :id " +
                    "AND t.origin = :origin " +
                    "AND t.destination = :destination",Ticket.class).
                    setParameter("id",id).
                    setParameter("origin",origin).
                    setParameter("destination",destination).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public List<Ticket> oneHourRemainTickets() {
        try {
            return entityManager.createQuery("SELECT t " +
                    "FROM Ticket t " +
                    "WHERE t.departureDate <= :oneHourLater " +
                    "AND t.departureDate >= :now " +
                    "AND t.isPriceChanged = false ", Ticket.class).
                    setParameter("oneHourLater", LocalDateTime.now().plusHours(1)).
                    setParameter("now",LocalDateTime.now()).
                    getResultList();
        } catch (NoResultException exception) {
            return null;
        }
    }
}
