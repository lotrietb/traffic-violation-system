/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.project.trafficviolationsystem.test.repository;

import java.util.Date;
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
import tp.project.trafficviolationsystem.domain.Address;
import tp.project.trafficviolationsystem.domain.Fine;
import tp.project.trafficviolationsystem.repository.FineRepository;

/**
 *
 * @author Hannes
 */
public class FineRepoTest {
    private Long id;
    private static ApplicationContext ctx;
    private FineRepository repo;
    
    public FineRepoTest() {
    }

    @Test
    public void testCreate() {
        repo = ctx.getBean(FineRepository.class);
        
        Address a = new Address();
        a.setStreet("19 Make Believe");
        a.setSuburb("Hillcrest");
        a.SetPostalCode("8570");

        Fine f = new Fine.Builder()
                .fineDate(new Date())
                .amount(200)
                .address(a)
                .build();
        
        repo.save(f);
        id = f.getId();
        
        Assert.assertNotNull(f);
    }
    
    @Test(dependsOnMethods = "testCreate", enabled = true)
    public void testRead() {
        repo = ctx.getBean(FineRepository.class);
        Fine f = repo.findOne(id);
        
        Assert.assertEquals("8570", f.getAddress().getPostalCode());
        Assert.assertEquals(200, f.getAmount(), 0);
    }
    
    @Test(dependsOnMethods = "testRead", enabled = true)
    public void testUpdate() {
        repo = ctx.getBean(FineRepository.class);
        Fine fine = repo.findOne(id);
        Fine updatedFine = new Fine.Builder()
                .fine(fine)
                .amount(300)
                .build();
        repo.save(updatedFine);
        Fine newFine = repo.findOne(id);
        
        Assert.assertEquals(300, newFine.getAmount(), 0);
    }
    
    @Test(dependsOnMethods = "testUpdate", enabled = true)
    public void testDelete() {
        repo = ctx.getBean(FineRepository.class);
        Fine f = repo.findOne(id);
        repo.delete(f);
        Fine deletedFine = repo.findOne(id);
        
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
