/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotrietb.trafficviolationsystem.services.crud.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.lotrietb.trafficviolationsystem.domain.Audit_fines;
import tp.lotrietb.trafficviolationsystem.repository.AuditFinesRepository;
import tp.lotrietb.trafficviolationsystem.services.crud.Audit_FinesCrudService;

/**
 *
 * @author Brandon1
 */
@Service
public class Audit_FinesCrudServiceImpl implements Audit_FinesCrudService{

    @Autowired
    private AuditFinesRepository auditFinesRepository;

    @Override
    public Audit_fines find(Long id) {
        return auditFinesRepository.findOne(id);
    }

    @Override
    public Audit_fines persist(Audit_fines entity) {
        return auditFinesRepository.save(entity);
    }

    @Override
    public Audit_fines merge(Audit_fines entity) {
        return auditFinesRepository.save(entity);
    }

    @Override
    public void remove(Audit_fines entity) {
        auditFinesRepository.delete(entity);
    }

    @Override
    public List<Audit_fines> findAll() {
        return auditFinesRepository.findAll();
    }
    
    
    
}
