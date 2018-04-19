package com.reminder.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.reminder.model.content;

@Transactional
@Component
public class Operations_Class {
@Autowired
private SessionFactory sessionFactory;
public Session session()
{
	return sessionFactory.getCurrentSession();
}
//Creating Reminder
public void create(content objA, String current) {
	
	session().save(objA);
	objA.setCurrent(current);
	}
//Searching reminders with id
public List<content> search(String rem_id) {
	
	Criteria CRT=session().createCriteria(content.class);
	CRT.add(Restrictions.eq("id", rem_id));
	List<content> KK=CRT.list();
	return KK;

}
//Updating reminder
public void Update(content ObjTable, String id, String content1, String remind_date, String remind_time, String current) {
	
	
	Query query=session().createQuery("update content set content1=:content1,remind_date=:remind_date,remind_time=:remind_time,current=:current where id=:id ");
	query.setString("id", id);
	query.setString("content1", content1);
	query.setString("remind_date",remind_date);
	query.setString("remind_time", remind_time);
	query.setString("current", current);
	query.executeUpdate();
}
//Grabbing table details
public List<content> RequestView(content ObjTable) {
	
	Criteria CRT=session().createCriteria(content.class);
	List<content> KK=CRT.list();
	return KK;
}




}

