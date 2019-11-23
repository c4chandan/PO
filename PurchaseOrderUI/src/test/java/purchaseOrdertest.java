import static org.junit.Assert.assertTrue;

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
		uObj.setBuyer_id(101);
		uObj.setPo_Id(10);
		uObj.setPo_name("firstorder");
		uObj.setProducts_id(10112);
		uObj.setQuantity(12450);
		uObj.setStatus("pending");
		boolean b = purchaseorder.addPurchaseOrder(uObj);

		assertTrue("Problem in adding product", b);

	}

}
