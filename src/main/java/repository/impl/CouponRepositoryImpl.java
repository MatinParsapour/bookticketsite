package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Admin;
import domain.Coupon;
import domain.Customer;
import repository.CouponRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.LocalDate;

public class CouponRepositoryImpl extends BaseRepositoryImpl<Coupon,Long> implements CouponRepository {
    public CouponRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Coupon> getEntity() {
        return Coupon.class;
    }

    @Override
    public Coupon findCouponByCouponCode(String couponCode) {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM Coupon c " +
                    "WHERE c.code = :code " +
                    "AND c.beginDate < :now " +
                    "AND c.finishDate > :now2 ",Coupon.class).
                    setParameter("code",couponCode).
                    setParameter("now", LocalDate.now()).
                    setParameter("now2",LocalDate.now()).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
