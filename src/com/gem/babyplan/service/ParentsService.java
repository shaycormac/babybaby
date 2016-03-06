
package com.gem.babyplan.service;

import java.util.ArrayList;
import java.util.List;

import com.gem.babyplan.dao.ParentDao;
import com.gem.babyplan.dao.StudentDao;
import com.gem.babyplan.entity.Parent;
import com.gem.babyplan.entity.Student;

/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年3月6日 下午2:52:58 
* @parameter   
* @return 
*/
/**
 * @author Administrator
 *
 */
public class ParentsService 
{
	//家长页面的增删改查
	ParentDao pDao = new ParentDao();
	StudentDao sDao = new StudentDao();
	//展示页面,由于需要宝宝的信息，需要把宝宝找出来，发送出去
	public List<Parent> getAllParents ()
	{
		List<Parent> list=pDao.getAllParent();
		List<Parent> list2 = new ArrayList<>();
		Student student=null;
		for (Parent parent : list)
		{
		  	student=sDao.getStudentByNumber(parent.getStudent().getStudentNumber());
		  	parent.setStudent(student);
		  	list2.add(parent);
		}
		return list2;
	}

}
