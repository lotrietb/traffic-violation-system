/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotrietb.crud;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tp.lotrietb.trafficviolationsystem.app.conf.ConnectionConfig;
import tp.lotrietb.trafficviolationsystem.domain.Court;
import tp.lotrietb.trafficviolationsystem.services.crud.CourtCrudService;

/**
 *
 * @author Brandon1
 */
public class CourtCrudTest {
    private static ApplicationContext ctx;
    private Long id;
    private CourtCrudService courtCrudService;
    
    public CourtCrudTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createCourt() 
    {   
        courtCrudService = ctx.getBean(CourtCrudService.class);
        Court court = new Court();
        court.setCourt_address("15 Memento Way, Socrates");
        court.setCourt_name("South African High Court");
        Court persisted_court = courtCrudService.persist(court);
        id = persisted_court.getId();
        
        Assert.assertEquals(court, persisted_court);
    }
    
    @Test(dependsOnMethods = "createCourt")
    public void readCourt() 
    {   
        courtCrudService = ctx.getBean(CourtCrudService.class);
        Court court = courtCrudService.find(id);
        
        Assert.assertEquals(court.getCourt_name() , "South African High Court");
    }
    
    @Test(dependsOnMethods = "readCourt")
    public void updateCourt() 
    {   
        courtCrudService = ctx.getBean(CourtCrudService.class);
        Court court = courtCrudService.find(id);
        
        court.setCourt_name("South African Family Court");
        
        Court c = courtCrudService.merge(court);
        
        Assert.assertEquals(court.getCourt_name(), c.getCourt_name());
    }
    
    @Test(dependsOnMethods = "updateCourt")
    public void removeCourt() 
    {   
        courtCrudService = ctx.getBean(CourtCrudService.class);
        Court c = courtCrudService.find(id);
        courtCrudService.remove(c);
        
        Court court = courtCrudService.find(id);

        Assert.assertNull(court);
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
