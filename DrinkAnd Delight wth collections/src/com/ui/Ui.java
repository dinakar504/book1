package com.ui;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.Entities.RawMaterialOrder;
import com.service.OrderService;

public class Ui {
	static OrderService s=new OrderService();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter uid");
		int uid=sc.nextInt();
		System.out.println("enter upass");
		String pass=sc.next();
		if(s.validate(uid, pass))
		{
			while(true)
			{
				int option=sc.nextInt();
				switch (option) {
				case 1:
					RawMaterialOrder orders=s.displayOrders(uid,1);
	                System.out.println("oid\trawid\tsupid\tquanval\t\t\t\tdate of ord\t\t\t\t\tdateof del\t\t\ttotalprice\tdelsta\twareid");
					System.out.println(orders.getOrderid()+"\t"+orders.getRawid()+"\t"+orders.getSupplierid()+"\t"+orders.getQuanvalue()+"\t\t\t"+orders.getDateoford()+"\t\t\t"+orders.getDateofdel()+"\t\t\t"+orders.getTotalprice()+"\t"+orders.getDeliveryStus()+"\t"+orders.getWarehouseid());
					break;
				case 2:
					Set set1=s.display(uid);
					Iterator i1=set1.iterator();
					System.out.println("uid\t\t\toid\trawid\tsupid\tquanval\t\t\tdate of ord\t\t\t\t\tdateof del\t\t\t\ttotalprice\tdelsta\twareid");

					while(i1.hasNext())
					{
						Entry e1=(Entry) i1.next();
						
						System.out.println(e1.getValue());
					}
					System.out.println("enter orderid");
					int oid=sc.nextInt();
					System.out.println("enter value");
					int value=sc.nextInt();
					s.updateOrder(uid,oid,value);
					RawMaterialOrder orders1=s.displayOrders(uid,oid);
	                System.out.println("uid\toid\trawid\tsupid\tquanval\t\t\t\tdate of ord\t\t\t\t\tdateof del\t\t\ttotalprice\tdelsta\twareid");
					System.out.println(orders1.getUserid()+"\t"+orders1.getOrderid()+"\t"+orders1.getRawid()+"\t"+orders1.getSupplierid()+"\t"+orders1.getQuanvalue()+"\t\t\t"+orders1.getDateoford()+"\t\t\t"+orders1.getDateofdel()+"\t\t\t"+orders1.getTotalprice()+"\t"+orders1.getDeliveryStus()+"\t"+orders1.getWarehouseid());
					break;
				case 3:
					Set set=s.display(uid);
					Iterator i=set.iterator();
					System.out.println("uid\t\t\toid\trawid\tsupid\tquanval\t\t\tdate of ord\t\t\t\t\tdateof del\t\t\t\ttotalprice\tdelsta\twareid");

					while(i.hasNext())
					{
						Entry e=(Entry) i.next();
						
						System.out.println(e.getValue());
					}
						
					break;
				default:
					break;
				}
				
			}

		}
		else
			System.err.println("invalid user");
		

	}

}
