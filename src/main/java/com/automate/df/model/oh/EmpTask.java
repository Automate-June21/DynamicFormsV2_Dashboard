package com.automate.df.model.oh;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpTask {
	
	Integer taskCnt;
	String taskName;
	List<MyTask> myTaskList;

}
