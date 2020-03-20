package com.service;

import java.util.Set;

import com.Entities.RawMaterialOrder;
import com.dao.OrderDoa;

public class OrderService {
	
	OrderDoa d=new OrderDoa();
	public RawMaterialOrder displayOrders(int userid,int oid)
 {
	
	 return d.dispalyOrders(userid,oid);
	 
 }
	public void updateOrder(int uid,int orderid,int value ){
		try {
			
			d.updateOrder(uid,orderid, value);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public Set display(int userid)
	{
		return d.display(userid);
	}
	public boolean validate(int uid,String uname)
	{
		return d.validate(uid, uname);
	}
	
}
