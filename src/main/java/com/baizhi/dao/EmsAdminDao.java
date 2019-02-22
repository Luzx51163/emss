package com.baizhi.dao;

import com.baizhi.entity.EmsAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmsAdminDao {

	void delete(@Param("id") Integer id);

	void add(@Param("admin") EmsAdmin admin);

	EmsAdmin selectByUserName(@Param("username") String username);

	List<EmsAdmin> selectAll();

	void insert(@Param("admin") EmsAdmin admin);

	/**
	 * 获得EmsAdmin数据的总行数
	 *
	 * @return
	 */
	long getEmsAdminRowCount();

	/**
	 * 获得EmsAdmin数据集合
	 *
	 * @return
	 */
	List<EmsAdmin> selectEmsAdmin();

	/**
	 * 获得一个EmsAdmin对象,以参数EmsAdmin对象中不为空的属性作为条件进行查询
	 *
	 * @param obj
	 * @return
	 */
	EmsAdmin selectEmsAdminByObj(EmsAdmin obj);

	/**
	 * 通过EmsAdmin的id获得EmsAdmin对象
	 *
	 * @param id
	 * @return
	 */
	EmsAdmin selectEmsAdminById(Integer id);

	/**
	 * 插入EmsAdmin到数据库,包括null值
	 *
	 * @param value
	 * @return
	 */
	int insertEmsAdmin(EmsAdmin value);

	/**
	 * 插入EmsAdmin中属性值不为null的数据到数据库
	 *
	 * @param value
	 * @return
	 */
	int insertNonEmptyEmsAdmin(EmsAdmin value);

	/**
	 * 通过EmsAdmin的id删除EmsAdmin
	 *
	 * @param id
	 * @return
	 */
	int deleteEmsAdminById(Integer id);

	/**
	 * 通过EmsAdmin的id更新EmsAdmin中的数据,包括null值
	 *
	 * @param enti
	 * @return
	 */
	int updateEmsAdminById(EmsAdmin enti);

	/**
	 * 通过EmsAdmin的id更新EmsAdmin中属性不为null的数据
	 *
	 * @param enti
	 * @return
	 */
	int updateNonEmptyEmsAdminById(EmsAdmin enti);
}