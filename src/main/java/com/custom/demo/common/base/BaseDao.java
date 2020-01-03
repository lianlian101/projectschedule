/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.custom.demo.common.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <ul>
 * <li>继承自己的MyMapper</li>
 * <li>接口方法说明：</li>
 * <li>等号的CRUD:</li>
 * <li> List<T> select(T record); 根据实体中的属性值进行查询，查询条件使用等号;</li>
 * <li> T selectByPrimaryKey(Object key);
 * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号;</li>
 * <li> List<T> selectAll(); 查询全部结果，select(null)方法能达到同样的效果;</li>
 * <li> T selectOne(T record); 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号;</li>
 * <li> int selectCount(T record); 根据实体中的属性查询总数，查询条件使用等号;</li>
 * <li> int insert(T record); 保存一个实体，null的属性也会保存，不会使用数据库默认值;</li>
 * <li> int insertSelective(T record); 保存一个实体，null的属性不会保存，会使用数据库默认值;</li>
 * <li> int updateByPrimaryKey(T record); 根据主键更新实体全部字段，null值会被更新;</li>
 * <li> int updateByPrimaryKeySelective(T record); 根据主键更新属性不为null的值;</li>
 * <li> int delete(T record); 根据实体属性作为条件进行删除，查询条件使用等号;</li>
 * <li> int deleteByPrimaryKey(Object key); 根据主键字段进行删除，方法参数必须包含完整的主键属性;</li>
 * <li>条件的CRUD:</li>
 * <li> List<T> selectByCondition(Object condition); 根据Condition条件进行查询;</li>
 * <li> int selectCountByCondition(Object condition); 根据Condition条件进行查询总数;</li>
 * <li> int updateByCondition(@Param("record") T record, @Param("example")
 * Object condition); 根据Condition条件更新实体record包含的全部属性，null值会被更新;</li>
 * <li> int updateByConditionSelective(@Param("record") T
 * record, @Param("example") Object condition);
 * 根据Condition条件更新实体record包含的不是null的属性值;</li>
 * <li> int deleteByCondition(Object condition); 根据Condition条件删除数据;</li>
 * <li>---------------------</li>
 * 
 * @author han
 * @since 2015-09-06 21:53
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {
	// TODO
	// FIXME 特别注意，该接口不能被扫描到，否则会出错
}
