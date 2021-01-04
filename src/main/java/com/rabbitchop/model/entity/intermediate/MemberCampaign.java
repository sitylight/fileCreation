package com.rabbitchop.model.entity.intermediate;

import com.rabbitchop.base.BaseMerchantEntity;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* Created by Mybatis Generator on 2021/01/04
*/
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberCampaign extends BaseMerchantEntity implements Serializable {
    @Column
    private Long memberId;

    @Column
    private Long campaignId;

    @Column
    private Integer chopBalance;

    @Column
    private Long version;

    @Column
    private String remark;

    @Column
    private Object tiers;

    @Column
    private Short memberLevel;

    @Column
    private Object chopDetail;

    @Column
    private LocalDate expiredDate;

    @Column
    private Object otherInfo;

    @Column
    private String promotionCode;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberId=").append(memberId);
        sb.append(", campaignId=").append(campaignId);
        sb.append(", chopBalance=").append(chopBalance);
        sb.append(", version=").append(version);
        sb.append(", remark=").append(remark);
        sb.append(", tiers=").append(tiers);
        sb.append(", memberLevel=").append(memberLevel);
        sb.append(", chopDetail=").append(chopDetail);
        sb.append(", expiredDate=").append(expiredDate);
        sb.append(", otherInfo=").append(otherInfo);
        sb.append(", promotionCode=").append(promotionCode);
        sb.append("]");
        return sb.toString();
    }
}