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
		/*uObj.setBuyerId(1);
		uObj.setCreatedDate(LocalDate.now());
		uObj.setSellerId(2);
		uObj.setVendorId(3);
		uObj.setPoId(80);
		uObj.setProductId(1003);
		uObj.setPoQuantity(500);
		LocalDate date = LocalDate.now();
		uObj.setDeliveryDate(date.plusDays(30));
		boolean obj = purchaseorder.addPurchaseOrder(uObj);
		assertTrue("Problem in adding product", obj);
*/
	}

}
