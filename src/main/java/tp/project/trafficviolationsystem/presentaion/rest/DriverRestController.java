/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.presentation.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tp.project.trafficviolationsystem.domain.Driver;
import tp.project.trafficviolationsystem.repository.DriverRepository;

/**
 *
 * @author Brandon1
 */
@Controller
@RequestMapping(value = "api/driver")
public class DriverRestController {
    
    @Autowired
    private DriverRepository driverRepository;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String createDriver(@RequestBody Driver driver)
    {
        driverRepository.save(driver);
        return "Driver Created";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String updateDriver(@RequestBody Driver driver)
    {
        driverRepository.save(driver);
        return "Driver Updated";
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Driver getDriver(@PathVariable Long id)
    {
        Driver d = driverRepository.findOne(id);
        return d;
    }
    
    @RequestMapping(value = "drivers",method = RequestMethod.GET)
    @ResponseBody
    public List<Driver> getDrivers()
    {
        List<Driver> drivers = driverRepository.findAll();
        return drivers;
    }
}
