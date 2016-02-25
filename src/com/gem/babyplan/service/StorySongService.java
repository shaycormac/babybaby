package com.gem.babyplan.service;

import java.io.File;
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
	//批量删除
	public void delBath (int ids[])
	{
		StorySong storySong=null;
		//删除之前，需要得到每一个对象进行判断
		for (int id : ids)
		{
			storySong=getStorySong(id);
			String path = storySong.getSsURL();
			//需要把前面的虚拟路径字符串去掉
			path=path.substring(13);
			//加上绝对路径的根目录，用来删除硬盘上的文件
			File file = new File("D:/BabyBaby"+path);
			System.out.println(file.exists());
			file.delete();
			System.out.println(file.exists());
		}
		ssDao.deleteStorySong(ids);
	
	}
	//返回某个对象
	public StorySong getStorySong (int id)
	{
		return ssDao.getStorySongById(id);
	}
	//更新某条记录
	public void updateSs (StorySong ss)
	{
		//首先根据传过来的对象的id，得到数据库中的对象，然后把参数传过来的值相应的附上，再调用系统的更新
		StorySong storySong = ssDao.getStorySongById(ss.getSsId());
		//将参数的值赋值给对象，传这个对象即可
		storySong.setSsBrief(ss.getSsBrief());
		storySong.setSsName(ss.getSsName());
		//其他字段不变，调用更新方法
		ssDao.updateStorySong(storySong);
		
	}
	//返回模糊的list
	public List<StorySong> getListByPuzzy (String value)
	{
		return ssDao.getStorySongByFuzzy(value);
	}

}
