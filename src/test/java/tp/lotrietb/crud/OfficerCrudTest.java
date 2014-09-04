/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotrietb.crud;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tp.lotrietb.trafficviolationsystem.app.conf.ConnectionConfig;
import tp.lotrietb.trafficviolationsystem.domain.Officer;
import tp.lotrietb.trafficviolationsystem.services.crud.OfficerCrudService;

/**
 *
 * @author Brandon1
 */
public class OfficerCrudTest {
    private static ApplicationContext ctx;
    private Long id;
    private OfficerCrudService officerCrudService;
            
    public OfficerCrudTest() {
    }

    // TODO stop being a noob.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createOfficer()
    {
        officerCrudService = ctx.getBean(OfficerCrudService.class);
        
        Officer officer = new Officer();
        officer.setEmail("lotrietb@gmail.com");
        officer.setOfficer_name("Brandon");
        officer.setPoints(15);
        officer.setRank("Corporal");
                
        Officer persistedOfficer = officerCrudService.persist(officer);
        id = persistedOfficer.getId();
        
        Assert.assertEquals(officer, persistedOfficer);
    }
    
    @Test(dependsOnMethods = "createOfficer")
    public void readOfficer()
    {
        officerCrudService = ctx.getBean(OfficerCrudService.class);
        Officer officer = officerCrudService.find(id);
        
        Assert.assertEquals(officer.getEmail(), "lotrietb@gmail.com");
    }
    
    @Test(dependsOnMethods = "readOfficer")
    public void updateOfficer()
    {
        officerCrudService = ctx.getBean(OfficerCrudService.class);
        Officer officer = officerCrudService.find(id);
        officer.setEmail("211202320@mycput.ac.za");
        Officer savedOfficer = officerCrudService.merge(officer);
        
        Assert.assertEquals(savedOfficer.getEmail(), officer.getEmail());
    }
    
    @Test(dependsOnMethods = "updateOfficer")
    public void removeOfficer()
    {
        officerCrudService = ctx.getBean(OfficerCrudService.class);
        Officer officer = officerCrudService.find(id);
        officerCrudService.remove(officer);
        Officer officer2 = officerCrudService.find(id);
        
        Assert.assertNull(officer2);
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
