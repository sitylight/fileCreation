package com.rabbitchop.repository.impl;

import com.rabbitchop.mapper.MemberCouponMapper;
import com.rabbitchop.model.entity.intermediate.MemberCoupon;
import com.rabbitchop.repository.MemberCouponRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "derrick"
 */
@Repository
public class MemberCouponRepositoryImpl extends BaseRepositoryImpl<MemberCoupon, MemberCouponMapper> implements MemberCouponRepository {
}
