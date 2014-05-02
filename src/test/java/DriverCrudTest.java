/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tp.lotrietb.trafficviolationsystem.domain.Driver;
import tp.lotrietb.trafficviolationsystem.services.crud.DriverCrudService;

/**
 *
 * @author Brandon1
 */
public class DriverCrudTest {
    private static ApplicationContext ctx;
    private DriverCrudService driverCrudService;
    private Long id;
    
    
    public DriverCrudTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testDriverCrud()
    {
        driverCrudService = ctx.getBean(DriverCrudService.class);
        List<Driver> drivers = driverCrudService.findAll();
        
        for(int i = 0; i < drivers.size(); i++)
        {
            System.out.println(drivers.get(i).getDriver_name());
        }
        
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
