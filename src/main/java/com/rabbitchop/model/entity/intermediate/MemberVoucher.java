package com.rabbitchop.model.entity.intermediate;

import com.rabbitchop.base.BaseMerchantEntity;
import java.io.Serializable;
import javax.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* Created by Mybatis Generator on 2021/01/04
*/
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberVoucher extends BaseMerchantEntity implements Serializable {
    @Column
    private Long memberId;

    @Column
    private Long voucherId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberId=").append(memberId);
        sb.append(", voucherId=").append(voucherId);
        sb.append("]");
        return sb.toString();
    }
}