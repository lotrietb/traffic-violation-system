/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.project.trafficviolationsystem.test.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tp.project.trafficviolationsystem.app.conf.ConnectionConfig;
import tp.project.trafficviolationsystem.domain.Contact;
import tp.project.trafficviolationsystem.domain.Driver;
import tp.project.trafficviolationsystem.domain.License;
import tp.project.trafficviolationsystem.domain.Officer;
import tp.project.trafficviolationsystem.repository.DriverRepository;
import tp.project.trafficviolationsystem.repository.OfficerRepository;

/**
 *
 * @author Hannes
 */
public class PersonRepoTest {
    private Long idD;
    private Long idO;
    private static ApplicationContext ctx;
    private DriverRepository driveRepo;
    private OfficerRepository offiRepo;
    
    public PersonRepoTest() {
        
    }
    
    @Test
    public void testCreate() {
        driveRepo = ctx.getBean(DriverRepository.class);
        offiRepo = ctx.getBean(OfficerRepository.class);
        
        Contact c = new Contact();
        c.setCellNumber("0833587958");
        c.setHomeNumber("0128749855");
        c.setEmail("test@example.com");
        
        License l1 = new License.Builder()
                .code(5)
                .expiryDate(new Date())
                .build();
        License l2 = new License.Builder()
                .code(7)
                .expiryDate(new Date())
                .build();
        List<License> licenses = new ArrayList<>();
        licenses.add(l1);
        licenses.add(l2);
        
        Driver d = new Driver.Builder()
                .name("Name")
                .surname("Surname")
                .age(20)
                .idNum("123456789")
                .contact(c)
                .licenses(licenses)
                .build();
        Officer o = new Officer.Builder()
                .name("ASD")
                .surname("DSA")
                .age(25)
                .idNum("987654321")
                .rank("Rank")
                .points(4)
                .build();
        driveRepo.save(d);
        offiRepo.save(o);
        idD = d.getId();
        idO = o.getId();
        
        Assert.assertNotNull(d);
        Assert.assertNotNull(o);
    }
    
    @Test(dependsOnMethods = "testCreate", enabled = true)
    public void testRead() {
        driveRepo = ctx.getBean(DriverRepository.class);
        offiRepo = ctx.getBean(OfficerRepository.class);
        Driver d = driveRepo.findOne(idD);
        Officer o = offiRepo.findOne(idO);
        
        Assert.assertEquals(20, d.getAge());
        Assert.assertEquals("Rank", o.getRank());
    }
    
    @Test(dependsOnMethods = "testRead", enabled = true)
    public void testUpdate() {
        driveRepo = ctx.getBean(DriverRepository.class);
        offiRepo = ctx.getBean(OfficerRepository.class);
        Driver d = driveRepo.findOne(idD);
        Officer o = offiRepo.findOne(idO); 
        Driver updatedDriver = new Driver.Builder()
                .driver(d)
                .age(23)
                .build();
        Officer updatedOfficer = new Officer.Builder()
                .officer(o)
                .points(6)
                .build();
        driveRepo.save(updatedDriver);
        offiRepo.save(updatedOfficer);
        Driver newDriver = driveRepo.findOne(idD);
        Officer newOfficer = offiRepo.findOne(idO);
        
        Assert.assertEquals(23, newDriver.getAge());
        Assert.assertEquals(6, newOfficer.getPoints());
    }
    
    @Test(dependsOnMethods = "testUpdate", enabled = true)
    public void testDelete() {
        driveRepo = ctx.getBean(DriverRepository.class);
        offiRepo = ctx.getBean(OfficerRepository.class);
        Driver d = driveRepo.findOne(idD);
        Officer o = offiRepo.findOne(idO);
        driveRepo.delete(d);
        offiRepo.delete(o);
        Driver deletedDriver = driveRepo.findOne(idD);
        Officer deletedOfficer = offiRepo.findOne(idO);
        
        Assert.assertNull(deletedDriver);
        Assert.assertNull(deletedOfficer);
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
