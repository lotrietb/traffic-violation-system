/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.project.trafficviolationsystem.test.repository;

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
import tp.project.trafficviolationsystem.domain.FineType;
import tp.project.trafficviolationsystem.repository.FineTypeRepository;

/**
 *
 * @author Hannes
 */
public class FineTypeRepoTest {
    private Long id;
    private static ApplicationContext ctx;
    private FineTypeRepository repo;
    
    public FineTypeRepoTest() {
    }
    
    @Test
    public void testCreate() {
        repo = ctx.getBean(FineTypeRepository.class);
        FineType ft = new FineType.Builder()
                .name("Name")
                .descr("Description")
                .build();
        repo.save(ft);
        id = ft.getId();
        
        Assert.assertNotNull(ft);
    }
    
    @Test(dependsOnMethods = "testCreate", enabled = true)
    public void testRead() {
        repo = ctx.getBean(FineTypeRepository.class);
        FineType ft = repo.findOne(id);
        
        Assert.assertEquals("Description", ft.getDescr());
    }
    
    @Test(dependsOnMethods = "testRead", enabled = true)
    public void testUpdate() {
        repo = ctx.getBean(FineTypeRepository.class);
        FineType ft = repo.findOne(id);
        FineType updatedFineType = new FineType.Builder()
                .fineType(ft)
                .descr("NewDescription")
                .build();
        repo.save(updatedFineType);
        FineType newFineType = repo.findOne(id);
        
        Assert.assertEquals("NewDescription", newFineType.getDescr());
    }
    
    @Test(dependsOnMethods = "testUpdate", enabled = true)
    public void testDelete() {
        repo = ctx.getBean(FineTypeRepository.class);
        FineType ft = repo.findOne(id);
        repo.delete(ft);
        FineType deletedFileType = repo.findOne(id);
        
        Assert.assertNull(deletedFileType);
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
