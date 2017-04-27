/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Controllers;

import JollyOhtu.Objects.Inproceedings;
import JollyOhtu.Repository.InproceedingsRepository;
import JollyOhtu.Services.AuthenticationService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ritakosk
 */
@Controller
public class InproceedingsController {

    @Autowired
    private InproceedingsRepository inproRepo;

    @RequestMapping(value = "/add_inproceedings", method = GET)
    public String inproceedingsForm(Model model) {
        model.addAttribute("inproceedings", new Inproceedings());
        return "add_inproceedings";
    }

    @RequestMapping(value = "/add_inproceedings", method = POST)
    public String inproceedingsSubmit(@ModelAttribute Inproceedings inpro, Model model) {
        Boolean callIdRepeats = false;
        if(inpro.initCallId()){
            callIdRepeats = AuthenticationService.validateInproceedingsCallId(inpro, inproRepo);
        }
        List<String> errors = AuthenticationService.validateAddInproceedings(inpro, inproRepo);
        if (callIdRepeats){
            errors.add("There was an error with automatic ID generation, please enter one manually.");
        }
        if (errors.isEmpty()) {
            if (inproRepo.save(inpro) != null) {
                model.addAttribute("success", "Reference was saved successfully!");
                model.addAttribute("inproceedings", new Inproceedings());
            } else {
                errors.add("There was an error saving the reference. Reference not saved");
            }
        }
        model.addAttribute("errors", errors);
        
        return "add_inproceedings";
    }

  @RequestMapping(value = "/delete_inproceedings", method = POST)
    public String bookDeleteChecked(@RequestParam(value="del_inproceedings", required=false)ArrayList<String> del, 
            RedirectAttributes redirect) {
          
        List<String> errors = AuthenticationService.validateDeleteInproceedings(del);
        if (errors.isEmpty()) {
            for (String id : del) {
                inproRepo.delete(Long.parseLong(id));
            }
            if(del.size()==1){
                redirect.addFlashAttribute("success", "One inproceeding reference was deleted succesfully.");
            }else{
                redirect.addFlashAttribute("success", del.size()+" inproceeding references were deleted succesfully.");
            }
        }
        redirect.addFlashAttribute("errors", errors);
       return "redirect:/list_references";
    }

}
