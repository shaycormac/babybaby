package com.gem.babyplan.service;

import java.util.ArrayList;
import java.util.List;

import com.gem.babyplan.dao.NoticeDao;
import com.gem.babyplan.entity.Classes;
import com.gem.babyplan.entity.Notice;

public class NoticeService {
	private NoticeDao dao = new NoticeDao();
	
	// 插入
	public void save(Notice notice) {
		dao.save(notice);
	}
	
	// 删除,批量删除
	public void delete(int[] noticeId) {
		dao.delete(noticeId);
	}
	
	// 修改
	public void update(Notice notice) {
		dao.update(notice);
	}
	
	// 查询所有通知
	public List<Notice> selectAll() {
		List<Notice> noticeList1 = dao.selectAll();
		List<Notice> noticeList2 = new ArrayList<Notice>();
		for (Notice notice : noticeList1) {
			Classes classes = notice.getClasses();
			String classNumber = classes.getClassNumber();
			ClassesService service = new ClassesService();
			Classes classes1 = service.getClassesByClassNumber(classNumber);
			notice.setClasses(classes1);
			noticeList2.add(notice);
		}
		return noticeList2;
	}
	
	// 分页查询
	public List<Notice> getPagedNotice(int curPage, int pageSize) {
		return dao.getPagedNotice(curPage, pageSize);
	}
	
	// 获得所有班级通知的个数
	public int getCount() {
		return dao.getCount();
	}
	
	// 根据主键获得班级通知
	public Notice getNoticeByNoticeId(int noticeId){
		return dao.getNoticeByNoticeId(noticeId);
	}
	
	// 根据班级号获得班级通知
	public List<Notice> getNoticeByClassNumber(String classNumber) {
		return dao.getNoticeByClassNumber(classNumber);
	}
}
