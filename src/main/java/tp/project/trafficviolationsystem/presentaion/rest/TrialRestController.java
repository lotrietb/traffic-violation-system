/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.presentation.rest;

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
import tp.project.trafficviolationsystem.app.conf.ConnectionConfig;
import tp.project.trafficviolationsystem.domain.Trial;
import tp.project.trafficviolationsystem.repository.TrialRepository;
import tp.project.trafficviolationsystem.services.crud.TrialCrudService;

/**
 *
 * @author Brandon1
 */
@Controller
@RequestMapping(value = "api/trial")
public class TrialRestController {
    
    @Autowired
    private TrialRepository trialRepository;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String createCourt(@RequestBody Trial trial)
    {
        trialRepository.save(trial);
        return "Court Created";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String updateTrial(@RequestBody Trial trial)
    {
        trialRepository.save(trial);
        return "";
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Trial getTrial(@PathVariable Long id)
    {
        Trial t = trialRepository.findOne(id);
        return t;
    }
    
    @RequestMapping(value = "courts",method = RequestMethod.GET)
    @ResponseBody
    public List<Trial> getCourts()
    {
        List<Trial> trials = trialRepository.findAll();
        return trials;
    }
}
