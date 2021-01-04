package com.rabbitchop.repository.impl;

import com.rabbitchop.mapper.MemberVoucherMapper;
import com.rabbitchop.model.entity.intermediate.MemberVoucher;
import com.rabbitchop.repository.MemberVoucherRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "derrick"
 */
@Repository
public class MemberVoucherRepositoryImpl extends BaseRepositoryImpl<MemberVoucher, MemberVoucherMapper> implements MemberVoucherRepository {
}
