package com.rabbitchop.base;

import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * @author
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * save
     * @param model
     * @return
     */
    int save(T model);

    /**
     * update
     * @param model
     * @return
     */
    int update(T model);

    /**
     * saveOrUpdate
     * @param model
     * @return
     */
    int saveOrUpdate(T model);

    /**
     * save
     * @param models
     * @return
     */
    int save(List<T> models);

    /**
     * saveSelective
     * @param model
     * @return
     */
    int saveSelective(T model);

    /**
     * updateSelective
     * @param model
     * @return
     */
    int updateSelective(T model);

    /**
     * queryByPrimaryKey
     * @param id
     * @return
     */
    Optional<T> getByPrimaryKey(long id);

    /**
     * queryAll
     * @return
     */
    List<T> getAll();

    /**
     * selectCountByExample
     * @param example
     * @return
     */
    int selectCountByExample(Example example);

    /**
     * selectOneByExample
     * @param example
     * @return
     */
    T selectOneByExample(Example example);

    /**
     * selectByExample
     * @param example
     * @return
     */
    List<T> selectByExample(Example example);

    /**
     * queryByIds
     * @param ids
     * @return
     */
    List<T> getModelByIds(String ids);

}

