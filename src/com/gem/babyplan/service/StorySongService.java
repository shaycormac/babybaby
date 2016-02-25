package com.gem.babyplan.service;

import java.util.List;

import com.gem.babyplan.dao.StorySongDao;
import com.gem.babyplan.entity.StorySong;

/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年2月22日 下午9:35:10 
* @parameter   
* @return 
*/
public class StorySongService 
{
	StorySongDao ssDao = new StorySongDao();
	//添加一个记录
	public void addStorySong (StorySong ss)
	{
		//对类型进行判断,0是儿歌，1是故事
		if (ss.getSsType()==0)
		{
		ss.setSsThumbnail("/babyresource/songs/default_nail/erge.jpg");	
		ss.setSsURL("/babyresource/songs/"+ss.getSsURL());
		}else {
			ss.setSsThumbnail("/babyresource/storys/default_nail/story.jpg");	
			ss.setSsURL("/babyresource/storys/"+ss.getSsURL());
		}
		ssDao.addStorySong(ss);
		
	}
	
	//返回所有的对象list
	public  List<StorySong> getList ()
	{
		return ssDao.getAllStorySong();
		
		
		
	}

}
