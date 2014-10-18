/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tp.project.trafficviolationsystem.domain.Trial;
import tp.project.trafficviolationsystem.services.crud.TrialCrudService;

/**
 *
 * @author Brandon1
 */
@Controller
public class CourtController {
    
    @Autowired
    private TrialCrudService trialCrudService;
    
    @RequestMapping(value = "courts",method = RequestMethod.GET)
    @ResponseBody
    public List<Trial> getCourts()
    {
        return trialCrudService.findAll();
    }
}
