package com.rabbitchop.base;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author
 */
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8077885831615048035L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select id_generator()")
    private Long id;

}
