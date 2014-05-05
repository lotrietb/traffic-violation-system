/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotrietb.crud;

import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tp.lotrietb.trafficviolationsystem.app.conf.ConnectionConfig;
import tp.lotrietb.trafficviolationsystem.domain.Fine;
import tp.lotrietb.trafficviolationsystem.domain.violation;
import tp.lotrietb.trafficviolationsystem.services.crud.FineCrudService;

/**
 *
 * @author Brandon1
 */
public class FineCrudTest {
    private static ApplicationContext ctx;
    private Long id;
    private FineCrudService fineCrudService;
    public FineCrudTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createFine()
    {
        fineCrudService = ctx.getBean(FineCrudService.class);
        Fine fine = new Fine();
        fine.setCourt_date(new Date("07/05/2014"));
        fine.setCourt_no(new Long("325"));
        fine.setDate_of_fine(new Date("05/05/2014"));
        fine.setDriver_id(new Long("5"));
        fine.setLicence_no("CA 54780 F");
        fine.setOfficer_no(new Long("489"));
        fine.setVerdict("Guilty");
        fine.setViolation_Address("15 Main Street Durbanville");
        fine.setViolation_amount(4500.00);
        
        //add the violation
        violation v = new violation();
        v.setViolation_code(new Long("987654"));
        v.setDescription("The driver was speeding at 240km/h in a 60km/h zone.");
        fine.setViolation(v);
        
        Fine persistedFine = fineCrudService.persist(fine);
        id = persistedFine.getId();
        Assert.assertEquals(fine, persistedFine);
    }
    
    @Test(dependsOnMethods = "createFine")
    public void readFine()
    {
        fineCrudService = ctx.getBean(FineCrudService.class);
        Fine fine = fineCrudService.find(id);
        
        Assert.assertEquals(fine.getDriver_id(), new Long("5"));
    }
    
    @Test(dependsOnMethods = "readFine")
    public void updateFine()
    {
        fineCrudService = ctx.getBean(FineCrudService.class);
        Fine fine = fineCrudService.find(id);
        
        fine.setCourt_date(new Date("12/05/2014"));
        Fine updatedFine = fineCrudService.merge(fine);
        
        Assert.assertEquals(fine.getCourt_date(), updatedFine.getCourt_date());
    }
    
    @Test(dependsOnMethods = "updateFine")
    public void removeFine()
    {
        fineCrudService = ctx.getBean(FineCrudService.class);
        Fine fine = fineCrudService.find(id);
        fineCrudService.remove(fine);
        
        Fine deletedFine = fineCrudService.find(id);
        
        Assert.assertNull(deletedFine);
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
