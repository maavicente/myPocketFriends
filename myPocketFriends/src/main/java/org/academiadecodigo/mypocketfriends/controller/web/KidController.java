package org.academiadecodigo.mypocketfriends.controller.web;


import org.academiadecodigo.mypocketfriends.command.KidDto;
import org.academiadecodigo.mypocketfriends.converters.KidToKidDto;
import org.academiadecodigo.mypocketfriends.services.KidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/kid")
public class KidController {

    private KidService kidService;
    private KidToKidDto kidToKidDto;


    @Autowired
    public void setKidService(KidService kidService) {
        this.kidService = kidService;
    }

    @Autowired
    public void setKidToKidDto(KidToKidDto kidToKidDto) {
        this.kidToKidDto = kidToKidDto;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{cid}")
    public String showKid(@PathVariable Integer cid, Model model) throws Exception {

        KidDto kid = kidService.getKid(cid);

        model.addAttribute("kid", kid);
        model.addAttribute("friends", kid.getFriends());

        return "kid/show";
    }


   /* @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "customer/add-update";
        }

        Customer savedCustomer = kidService.save(kidDtoToKid.convert(customerDto));

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedCustomer.getFirstName() + " " + savedCustomer.getLastName());
        return "redirect:/customer/" + savedCustomer.getId();
    }*/

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
