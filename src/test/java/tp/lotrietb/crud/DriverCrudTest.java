package tp.lotrietb.crud;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Date;
import tp.lotrietb.trafficviolationsystem.app.conf.ConnectionConfig;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
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
    public void testDriverCreate()
    {
        driverCrudService = ctx.getBean(DriverCrudService.class);
        
        Driver driver = new Driver();
        driver.setDriver_name("Brandon");
        driver.setDriver_dob(new Date(1992, 07, 25));
        driver.setAddress("3 Charnwood Close");
        driver.setExp_date(new Date("05/04/2015"));
        driver.setLicence_type("Permanent");
        
        Driver d = driverCrudService.persist(driver);
        id = d.getId();
        Assert.assertEquals(driver, d, "The driver persisted successfully");
    }
    
    @Test(dependsOnMethods = {"testDriverCreate"})
    public void testDriverRead()
    {
        driverCrudService = ctx.getBean(DriverCrudService.class);
        Driver driver = driverCrudService.find(id);
        
        Assert.assertEquals(driver.getDriver_name(), "Brandon", "The names does not match");
    }
    
    @Test(dependsOnMethods = {"testDriverRead"})
    public void testDriverUpdate()
    {
        driverCrudService = ctx.getBean(DriverCrudService.class);
        Driver d = driverCrudService.find(id);
        d.setDriver_name("Lovemore");
        driverCrudService.merge(d);
        
        Assert.assertEquals(d.getDriver_name(), "Lovemore", "The names does not match");
    }

   /* @Test(dependsOnMethods = {"testDriverUpdate"})
    public void testDriverDelete()
    {
        driverCrudService = ctx.getBean(DriverCrudService.class);
        
        driverCrudService.remove(driverCrudService.find(id));
        Driver driver = driverCrudService.find(id);
        
        Assert.assertNull(driver, "The driver does not exist");
    }*/
    
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
