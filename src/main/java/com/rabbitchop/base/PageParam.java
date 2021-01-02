package com.rabbitchop.base;

import lombok.Data;

/**
 * @author
 */
@Data
public class PageParam {
    private int pageNo;
    private int pageSize;
    private String sortField;
    private String sortOrder;
}
