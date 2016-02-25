package com.gem.babyplan.dao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.gem.babyplan.dao.DiscussDao;
import com.gem.babyplan.entity.Discuss;
import com.gem.babyplan.entity.Dynamic;
import com.gem.babyplan.entity.Parent;

public class DiscussDaoTest {
	private DiscussDao dao = new DiscussDao();

	// 插入
	@Test
	public void saveTest() throws ParseException {
		Discuss discuss = new Discuss();

		Dynamic dynamic = new Dynamic();
		dynamic.setDynamicId(1);
		Parent parent = new Parent();
		parent.setParentId(1);
		Discuss discuss1 = new Discuss();
		discuss1.setDiscussId(0);

		discuss.setDiscussId(1);
		discuss.setDynamic(dynamic);
		discuss.setParent(parent);
		discuss.setDiscuss(discuss1);

		discuss.setDiscussText("评论内容1");
		discuss.setIsLast(1);

		dao.save(discuss);
	}

	// 刪除，批量刪除
	@Test
	public void deleteTest() {
		int discussId = 1;
		int discussSuperId = 1;
		dao.delete(discussId, discussSuperId);
	}
	
	// 查询所有评论
	@Test
	public void selectAllTest() {
		List<Discuss> list = dao.selectAll();
		for (Discuss discuss : list) {
			System.out.println(discuss + "," + discuss.getDynamic().getDynamicId() + ","
					+ discuss.getParent().getParentId() + "," + discuss.getDiscuss().getDiscussId());
		}
	}
	
}
