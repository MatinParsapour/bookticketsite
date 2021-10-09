package service;

import base.service.BaseService;
import domain.Coupon;

public interface CouponService extends BaseService<Coupon,Long> {
    Coupon getCoupon(String couponCode);
}
