package com.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.Entities.RawMaterialOrder;
import com.Entities.RawMaterialSpecs;
import com.Entities.User;

public class OrderDoa {
	Map<Integer,RawMaterialOrder> a=new HashMap<Integer,RawMaterialOrder>();
	Map<Integer,RawMaterialSpecs> b=new HashMap<Integer,RawMaterialSpecs>();
	Map<Integer,User> c=new HashMap<Integer, User>();
			static int ord1=2;
   public OrderDoa() {
	// TODO Auto-generated constructor stub
	  User u=new User();
	  u.setUserid(1);
	  u.setPass("din");
	  c.put(u.getUserid(), u);
	   RawMaterialSpecs s=new RawMaterialSpecs();
	   s.setRawid(1);
	   
	   s.setRawname("Fanta");
	   s.setRawpp(10);
	   b.put(1,s);
	   RawMaterialSpecs s1=new RawMaterialSpecs();
	   s1.setRawid(2);
	   
	   s1.setRawname("banta");
	   s1.setRawpp(20);
	   b.put(2,s1);
	   RawMaterialOrder r1=new RawMaterialOrder();
	   r1.setOrderid(1);
	   r1.setRawid(1);
	   r1.setDateoford(new Date());
	  r1.setUserid(1);
	   Calendar cal = Calendar.getInstance();
		cal.setTime(r1.getDateoford());
		cal.add(Calendar.DATE, 4);
		Date modifiedDate = cal.getTime();
		 r1.setDateofdel(modifiedDate);
	   r1.setDeliveryStus("True");
	  // r1.setQuanunit();
	   r1.setQuanvalue(5);
	   r1.setTotalprice(50);
	   r1.setSupplierid(1);
	   r1.setWarehouseid(1);
	   a.put(1, r1);
	   RawMaterialOrder r=new RawMaterialOrder();
	   r.setUserid(2);
	   r.setOrderid(2);
	   r.setRawid(2);
	   r.setDateoford(new Date());
	  
	
	   Calendar cal1= Calendar.getInstance();
		cal1.setTime(r1.getDateoford());
		cal1.add(Calendar.DATE, 4);
		Date modifiedDate1 = cal1.getTime();
		 r.setDateofdel(modifiedDate1);
	   r.setDeliveryStus("True");
	  // r1.setQuanunit();
	   r.setQuanvalue(5);
	   r.setTotalprice(50);
	   r.setSupplierid(1);
	   r.setWarehouseid(1);
	   a.put(2, r);
	   RawMaterialOrder r2=new RawMaterialOrder();
	   r2.setUserid(2);
	   r2.setOrderid(3);
	   r2.setRawid(2);
	   r2.setDateoford(new Date());
	  
	   Calendar cal2= Calendar.getInstance();
		cal2.setTime(r1.getDateoford());
		cal2.add(Calendar.DATE, 4);
		Date modifiedDate2 = cal2.getTime();
		 r2.setDateofdel(modifiedDate2);
	   r2.setDeliveryStus("True");
	  // r1.setQuanunit();
	   r2.setQuanvalue(5);
	   r2.setTotalprice(50);
	   r2.setSupplierid(1);
	   r2.setWarehouseid(1);
	   a.put(3, r2);
}
   public RawMaterialOrder dispalyOrders(int uid,int orderid)
   {
	   RawMaterialOrder new4=a.get(orderid);
	   if(a.containsKey(orderid)&&new4.getUserid()==uid)
	   {
		   return  (RawMaterialOrder) a.get(orderid);
	   }
	  return null;   
   }
   
  public void updateOrder(int uid,int orderid,int value ){
	
	  RawMaterialOrder new1=a.get(orderid);
	 if(new1.getUserid()==uid)
	 {
		 new1.setQuanvalue(value);
		 
		 RawMaterialSpecs aa=(RawMaterialSpecs) b.get(new1.getRawid());
//		 System.out.println((RawMaterialSpecs)b.get(new1.getRawid()));
//		 System.out.println(new1.getRawid());
		 new1.setTotalprice(aa.getRawpp()*value);
		 System.out.println(new1.getTotalprice());
		 a.put(orderid, new1);
	}
	 }
	  
  public Set display(int userid)
  {
	  Map new2=new HashMap();
	  Set set=a.entrySet();
	  Iterator i=set.iterator();
	  while(i.hasNext())
	  {
	  	Entry e=(Entry) i.next();
	  	RawMaterialOrder a1=(RawMaterialOrder)e.getValue();
	  	if(a1.getUserid()==userid)
	  	{
	  		
	  		new2.put(a1.getOrderid(),e);
	  	}
	  }
    	return new2.entrySet(); 
  }
  public boolean validate(int uid,String uname)
  {
	 
	 if(c.containsKey(uid))
	 {
		 User u1= c.get(uid);
		 if(u1.getPass().equals(uname)) {
			 return true;
		 }
	 }
	return false;
  }
	
//	
//	public static void main(String[] args) {
//		OrderDoa o=new OrderDoa();
//		o.updateOrder(1, 4);
//		System.out.println(o.dispalyOrders(1));
//	
//	}
//	
	
}
