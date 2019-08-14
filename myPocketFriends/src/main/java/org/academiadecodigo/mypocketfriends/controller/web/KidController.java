package org.academiadecodigo.mypocketfriends.controller.web;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;

import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.academiadecodigo.mypocketfriends.services.KidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/kid")
public class KidController {

    private KidServiceImpl kidService;
    //private KidToKidDto kidToKidDto;


    @Autowired
    public void setKidServiceImpl(KidServiceImpl kidService) {
        this.kidService = kidService;
    }

/*    @Autowired
    public void setKidToKidDto(KidToKidDto kidToKidDto) {
        this.kidToKidDto = kidToKidDto;
    }*/


    @RequestMapping(method = RequestMethod.GET, path = "/{cid}")
    public String showKid(@PathVariable Integer cid, Model model) {

        Kid kid = kidService.getKid(cid);

        model.addAttribute("kid", kid);
        model.addAttribute("friends", kid.getFriendAbs());
        model.addAttribute("message", kidService.getMessages());

        return "kid/show";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Message());
        return "kid/add-update";
    }

/*    @RequestMapping(method = RequestMethod.GET, path = "/{cid}")
    public String showMessage(@PathVariable Integer cid, Model model) {

        Kid kid = kidService.getKid(cid);
        List<Message> message = kid.getMessages();

        model.addAttribute("kid", kid);
        model.addAttribute("message", message);

        return "kid/show";
    }*/


    @RequestMapping(method = RequestMethod.POST, path = {"/{cid}"}, params = "action=save")
    public String saveCustomer(@ModelAttribute("customer") Message message, RedirectAttributes redirectAttributes) {

        kidService.addMessage(message);

        redirectAttributes.addFlashAttribute("lastAction", "Saved ");
        return "redirect:0";
    }

/*    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=cancel")
    public String cancelSaveCustomer() {
        // we could use an anchor tag in the view for this, but we might want to do something clever in the future here
        return "redirect:/customer/";
    }*/

/*
    @RequestMapping(method = RequestMethod.GET, path = "{id}/delete")
    public String deleteCustomer(@PathVariable Integer id, RedirectAttributes redirectAttributes) throws AssociationExistsException, CustomerNotFoundException {
        Customer customer = kidService.get(id);
        kidService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted " + customer.getFirstName() + " " + customer.getLastName());
        return "redirect:/customer";
    }*/
}
