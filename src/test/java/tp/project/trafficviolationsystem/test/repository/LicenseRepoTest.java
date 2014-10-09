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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tp.project.trafficviolationsystem.app.conf.ConnectionConfig;
import tp.project.trafficviolationsystem.domain.License;
import tp.project.trafficviolationsystem.repository.LicenseRepository;


public class LicenseRepoTest {
    
    private Long id;
    private static ApplicationContext ctx;
    private LicenseRepository repository;
    
    public LicenseRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreate()
    {
        repository = ctx.getBean(LicenseRepository.class);
        License license = new License();
        license.setCode(8);
        license.setExpiry_date(new Date());
        repository.save(license);
        id = license.getId();
        
        Assert.assertNotNull(license);
    }    
    
    @Test(dependsOnMethods = "testCreate", enabled = true)
    public void testRead()
    {
        repository = ctx.getBean(LicenseRepository.class);
        License license = repository.findOne(id);
        Assert.assertEquals(8, license.getCode());
    }
    
    @Test(dependsOnMethods = "testRead", enabled = true)
    public void testUpdate()
    {
        repository = ctx.getBean(LicenseRepository.class);
        License license = repository.findOne(id);
        
        license.setCode(14);
        license.setExpiry_date(new Date());
        
        repository.save(license);
        License new_license = repository.findOne(id);
        Assert.assertEquals(14, new_license.getCode());
    }
    
    @Test(dependsOnMethods = "testUpdate", enabled = true)
    public void testDelete()
    {
        repository = ctx.getBean(LicenseRepository.class);
        License license = repository.findOne(id);
        
        repository.delete(license);
        License deleted_license = repository.findOne(id);
        Assert.assertNull(deleted_license);
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
