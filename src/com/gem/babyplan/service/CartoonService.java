package com.gem.babyplan.service;

import java.util.List;

import com.gem.babyplan.dao.CartoonDao;
import com.gem.babyplan.entity.Cartoon;

public class CartoonService {
	private CartoonDao dao = new CartoonDao();
	
	// 插入
	public void save(Cartoon cartoon) {
		dao.save(cartoon);
	}
	
	// 删除,批量删除
	public void delete(int[] cartoonId) {
		dao.delete(cartoonId);
	}
	
	// 修改
	public void update(Cartoon cartoon) {
		dao.update(cartoon);
	}
	
	// 查询所有动画片
	public List<Cartoon> selectAll() {
		return dao.selectAll();
	}
	
	// 动画片名模糊查询
	public List<Cartoon> getCartoonByCartoonName(String cartoonName) {
		return dao.getCartoonByCartoonName(cartoonName);
	}
	
	// 分页查询
	public List<Cartoon> getPagedCartoon(int curPage, int pageSize) {
		return dao.getPagedCartoon(curPage, pageSize);
	}
	
	// 获得所有动画片的个数
	public int getCount() {
		return dao.getCount();
	}
}
