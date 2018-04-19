package com.reminder.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="content")
public class content{
@Id

private String id;
private String content1;
private String remind_date;
private String remind_time;
private String current;
/**
 * @return the id
 */
public String getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(String id) {
	this.id = id;
}
/**
 * @return the content1
 */
public String getContent1() {
	return content1;
}
/**
 * @param content1 the content1 to set
 */
public void setContent1(String content1) {
	this.content1 = content1;
}
/**
 * @return the remind_date
 */
public String getRemind_date() {
	return remind_date;
}
/**
 * @param remind_date the remind_date to set
 */
public void setRemind_date(String remind_date) {
	this.remind_date = remind_date;
}
/**
 * @return the remind_time
 */
public String getRemind_time() {
	return remind_time;
}
/**
 * @param remind_time the remind_time to set
 */
public void setRemind_time(String remind_time) {
	this.remind_time = remind_time;
}
/**
 * @return the current
 */
public String getCurrent() {
	return current;
}
/**
 * @param current the current to set
 */
public void setCurrent(String current) {
	this.current = current;
}

}

