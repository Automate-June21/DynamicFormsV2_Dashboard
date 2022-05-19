package com.automate.df.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.automate.df.dao.dashboard.DashBoardV3Dao;
import com.automate.df.dao.dashboard.DmsTargetParamAllEmployeeSchedularDao;
import com.automate.df.dao.dashboard.DmsTargetParamEmployeeSchedularDao;
import com.automate.df.entity.DmsTargetParamAllEmployeeSchedular;
import com.automate.df.entity.DmsTargetParamEmployeeSchedular;
import com.automate.df.entity.DmsTargetParamSchedular;
import com.automate.df.exception.DynamicFormsServiceException;
import com.automate.df.service.DashBoardServiceV3;
import com.google.common.base.Optional;
import com.google.gson.Gson;
@Service
public class DashBoardServiceImplV3  implements DashBoardServiceV3{
	@Autowired
	DashBoardV3Dao boardV3Dao;
	@Autowired
	DmsTargetParamEmployeeSchedularDao dmsTargetParamEmployeeSchedularDao;
	@Autowired
	DmsTargetParamAllEmployeeSchedularDao dmsTargetParamAllEmployeeSchedularDao;
	
	@Override
	public  String getTargetAchivementParams(String empId)
			throws DynamicFormsServiceException {
		Optional<DmsTargetParamSchedular> opt = boardV3Dao.findByEmpId(empId);
		String str = null;
		DmsTargetParamSchedular auto = null;
		if (opt.isPresent()) {
			auto = opt.get();
			str = new Gson().toJson(auto.getData());
			str = str.replace("\\", "");
			System.out.println("str " + str);
			auto.setData(str);
			// convertedObject = new Gson().fromJson(auto.getData(), JsonObject.class);
		} else {
			throw new DynamicFormsServiceException("Data Not found in sysem for given universalId",
					HttpStatus.BAD_REQUEST);
		}
		return str;	
	}
	
	@Override
	public  String getTargetParamsForEmp(String empId)
			throws DynamicFormsServiceException {
		Optional<DmsTargetParamEmployeeSchedular> opt = dmsTargetParamEmployeeSchedularDao.findByEmpId(empId);
		String str = null;
		DmsTargetParamEmployeeSchedular auto = null;
		if (opt.isPresent()) {
			auto = opt.get();
			str = new Gson().toJson(auto.getData());
			str = str.replace("\\", "");
			System.out.println("str " + str);
			auto.setData(str);
			// convertedObject = new Gson().fromJson(auto.getData(), JsonObject.class);
		} else {
			throw new DynamicFormsServiceException("Data Not found in sysem for given universalId",
					HttpStatus.BAD_REQUEST);
		}
		return str;	
	}
	@Override
	public String getTargetParamsForAllEmp(String empId)
			throws DynamicFormsServiceException {
		Optional<DmsTargetParamAllEmployeeSchedular> opt = dmsTargetParamAllEmployeeSchedularDao.findByEmpId(empId);
		String str = null;
		DmsTargetParamAllEmployeeSchedular auto = null;
		if (opt.isPresent()) {
			auto = opt.get();
			str = new Gson().toJson(auto.getData());
			str = str.replace("\\", "");
			System.out.println("str " + str);
			auto.setData(str);
			// convertedObject = new Gson().fromJson(auto.getData(), JsonObject.class);
		} else {
			throw new DynamicFormsServiceException("Data Not found in sysem for given universalId",
					HttpStatus.BAD_REQUEST);
		}
		return str;	
	}

}