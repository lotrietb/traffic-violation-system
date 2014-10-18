/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.services.crud.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import tp.project.trafficviolationsystem.domain.Trial;
import tp.project.trafficviolationsystem.repository.TrialRepository;
import tp.project.trafficviolationsystem.services.crud.TrialCrudService;

/**
 *
 * @author Clive
 */
public class TrialCrudServiceImpl implements TrialCrudService{
    
    @Autowired
    private TrialRepository trialRepository;
    @Override
    public Trial find(Long id) {
        return trialRepository.findOne(id);
    }

    @Override
    public Trial persist(Trial entity) {
        return trialRepository.save(entity);
    }

    @Override
    public Trial merge(Trial entity) {
        return trialRepository.save(entity);
    }

    @Override
    public void remove(Trial entity) {
        trialRepository.delete(entity);
    }

    @Override
    public List<Trial> findAll() {
        return trialRepository.findAll();
    }
    
}
