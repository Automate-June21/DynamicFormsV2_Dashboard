package com.automate.df.dao.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.automate.df.entity.DmsTargetParamEmployeeSchedular;
@Repository
public interface DmsTargetParamEmployeeSchedularDao extends CrudRepository<DmsTargetParamEmployeeSchedular, Integer> {
	  @Query(value = "SELECT * FROM dms_target_param_employee_schedular WHERE emp_id=?1", nativeQuery = true)
			List<DmsTargetParamEmployeeSchedular> findByEmpId(String empId);
}
