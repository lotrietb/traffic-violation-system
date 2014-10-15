/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.project.trafficviolationsystem.test.repository;

import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tp.project.trafficviolationsystem.app.conf.ConnectionConfig;
import tp.project.trafficviolationsystem.domain.Trial;
import tp.project.trafficviolationsystem.repository.TrialRepository;

/**
 *
 * @author Hannes
 */
public class TrialRepoTest {
    private Long id;
    private static ApplicationContext ctx;
    private TrialRepository repo;
    
    public TrialRepoTest() {
    }
    
    @Test
    public void testCreate() {
        repo = ctx.getBean(TrialRepository.class);
        Trial t = new Trial.Builder()
                .courtDate(new Date())
                .verdict("SomeVerdict")
                .build();
        repo.save(t);
        id = t.getId();
        
        Assert.assertNotNull(t);
    }
    
    @Test(dependsOnMethods = "testCreate", enabled = true)
    public void testRead() {
        repo = ctx.getBean(TrialRepository.class);
        Trial t = repo.findOne(id);
        
        Assert.assertEquals("SomeVerdict", t.getVerdict());
    }
    
    @Test(dependsOnMethods = "testRead", enabled = true)
    public void testUpdate() {
        repo = ctx.getBean(TrialRepository.class);
        Trial t = repo.findOne(id);
        Trial updatedTrial = new Trial.Builder()
                .trial(t)
                .verdict("BrandSpankingNewVerdict")
                .build();
        repo.save(updatedTrial);
        Trial newTrial = repo.findOne(id);
        
        Assert.assertEquals("BrandSpankingNewVerdict", newTrial.getVerdict());
    }
    
    @Test(dependsOnMethods = "testUpdate", enabled = true)
    public void testDelete() {
        repo = ctx.getBean(TrialRepository.class);
        Trial t = repo.findOne(id);
        repo.delete(t);
        Trial deletedTrial = repo.findOne(id);
        
        Assert.assertNull(deletedTrial);
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
