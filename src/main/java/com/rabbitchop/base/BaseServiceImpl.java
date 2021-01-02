package com.rabbitchop.base;

import com.rabbitchop.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * @author derrick
 */
public abstract class BaseServiceImpl<T extends BaseEntity, R extends BaseRepository<T>> implements BaseService<T> {
    @Autowired
    public R repository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(T model) {
       return repository.save(model);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(List<T> models) {
        return repository.save(models);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(T model) {
        return repository.update(model);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveOrUpdate(T model) {
        return repository.saveOrUpdate(model);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveSelective(T model) {
        return repository.saveSelective(model);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSelective(T model) {
        return repository.updateSelective(model);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return repository.queryAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> getByPrimaryKey(long id) {
        return repository.queryByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public int selectCountByExample(Example example) {
        return repository.selectCountByExample(example);
    }

    @Override
    @Transactional(readOnly = true)
    public T selectOneByExample(Example example) {
        return repository.selectOneByExample(example);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> selectByExample(Example example) {
        return repository.selectByExample(example);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getModelByIds(String ids) {
        return repository.queryByIds(ids);
    }
}
