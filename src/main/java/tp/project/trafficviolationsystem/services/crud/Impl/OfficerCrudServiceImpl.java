/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.services.crud.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.project.trafficviolationsystem.domain.Officer;
import tp.project.trafficviolationsystem.repository.OfficerRepository;
import tp.project.trafficviolationsystem.services.crud.OfficerCrudService;

/**
 *
 * @author Brandon1
 */
@Service
public class OfficerCrudServiceImpl implements OfficerCrudService{

    @Autowired
    private OfficerRepository officerRepository;
    
    @Override
    public Officer find(Long id) {
        return officerRepository.findOne(id);
    }

    @Override
    public Officer persist(Officer entity) {
        return officerRepository.save(entity);
    }

    @Override
    public Officer merge(Officer entity) {
        return officerRepository.save(entity);
    }

    @Override
    public void remove(Officer entity) {
        officerRepository.delete(entity);
    }

    @Override
    public List<Officer> findAll() {
        return officerRepository.findAll();
    }
    
}
