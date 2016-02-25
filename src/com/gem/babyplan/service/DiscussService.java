package com.gem.babyplan.service;

import java.util.List;

import com.gem.babyplan.dao.DiscussDao;
import com.gem.babyplan.entity.Discuss;

public class DiscussService {
	private DiscussDao dao = new DiscussDao();
	
	// 插入
	public void save(Discuss discuss) {
		dao.save(discuss);
	}
	
	// 删除,批量删除
	public void delete(int discussId , int discussSuperId) {
		dao.delete(discussId, discussSuperId);
	}
	
	// 查询所有评论
	public List<Discuss> selectAll() {
		return dao.selectAll();
	}
	
}
