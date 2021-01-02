package com.rabbitchop.repository;

import com.rabbitchop.base.BaseEntity;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * @author derrick
 * if repository method must contains merchantId as query condition, please user call super method
 */
public interface BaseRepository<T extends BaseEntity> {
    /**
     * save
     *
     * @param model
     * @return int
     */
    int save(T model);

    /**
     * update
     *
     * @param model
     * @return int
     */
    int update(T model);

    /**
     * saveOrUpdate
     *
     * @param model
     * @return int
     */
    int saveOrUpdate(T model);

    /**
     * save
     *
     * @param models
     * @return int
     */
    int save(List<T> models);

    /**
     * saveSelective
     *
     * @param model
     * @return int
     */
    int saveSelective(T model);

    /**
     * updateSelective
     *
     * @param model
     * @return int
     */
    int updateSelective(T model);

    /**
     * queryByPrimaryKey
     *
     * @param id
     * @return int
     */
    Optional<T> queryByPrimaryKey(long id);

    /**
     * queryAll
     *
     * @return list
     */
    List<T> queryAll();

    /**
     * selectCountByExample
     *
     * @param example
     * @return int
     */
    int selectCountByExample(Example example);

    /**
     * selectOneByExample
     *
     * @param example
     * @return
     */
    T selectOneByExample(Example example);

    /**
     * selectByExample
     *
     * @param example
     * @return list
     */
    List<T> selectByExample(Example example);

    /**
     * queryByIds
     *
     * @param ids
     * @return list
     */
    List<T> queryByIds(String ids);
}
