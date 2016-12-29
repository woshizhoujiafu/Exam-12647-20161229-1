package hand.zjf.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;
import hand.zjf.dao.FilmOperationDao;
import hand.zjf.entity.Film;
import hand.zjf.event.AfterInsertFilmEvent;
import hand.zjf.event.BeforeInsertFilmEvent;
import hand.zjf.service.FilmOperationService;

public class FilmOperationServiceImpl implements FilmOperationService,ApplicationContextAware {

	private FilmOperationDao filmOperationDao;
	private ApplicationContext applicationContext;
	
	@Transactional
	public int insertOneFilm(Film film) {
		 System.out.println("*****************************************************************");
		 BeforeInsertFilmEvent bevent = new BeforeInsertFilmEvent("Before Insert Film Data");
		 System.out.println("*****************************************************************");
    	 applicationContext.publishEvent(bevent);
		try {
			this.filmOperationDao.insertOneFilm(film);
			System.out.println("*****************************************************************");
			System.out.println("***********************数据插入成功*******************************");
			System.out.println("*****************************************************************");
		} catch (Exception e) {
	throw new RuntimeException("***********************Film数据插入失败***************************");
		}
		System.out.println("*****************************************************************");
		AfterInsertFilmEvent aevent = new AfterInsertFilmEvent("After Insert Film Data");
		applicationContext.publishEvent(aevent);
		System.out.println("*****************************************************************");
		return 1;
	}
	
	
	
	public FilmOperationDao getFilmOperationDao() {
		return filmOperationDao;
	}
	public void setFilmOperationDao(FilmOperationDao filmOperationDao) {
		this.filmOperationDao = filmOperationDao;
	}



	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}
	
}
