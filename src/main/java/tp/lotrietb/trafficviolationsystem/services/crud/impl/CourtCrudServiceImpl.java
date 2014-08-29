/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotrietb.trafficviolationsystem.services.crud.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tp.lotrietb.trafficviolationsystem.domain.Court;
import tp.lotrietb.trafficviolationsystem.repository.CourtRepository;
import tp.lotrietb.trafficviolationsystem.services.crud.CourtCrudService;

/**
 *
 * @author Brandon1
 */
@Service
public class CourtCrudServiceImpl implements CourtCrudService{

    @Autowired
    private CourtRepository courtRepository;
    
    @Override
    public Court find(Long id) {
        return courtRepository.findOne(id);
    }

    @Override
    public Court persist(Court entity) {
        return courtRepository.save(entity);
    }

    @Override
    public Court merge(Court entity) {
        return courtRepository.save(entity);
    }

    @Override
    public void remove(Court entity) {
        courtRepository.delete(entity);
    }

    @Override
    public List<Court> findAll() {
        return courtRepository.findAll();
    }
    
}
