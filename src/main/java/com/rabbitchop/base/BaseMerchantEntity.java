package com.rabbitchop.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseMerchantEntity extends BaseEntity {

    static final long serialVersionUID = 9029361279862151621L;

    @Column
    Long merchantId;

}
