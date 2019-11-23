package com.purchaseOrder.PurchaseOrderbackend;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.purchaseOrder.DbConfig.DbConfig;
import com.purchaseOrder.dao.PurchaseOrderDao;
import com.purchaseOrder.model.PurchaseOrder;

public class purchaseOrdertest {

	@Autowired
private static PurchaseOrderDao purchaseorder;
	
	@BeforeClass
	public static void init() {

		try {
			System.out.println("i m in");
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);

			purchaseorder  = context.getBean(PurchaseOrderDao.class, "purchaseorder");

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("I m Init.....");

	}

	@Test
	public void addPurchaseOrderTest()
	{
		PurchaseOrder uObj = new PurchaseOrder();
		uObj.setBuyer_id(102);
		//uObj.setPo_Id(10);
		uObj.setPo_name("secondorder");
		uObj.setProducts_id(101111);
		uObj.setQuantity(120);
		uObj.setCreated_date(LocalDate.now());
		uObj.setStatus("pending");
		boolean b = purchaseorder.addPurchaseOrder(uObj);

		assertTrue("Problem in adding product", b);

	}

}
