package com.rabbitchop.repository.impl;

import com.rabbitchop.mapper.MemberCampaignMapper;
import com.rabbitchop.model.entity.intermediate.MemberCampaign;
import com.rabbitchop.repository.MemberCampaignRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "derrick"
 */
@Repository
public class MemberCampaignRepositoryImpl extends BaseRepositoryImpl<MemberCampaign, MemberCampaignMapper> implements MemberCampaignRepository {
}
