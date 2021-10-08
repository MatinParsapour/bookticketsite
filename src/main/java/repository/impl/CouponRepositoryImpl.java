package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Admin;
import domain.Coupon;
import repository.CouponRepository;

import javax.persistence.EntityManager;

public class CouponRepositoryImpl extends BaseRepositoryImpl<Coupon,Long> implements CouponRepository {
    public CouponRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Coupon> getEntity() {
        return Coupon.class;
    }
}
