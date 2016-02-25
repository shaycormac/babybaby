package com.gem.babyplan.service;

import com.gem.babyplan.dao.TeacherDao;
import com.gem.babyplan.entity.Teacher;

public class TeacherService {
	private TeacherDao dao = new TeacherDao();
	
	public Teacher getTeacherByTeacherNum (String num){
		return dao.getTeacherByTeacherNum(num);
	}
	
}
