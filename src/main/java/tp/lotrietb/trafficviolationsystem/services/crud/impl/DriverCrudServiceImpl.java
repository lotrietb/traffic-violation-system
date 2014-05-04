/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotrietb.trafficviolationsystem.services.crud.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.lotrietb.trafficviolationsystem.domain.Driver;
import tp.lotrietb.trafficviolationsystem.repository.DriverRepository;
import tp.lotrietb.trafficviolationsystem.services.crud.DriverCrudService;

/**
 *
 * @author Brandon1
 */
@Service
public class DriverCrudServiceImpl implements DriverCrudService{

    @Autowired
    private DriverRepository driverRepository;
    
    @Override
    public Driver find(Long id) {
        return driverRepository.findOne(id);
    }

    @Override
    public Driver persist(Driver entity) {
        return driverRepository.save(entity);
    }

    @Override
    public Driver merge(Driver entity) {
        return driverRepository.save(entity);
    }

    @Override
    public void remove(Driver entity) {
        driverRepository.delete(entity);
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }
    
}
