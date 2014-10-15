/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.project.trafficviolationsystem.test.repository;

import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tp.project.trafficviolationsystem.app.conf.ConnectionConfig;
import tp.project.trafficviolationsystem.domain.Driver;
import tp.project.trafficviolationsystem.domain.Fine;
import tp.project.trafficviolationsystem.domain.License;
import tp.project.trafficviolationsystem.repository.DriverRepository;

/**
 *
 * @author Hannes
 */
public class DriverRepoTest {
    private Long id;
    private static ApplicationContext ctx;
    private DriverRepository repo;
    
    public DriverRepoTest() {

    }
    
    @Test
    public void testCreate() {
    
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
