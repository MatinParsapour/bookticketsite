package service.impl;

import base.service.BaseServiceImpl;
import domain.Coupon;
import repository.CouponRepository;
import service.CouponService;

public class CouponServiceImpl extends BaseServiceImpl<Coupon,Long, CouponRepository> implements CouponService {
    public CouponServiceImpl(CouponRepository repository) {
        super(repository);
    }
}
