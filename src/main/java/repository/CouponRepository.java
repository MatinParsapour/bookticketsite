package repository;

import base.repository.BaseRepository;
import base.repository.BaseRepositoryImpl;
import domain.Coupon;

public interface CouponRepository extends BaseRepository<Coupon,Long> {
    Coupon findCouponByCouponCode(String couponCode);
}
