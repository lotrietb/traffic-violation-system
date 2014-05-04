package tp.lotrietb.repository;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tp.lotrietb.trafficviolationsystem.app.conf.ConnectionConfig;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tp.lotrietb.trafficviolationsystem.domain.Driver;
import tp.lotrietb.trafficviolationsystem.repository.DriverRepository;

/**
 *
 * @author Brandon1
 */
public class DriverRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;

    private DriverRepository driverRepositoryTest;
    public DriverRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testRepo()
    {
         driverRepositoryTest = ctx.getBean(DriverRepository.class);
         Driver driver = new Driver();
         driver.setAddress("3 Charnwood");
         driver.setDriver_dob(new Date());
         driver.setDriver_name("Brandon");
         driver.setExp_date(new Date("15 May 2014"));
         driver.setLicence_type("Temporary");
         driverRepositoryTest.save(driver);
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
