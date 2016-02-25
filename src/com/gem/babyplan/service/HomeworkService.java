package com.gem.babyplan.service;

import java.util.List;

import com.gem.babyplan.dao.HomeworkDao;
import com.gem.babyplan.entity.Homework;

public class HomeworkService {
	private HomeworkDao dao = new HomeworkDao();

	// 插入
	public void save(Homework homework) {
		dao.save(homework);
	}

	// 删除,批量删除
	public void delete(int[] hwId) {
		dao.delete(hwId);
	}

	// 修改
	public void update(Homework homework) {
		dao.update(homework);
	}

	// 查询所有班级
	public List<Homework> selectAll() {
		return dao.selectAll();
	}

	// 分页查询
	public List<Homework> getPagedHomework(int curPage, int pageSize) {
		return dao.getPagedHomework(curPage, pageSize);
	}

	// 得到所有作业记录的个数
	public int getCount() {
		return dao.getCount();
	}
}
