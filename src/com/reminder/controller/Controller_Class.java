package com.reminder.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.reminder.model.content;
import com.reminder.service.Service_Class;


@Controller
public class Controller_Class {
	@Autowired
	Service_Class serv;
	//Creating Time Loop Starting Web Application
	@RequestMapping("/")
	public String index()
	{
		Timer t= new Timer();
		t.scheduleAtFixedRate(
				new TimerTask()
				{
					public void run()
					{						
						content ObjTable=new content();
						List<content> FG = serv.RequestView(ObjTable);
						SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
						SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
						Date dd = new Date();
						String currenttime=tf.format(dd);
						String current=df.format(dd);
						for(content HH:FG)
						{ 
							String remtime=HH.getRemind_time();
							String remdate=HH.getRemind_date();
							if(currenttime.equals(remtime)&&current.equals(remdate))
							{
								JOptionPane op = new JOptionPane(HH.getContent1());
								JDialog d = op.createDialog("Reminder");
								d.setAlwaysOnTop(true);
								d.setVisible(true);
							}
						}
					}
				}
				, 0, 30000);
		return "Home";
	}
//Going to Page Create
	@RequestMapping("createreminder")
	public String create_page()
	{
		return "Create";
	}
	
	//Adding New Reminder
	@RequestMapping(value="create",params="b1")
	public String createreminder(content objA,HttpServletRequest req)
	{
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		Date dd = new Date();
		String current=df.format(dd);
		serv.create(objA,current);
		return "Home";
	}
	
	//Going to update page
	
	@RequestMapping("updatereminder")
	public String update_page()
	{
		return "Update";
	}
	// Searching Content from database
	@RequestMapping(value="change",params="b1")
	public String change(content objA,HttpServletRequest req, Model z)
	{
		String rem_id=req.getParameter("id");
		List<content> SS=serv.search(rem_id);
		if (SS.isEmpty()) {
			JOptionPane op = new JOptionPane("Subject Not found");
			JDialog d = op.createDialog("Not Found");
			d.setAlwaysOnTop(true);
			d.setVisible(true);
			return ("Update");
		} else {
			for(content P:SS)
			{   z.addAttribute("Aid", P.getId());
				z.addAttribute("Acontent", P.getContent1());
				z.addAttribute("ARemind_date", P.getRemind_date());
				z.addAttribute("ARemind_time",P.getRemind_time());
				z.addAttribute("ACurrent", P.getCurrent());
			}
			return ("Update");
		}
		
	}
	
	//Updating Values to the table
	@RequestMapping(value="change",params="b2")
	public String change2(content ObjTable,HttpServletRequest req)
	{
		
		String Id=req.getParameter("id");
		String content=req.getParameter("content1");
		String remind_date=req.getParameter("remind_date");
		String remind_time=req.getParameter("remind_time");
	
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		Date dd = new Date();
		String current=df.format(dd);
		serv.Update(ObjTable,Id,content,remind_date,remind_time,current);
		return ("Home");
	}
	
	//Grabbed values Show to View Page
	@RequestMapping(value="view")
	public String view(content ObjTable,Model v)
	{   
		List<content> FG = serv.RequestView(ObjTable);
		v.addAttribute("label", FG);
		return("View");
	}
}
