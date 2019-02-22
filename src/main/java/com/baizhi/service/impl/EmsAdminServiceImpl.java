package com.baizhi.service.impl;

import com.baizhi.dao.EmsAdminDao;
import com.baizhi.entity.EmsAdmin;
import com.baizhi.service.EmsAdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmsAdminServiceImpl implements EmsAdminService {
	@Autowired
	private EmsAdminDao emsAdminDao;

	@Override
	public void delete(Integer id) {
		emsAdminDao.delete(id);
	}

	@Override
	public void add(EmsAdmin admin) {
		emsAdminDao.add(admin);
	}

	@Override
	public EmsAdmin selectByUserName(String username) {
		EmsAdmin emsAdmin = emsAdminDao.selectByUserName(username);
		return emsAdmin;
	}


	@Override
	public Map<String, Object> getAll(Integer page, Integer rows) {
		Page<Object> startPage = PageHelper.startPage(page, rows);
		List<EmsAdmin> emsAdmins = emsAdminDao.selectAll();
		long total = startPage.getTotal();
		Map<String, Object> map = new HashMap<>();
		map.put("rows", emsAdmins);
		map.put("total", total);
		return map;
	}


	@Override
	public long getEmsAdminRowCount() {
		return emsAdminDao.getEmsAdminRowCount();
	}

	@Override
	public List<EmsAdmin> selectEmsAdmin() {
		return emsAdminDao.selectEmsAdmin();
	}

	@Override
	public EmsAdmin selectEmsAdminByObj(EmsAdmin obj) {
		return emsAdminDao.selectEmsAdminByObj(obj);
	}

	@Override
	public EmsAdmin selectEmsAdminById(Integer id) {
		return emsAdminDao.selectEmsAdminById(id);
	}

	@Override
	public void insertEmsAdmin(EmsAdmin value) {
		emsAdminDao.insert(value);
	}

	@Override
	public int insertNonEmptyEmsAdmin(EmsAdmin value) {
		return emsAdminDao.insertNonEmptyEmsAdmin(value);
	}

	@Override
	public int deleteEmsAdminById(Integer id) {
		return emsAdminDao.deleteEmsAdminById(id);
	}

	@Override
	public int updateEmsAdminById(EmsAdmin enti) {
		return emsAdminDao.updateEmsAdminById(enti);
	}

	@Override
	public int updateNonEmptyEmsAdminById(EmsAdmin enti) {
		return emsAdminDao.updateNonEmptyEmsAdminById(enti);
	}

	public EmsAdminDao getEmsAdminDao() {
		return this.emsAdminDao;
	}

	public void setEmsAdminDao(EmsAdminDao emsAdminDao) {
		this.emsAdminDao = emsAdminDao;
	}

}