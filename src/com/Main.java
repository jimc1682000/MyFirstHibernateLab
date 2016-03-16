package com;

import java.util.Date;

import org.hibernate.Session;

import utils.MyHibernateUtil;
import vo.MyStock;

public class Main {
	public static void main(String[] args) {
		MyStock mystock = new MyStock();
		mystock.setId(1);
		mystock.setCost(30d);
		mystock.setShares(1);
		mystock.setSymbol("test1");
		mystock.settDate(new Date());
		Session session = MyHibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(mystock);
		
		session.getTransaction().commit();
		session.close();
		MyHibernateUtil.shutdown();
	}
}
