package com.custom.demo.common.base;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class BaseService<T> {
    
    @Autowired
    private BaseDao<T> mapper;
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：保存一个实体，null的属性也会保存，不会使用数据库默认值
     * 
     * @param record
     * @return
     */
    public int insert(T record){
        return mapper.insert(record);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：保存一个实体，null的属性不会保存，会使用数据库默认值
     * 
     * @param record
     * @return
     */
    public int insertSelective(T record){
        return mapper.insertSelective(record);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：插入数据，限制为实体包含`id`属性并且必须为自增列，实体配置的主键策略无效
     * 
     * @param record
     * @return
     */
    public int insertUseGeneratedKeys(T record){
        return mapper.insertUseGeneratedKeys(record);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列，不会使用数据库默认值
     * 
     * @param recordList
     * @return
     */
    public int insertList(List<T> recordList){
        return mapper.insertList(recordList);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据实体中的属性值进行查询，查询条件使用等号
     * 
     * @param record
     * @return
     */
    public List<T> select(T record ){
        return mapper.select(record);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * 
     * @param record
     * @return
     */
    public T selectOne(T record){
        return mapper.selectOne(record);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * 
     * @param obj
     * @return
     */
    public T selectByPrimaryKey(Object obj){
        return mapper.selectByPrimaryKey(obj);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：查询全部结果
     * 
     * @return
     */
    public List<T> selectAll(){
        return mapper.selectAll();
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据实体中的属性查询总数，查询条件使用等号
     * 
     * @param record
     * @return
     */
    public int selectCount(T record){
        return mapper.selectCount(record);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据Example条件进行查询
     * 
     * @param example
     * @return
     */
    public List<T> selectByExample(Object example){
        return mapper.selectByExample(example);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据Example条件进行查询总数
     * 
     * @param example
     * @return
     */
    public int selectCountByExample(Object example){
        return mapper.selectCountByExample(example);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据实体属性和RowBounds进行分页查询
     * 
     * @param record
     * @param rowBounds
     * @return
     */
    public List<T> selectByRowBounds(T record, RowBounds rowBounds){
        return mapper.selectByRowBounds(record, rowBounds);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据example条件和RowBounds进行分页查询
     * 
     * @param example
     * @param rowBounds
     * @return
     */
    public Object selectByExampleAndRowBounds(Object example, RowBounds rowBounds){
        return mapper.selectByExampleAndRowBounds(example, rowBounds);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据主键更新实体全部字段，null值会被更新
     * 
     * @param record
     * @return
     */
    public int updateByPrimaryKey(T record){
        return mapper.updateByPrimaryKey(record);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据主键更新属性不为null的值
     * 
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(T record){
        return mapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据Example条件更新实体`record`包含的全部属性，null值会被更新
     * 
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(T record, Object example){
        return mapper.updateByExample(record, example);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据Example条件更新实体`record`包含的不是null的属性值
     * 
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(T record, Object example){
        return mapper.updateByExampleSelective(record, example);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据实体属性作为条件进行删除，查询条件使用等号
     * 
     * @param record
     * @return
     */
    public int delete(T record){
        return mapper.delete(record);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据主键字段进行删除，方法参数必须包含完整的主键属性
     * 
     * @param key
     * @return
     */
    public int deleteByPrimaryKey(Object key){
        return mapper.deleteByPrimaryKey(key);
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据Example条件删除数据
     * 
     * @param example
     * @return
     */
    public int deleteByExample(Object example){
        return mapper.deleteByExample(example);
    }

    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据实体中的属性值进行分页查询，查询条件使用等号
     * 
     * @param record 类
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @return
     */
    public PageInfo<T> pageSelect(T record, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(mapper.select(record));
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：分页查询全部结果
     * 
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @return
     */
    public PageInfo<T> pageSelectAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(mapper.selectAll());
    }
    
    /**
     * 日期：2019年12月11日
     * 作者：zhb
     * 说明：根据Example条件进行分页查询
     * 
     * @param example 条件
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @return
     */
    public PageInfo<T> pageSelectByExample(Object example, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(mapper.selectByExample(example));
    }
    
    
}
