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
import tp.lotrietb.trafficviolationsystem.domain.Audit_fines;
import tp.lotrietb.trafficviolationsystem.services.crud.Audit_FinesCrudService;

/**
 *
 * @author Brandon1
 */
public class Audit_finesCrudTest {
    private static ApplicationContext ctx;
    private Long id;
    private Audit_FinesCrudService audit_FinesCrudService;
    public Audit_finesCrudTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createAuditFine() 
    {   
        audit_FinesCrudService = ctx.getBean(Audit_FinesCrudService.class);
        Audit_fines audit_fines = new Audit_fines();
        audit_fines.setUser_id(new Long("1"));
        audit_fines.setAmount_before(500.00);
        audit_fines.setAmount_after(300.00);
        audit_fines.setDate_changed(new Date());
        audit_fines.setFine_no(new Long("85698"));
        Audit_fines persisted_audit_fines = audit_FinesCrudService.persist(audit_fines);
        id = persisted_audit_fines.getId();
        
        Assert.assertEquals(audit_fines, persisted_audit_fines);
    }
    
    @Test(dependsOnMethods = "createAuditFine")
    public void readAuditFine() 
    {   
        audit_FinesCrudService = ctx.getBean(Audit_FinesCrudService.class);
        Audit_fines audit_fines = audit_FinesCrudService.find(id);
        
        Assert.assertEquals(audit_fines.getFine_no(), new Long("85698"));
    }
    
    @Test(dependsOnMethods = "readAuditFine")
    public void updateAuditFine() 
    {   
        audit_FinesCrudService = ctx.getBean(Audit_FinesCrudService.class);
        Audit_fines audit_fines = audit_FinesCrudService.find(id);
        Long new_fine_no = new Long("321456");
        audit_fines.setFine_no(new_fine_no);
        Audit_fines af = audit_FinesCrudService.merge(audit_fines);
        
        Assert.assertEquals(af.getFine_no(), audit_fines.getFine_no());
    }
    
    @Test(dependsOnMethods = "updateAuditFine")
    public void removeAuditFine() 
    {   
        audit_FinesCrudService = ctx.getBean(Audit_FinesCrudService.class);
        Audit_fines audit_fines = audit_FinesCrudService.find(id);
        audit_FinesCrudService.remove(audit_fines);
        
        Audit_fines new_audit_fines = audit_FinesCrudService.find(id);

        Assert.assertNull(new_audit_fines);
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
