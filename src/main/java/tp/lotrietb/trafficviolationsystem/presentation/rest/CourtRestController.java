/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotrietb.trafficviolationsystem.presentation.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tp.lotrietb.trafficviolationsystem.app.conf.ConnectionConfig;
import tp.lotrietb.trafficviolationsystem.domain.Court;
import tp.lotrietb.trafficviolationsystem.repository.CourtRepository;
import tp.lotrietb.trafficviolationsystem.services.crud.CourtCrudService;

/**
 *
 * @author Brandon1
 */
@Controller
@RequestMapping(value = "api/court")
public class CourtRestController {
    
    @Autowired
    private CourtRepository courtRepository;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String createCourt(@RequestBody Court court)
    {
        courtRepository.save(court);
        return "Court Created";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String updateCourt(@RequestBody Court court)
    {
        courtRepository.save(court);
        return "";
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Court getCourt(@PathVariable Long id)
    {
        Court c = courtRepository.findOne(id);
        return c;
    }
    
    @RequestMapping(value = "courts",method = RequestMethod.GET)
    @ResponseBody
    public List<Court> getCourts()
    {
        List<Court> courts = courtRepository.findAll();
        return courts;
    }
}
