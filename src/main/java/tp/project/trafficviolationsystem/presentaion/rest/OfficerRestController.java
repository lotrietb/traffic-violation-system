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
import tp.project.trafficviolationsystem.domain.Fine;
import tp.project.trafficviolationsystem.domain.Officer;
import tp.project.trafficviolationsystem.repository.OfficerRepository;

/**
 *
 * @author Brandon1
 */
@Controller
@RequestMapping(value = "api/officer")
public class OfficerRestController {
    
    @Autowired
    private OfficerRepository officerRepository;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String createOfficer(@RequestBody Officer officer)
    {
        officerRepository.save(officer);
        return "Officer Created";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String updateOfficer(@RequestBody Officer officer)
    {
        officerRepository.save(officer);
        return "Fine Updated";
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Officer getOfficer(@PathVariable Long id)
    {
        Officer o = officerRepository.findOne(id);
        return o;
    }
    
    @RequestMapping(value = "officers",method = RequestMethod.GET)
    @ResponseBody
    public List<Officer> getOfficers()
    {
        List<Officer> officer = officerRepository.findAll();
        return officer;
    }
}
