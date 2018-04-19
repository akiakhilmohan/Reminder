package com.reminder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reminder.dao.Operations_Class;
import com.reminder.model.content;

@Service
public class Service_Class {
@Autowired
Operations_Class oper;
//service of creating /adding values
public void create(content objA, String current) {

	oper.create(objA,current);
}
//Service of searching reminder
public List<content> search(String rem_id) {
	
	return oper.search(rem_id);
}
//Service of Updating
public void Update(content ObjTable, String id, String content1, String remind_date, String remind_time, String current) {
	
	oper.Update(ObjTable,id,content1,remind_date,remind_time,current);
}
//Service of RequestView
public List<content> RequestView(content ObjTable) {
	
	return oper.RequestView(ObjTable);
}



}
