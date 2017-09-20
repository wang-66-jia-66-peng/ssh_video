package com.zhiyou100.video.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.video.dao.AdminVideoDao;
import com.zhiyou100.video.model.Video;

public class AdminVideoDaoImpl extends HibernateDaoSupport  implements AdminVideoDao {

	@Override
	public List<Video> findVideoBySearch(String videoKeyWord, Integer videoSearchSpeaker, Integer videoSearchCourse,
			Integer currentPage) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(Video.class);
		if (!videoKeyWord.equals("")) {
			dc.add(Restrictions.like("videoTitle","%"+videoKeyWord+"%"));
		}
		if (videoSearchSpeaker != 0) {
			dc.add(Restrictions.eq("speaker.id", videoSearchSpeaker));
		}
		if (videoSearchCourse != 0) {
			dc.add(Restrictions.eq("course.id", videoSearchCourse));
		}
		
	   List<Video> list = (List<Video>) getHibernateTemplate().findByCriteria(dc,(currentPage-1)*10,10);
		
	   //System.out.println(list);
	
		return list;
	}
	

	@Override
	public Integer findVideoBySearchCount(String videoKeyWord, Integer videoSearchSpeaker, Integer videoSearchCourse,
			Integer currentPage) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(Video.class);
		if (!videoKeyWord.equals("")) {
			dc.add(Restrictions.like("videoTitle","%"+videoKeyWord+"%"));
		}
		if (videoSearchSpeaker != 0) {
			dc.add(Restrictions.eq("speaker.id", videoSearchSpeaker));
		}
		if (videoSearchCourse != 0) {
			dc.add(Restrictions.eq("course.id", videoSearchCourse));
		}
		  List<Video> list2 = (List<Video>) getHibernateTemplate().findByCriteria(dc);
		
		  return list2.size();
	}


	@Override
	public void addVideo(Video video) {
		  getHibernateTemplate().saveOrUpdate(video);
	}


	@Override
	public void deleteVideoById(Integer vid) {
		  List<Video> list = (List<Video>) getHibernateTemplate().find("from Video where  id = ?", vid);
		  
		  getHibernateTemplate().delete(list.get(0));
		  
	}


	@Override
	public Video findVideoById(Integer id) {
		 List<Video> list = (List<Video>) getHibernateTemplate().find("from Video where  id = ?", id);
		 return list.get(0);
	}


	@Override
	public List<Video> statisticsList() {
		  
		    //String  str ="SELECT c.course_name, avg(video_play_times) as Average from  video v   LEFT JOIN course  c ON v.course_id=c.idGROUP BY course_id ";
		    String  str ="SELECT c.course_name, avg(video_play_times) as Average from  video v   LEFT JOIN course  c ON v.course_id=c.id GROUP BY course_id ";
		
		    List<Object[]> list = getSessionFactory().getCurrentSession().createSQLQuery(str).list();
		    
		    List<Video> li = new  ArrayList<>();
		    		
		    for (Object[] objects : list) {
				 Video  video = new Video();
		    	  video.setCName((String)objects[0]);
		    	  String st=(objects[1]).toString();
		    	  Double d  =  Double.parseDouble(st);
		    	  Integer i  = d.intValue(); 
		    	  video.setAverage(i);
		    	  li.add(video);
		  	  }
		  
		     // System.out.println(li); 
		  
		
		    return li;
	}


	@Override
	public List<Video> findVideoAllandSpeakerNameById(Integer speakerId) {
		
		List<Video> list = (List<Video>) getHibernateTemplate().find("from Video v where  v.speaker.id = ?", speakerId);
		
		 return list;
	}


	@Override
	public void addVideoState(int parseInt) {
        // System.out.println("=============");		
		 List<Video> list = (List<Video>)getHibernateTemplate().find("from Video where  id = ?", parseInt);
		// System.out.println("0dddddd------"+list.get(0));
		 //getHibernateTemplate().delete(list.get(0));
		 Integer times = list.get(0).getVideoPlayTimes();
		// System.out.println("1----------------");
		 list.get(0).setVideoPlayTimes(times+1);
		 System.out.println("2===============");
		/* list.get(0).setVideoDescr("pppppppp");
		 System.out.println("3+++++++++++++++");
		 System.out.println("4ssssss-----"+list.get(0));
		 Video video=list.get(0);
		 getHibernateTemplate().saveOrUpdate(video);*/
	} 

	
	
	
}
