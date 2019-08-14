package org.academiadecodigo.mypocketfriends.controller.web;

import org.academiadecodigo.mypocketfriends.command.MessageDto;
import org.academiadecodigo.mypocketfriends.converters.KidToKidDto;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.academiadecodigo.mypocketfriends.services.FriendServiceImpl;
import org.academiadecodigo.mypocketfriends.services.KidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class FriendController {

    private KidService kidService;
    private FriendServiceImpl friendService;
    private KidToKidDto kidToKidDto;

    @Autowired
    public void setCustomerService(KidService kidService) {
        this.kidService = kidService;
    }

    @Autowired
    public void setFriendService(FriendServiceImpl friendService) {
        this.friendService = friendService;
    }


    @Autowired
    public void setKidToKidDto(KidToKidDto kidToKidDto) {
        this.kidToKidDto = kidToKidDto;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"{cid}/friend/{fid}/message"})
    public String deposit(@PathVariable Integer cid, @PathVariable Integer fid, @Valid @ModelAttribute("message") Message message, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("failure", "Message not sent");
            return "redirect:/kid/" + cid;
        }

        kidService.addMessage(message.getId(), message);
        redirectAttributes.addFlashAttribute("lastAction", "Message: " + message.getMessage() + " was sent!");
        return "redirect:/" + cid;
    }



}
