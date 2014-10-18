/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.services.crud.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.project.trafficviolationsystem.domain.Fine;
import tp.project.trafficviolationsystem.repository.FineRepository;
import tp.project.trafficviolationsystem.services.crud.FineCrudService;

/**
 *
 * @author Brandon1
 */
@Service
public class FineCrudServiceImpl implements FineCrudService{

    @Autowired
    private FineRepository fineRepository;
    
    @Override
    public Fine find(Long id) {
        return fineRepository.findOne(id);
    }

    @Override
    public Fine persist(Fine entity) {
        return fineRepository.save(entity);
    }

    @Override
    public Fine merge(Fine entity) {
        return fineRepository.save(entity);
    }

    @Override
    public void remove(Fine entity) {
        fineRepository.delete(entity);
    }

    @Override
    public List<Fine> findAll() {
        return fineRepository.findAll();
    }
    
}
