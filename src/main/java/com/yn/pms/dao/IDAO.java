package com.yn.pms.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
* 
* @Description: 
* @ClassName: IDAO.java
* @author: yn 
* @date: 2021年1月13日 下午2:32:09 
*/


public interface IDAO<K,V> {

	/**
	 * 增加数据的方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int daoCreate(V vo)throws Exception;
	
	/**
	 * 修改数据的方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int  daoUpdate(V vo)throws Exception;
	
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int daoRemoveById(K id) throws Exception;
	
	
	/**
	 * 根据主键集合批量删除
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public int daoRmoveBatch(Set<K> ids) throws Exception;
	
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public V daoFindById(K id) throws Exception;

	/**
	 * 实现模糊分页查询
	 * @param kw  模糊查询关键字
	 * @param start 开始记录数
	 * @param end  结束记录数
	 * @return
	 * @throws Exception
	 */
	public List<V> daoFindSplit(@Param("kw") String kw , @Param("start")Integer start , @Param("end")Integer end) throws Exception;
	
	
	/**
	 * 统计数据量
	 * @param kw
	 * @return
	 * @throws Exception
	 */
	public int daoCount(String kw) throws Exception;
	
}
