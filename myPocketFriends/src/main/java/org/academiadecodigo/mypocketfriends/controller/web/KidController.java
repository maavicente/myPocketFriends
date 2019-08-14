package org.academiadecodigo.mypocketfriends.controller.web;


import org.academiadecodigo.mypocketfriends.converters.KidToKidDto;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.academiadecodigo.mypocketfriends.services.KidService;
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

@Controller
@RequestMapping("/customer")
public class KidController {

    private KidService kidService;
    private KidToKidDto kidToKidDto;
    private KidDtoToKid kidDtoToKid;
    private FriendToFriendDto friendToFriendDto;

    @Autowired
    public void setKidService(KidService kidService) {
        this.kidService = kidService;
    }

    @Autowired
    public void setKidToKidDto(KidToKidDto kidToKidDto) {
        this.kidToKidDto = kidToKidDto;
    }

    @Autowired
    public void setKidDtoToKid(KidDtoToKid kidDtoToKid) {
        this.kidDtoToKid = kidDtoToKid;
    }

    @Autowired
    public void setFriendToFriendDto(FriendToFriendDto friendToFriendDto) {
        this.friendToFriendDto = friendToFriendDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listCustomers(Model model) {
        model.addAttribute("customers", kidToKidDto.convert(kidService.list()));
        return "customer/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showCustomer(@PathVariable Integer id, Model model) throws Exception {

        Kid kid = kidService.get(id);

        // command objects for customer show view
        model.addAttribute("customer", kidToKidDto.convert(kid));
        model.addAttribute("accounts", friendToFriendDto.convert(kid.getAccounts()));
        model.addAttribute("friendTypes", FriendType.list());
        model.addAttribute("customerBalance", kidService.getBalance(id));


        model.addAttribute("friend", friendDto);

        return "kid/show";
    }

    /**
     * Saves the customer form submission and renders a view
     *
     * @param customerDto        the customer DTO object
     * @param bindingResult      the binding result object
     * @param redirectAttributes the redirect attributes object
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "customer/add-update";
        }

        Customer savedCustomer = kidService.save(kidDtoToKid.convert(customerDto));

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedCustomer.getFirstName() + " " + savedCustomer.getLastName());
        return "redirect:/customer/" + savedCustomer.getId();
    }

    /**
     * Cancels the customer submission and renders the default the customer view
     *
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=cancel")
    public String cancelSaveCustomer() {
        // we could use an anchor tag in the view for this, but we might want to do something clever in the future here
        return "redirect:/customer/";
    }

    /**
     * Deletes the customer and renders the default customer view
     *
     * @param id                 the customer id
     * @param redirectAttributes the redirect attributes object
     * @return the view to render
     * @throws AssociationExistsException
     * @throws CustomerNotFoundException
     */
    @RequestMapping(method = RequestMethod.GET, path = "{id}/delete")
    public String deleteCustomer(@PathVariable Integer id, RedirectAttributes redirectAttributes) throws AssociationExistsException, CustomerNotFoundException {
        Customer customer = kidService.get(id);
        kidService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted " + customer.getFirstName() + " " + customer.getLastName());
        return "redirect:/customer";
    }
}
