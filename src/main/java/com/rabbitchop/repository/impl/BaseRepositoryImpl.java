package com.rabbitchop.repository.impl;

import com.rabbitchop.base.BaseEntity;
import com.rabbitchop.base.BaseMerchantEntity;
import com.rabbitchop.base.CustomMapper;
import com.rabbitchop.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 * @author derrick
 */
public abstract class BaseRepositoryImpl<T extends BaseEntity, C extends CustomMapper<T>> implements BaseRepository<T> {
    @Autowired
    protected C customMapper;

    @Override
    public int save(T model) {
        if (customMapper.existsWithPrimaryKey(model)) {
            return customMapper.updateByPrimaryKey(model);
        } else {
            setMerchantId(model);
            return customMapper.insert(model);
        }
    }

    @Override
    public int update(T model) {
        return customMapper.updateByPrimaryKey(model);
    }

    @Override
    public int saveOrUpdate(T model) {
        if (customMapper.existsWithPrimaryKey(model)) {
            return customMapper.updateByPrimaryKey(model);
        } else {
            setMerchantId(model);
            return customMapper.insert(model);
        }
    }

    @Override
    public int save(List<T> models) {
        models.forEach(this::setMerchantId);
        return customMapper.insertList(models);
    }

    @Override
    public int saveSelective(T model) {
        setMerchantId(model);
        return customMapper.insertSelective(model);
    }

    @Override
    public int updateSelective(T model) {
        return customMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public List<T> queryAll() {
        return customMapper.selectAll();
    }

    @Override
    public Optional<T> queryByPrimaryKey(long id) {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<?> genericClass = (Class<?>) type.getActualTypeArguments()[0];
        Example example = new Example(genericClass);
        return Optional.ofNullable(customMapper.selectOneByExample(example));
    }

    @Override
    public int selectCountByExample(Example example) {
        return customMapper.selectCountByExample(example);
    }

    @Override
    public T selectOneByExample(Example example) {
        return customMapper.selectOneByExample(example);
    }

    @Override
    public List<T> selectByExample(Example example) {
        return customMapper.selectByExample(example);
    }

    @Override
    public List<T> queryByIds(String ids) {
        return customMapper.selectByIds(ids);
    }

    protected void setMerchantId(T model) {
        if (model instanceof BaseMerchantEntity && null == ((BaseMerchantEntity) model).getMerchantId()) {
        }
    }
}
