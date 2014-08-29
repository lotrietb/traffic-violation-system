/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotrietb.trafficviolationsystem.presentation.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tp.lotrietb.trafficviolationsystem.domain.Driver;
import tp.lotrietb.trafficviolationsystem.domain.Fine;
import tp.lotrietb.trafficviolationsystem.repository.FineRepository;

/**
 *
 * @author Brandon1
 */
@Controller
@RequestMapping(value = "api/fines")
public class FineRestController {
    
    @Autowired
    private FineRepository fineRepository;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String createFine(@RequestBody Fine fine)
    {
        fineRepository.save(fine);
        return "Fine Created";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String updateFine(@RequestBody Fine fine)
    {
        fineRepository.save(fine);
        return "Fine Updated";
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Fine getFine(@PathVariable Long id)
    {
        Fine f = fineRepository.findOne(id);
        return f;
    }
    
    @RequestMapping(value = "fines",method = RequestMethod.GET)
    @ResponseBody
    public List<Fine> getFines()
    {
        List<Fine> fines = fineRepository.findAll();
        return fines;
    }
}
