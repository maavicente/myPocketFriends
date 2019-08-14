package org.academiadecodigo.mypocketfriends.controller.web;


import org.academiadecodigo.mypocketfriends.converters.KidToKidDto;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.academiadecodigo.mypocketfriends.services.KidService;
import org.academiadecodigo.mypocketfriends.services.MessageService;
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
public class MessageController {

    private MessageService messageService;
    private KidService kidService;
    private MessageToMessageDto messageToMessageDto;
    private MessageDtoToMessage messageDtoToMessage;
    private KidToKidDto kidToKidDto;
    private FriendToFriendDto friendToFriendDto;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }


    @Autowired
    public void setKidService(KidService kidService) {
        this.kidService = kidService;
    }


    @Autowired
    public void setMessageToMessageDto(MessageToMessageDto messageToMessageDto) {
        this.messageToMessageDto = messageToMessageDto;
    }


    @Autowired
    public void setMessageDtoToMessage(MessageDtoToMessage messageDtoToMessage) {
        this.messageDtoToMessage = messageDtoToMessage;
    }

    @Autowired
    public void setKidToKidDto(KidToKidDto kidToKidDto) {
        this.kidToKidDto = kidToKidDto;
    }


    @Autowired
    public void setFriendToFriendDto(FriendToFriendDto friendToFriendDto) {
        this.friendToFriendDto = friendToFriendDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{cid}/recipient", "/{cid}/recipient/list"})
    public String listRecipients(@PathVariable Integer cid, Model model) {

        try {

            List<Message> recipients = kidService.listMessages(cid);
            Kid kid = kidService.get(cid);

            model.addAttribute("recipients", messageToMessageDto.convert(recipients));
            model.addAttribute("customer", kidToKidDto.convert(kid));
            model.addAttribute("accounts", friendToFriendDto.convert(kid.getFriends()));

            return "recipient/list";

        } catch (KidNotFoundException ex) {
            return "redirect:/";
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/recipient/add")
    public String addRecipient(@PathVariable Integer cid, Model model) {

        model.addAttribute("customer", kidToKidDto.convert(kidService.get(cid)));
        model.addAttribute("recipient", new MessageDto());

        return "recipient/add-update";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/recipient/{id}/edit")
    public String editRecipient(@PathVariable Integer cid, @PathVariable Integer id, Model model) {
        model.addAttribute("customer", kidToKidDto.convert(kidService.get(cid)));
        model.addAttribute("recipient", messageToMessageDto.convert(messageService.get(id)));
        return "recipient/add-update";
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/{cid}/recipient/", "/{cid}/recipient"}, params = "action=save")
    public String saveRecipient(Model model, @PathVariable Integer cid, @Valid @ModelAttribute("recipient") MessageDto messageDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        model.addAttribute("customer", kidToKidDto.convert(kidService.get(cid)));

        if (bindingResult.hasErrors()) {
            return "recipient/add-update";
        }

        try {

            Message message = messageDtoToMessage.convert(messageDto);
            kidService.addMessage(cid, message);

            redirectAttributes.addFlashAttribute("lastAction", "Saved " + messageDto.getName());
            return "redirect:/customer/" + cid + "/recipient";

        } catch (FriendNotFoundException ex) {

            bindingResult.rejectValue("accountNumber", "invalid.account", "invalid account number");
            return "recipient/add-update";

        } catch (KidNotFoundException ex) {

            return "redirect:/customer/" + cid;
        }
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/{cid}/recipient/", "/{cid}/recipient"}, params = "action=cancel")
    public String cancelSaveRecipient(@PathVariable Integer cid) {
        return "redirect:/customer/" + cid;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/recipient/{id}/delete")
    public String deleteRecipient(@PathVariable Integer cid, @PathVariable Integer id, RedirectAttributes redirectAttributes) throws Exception {
        Message message = messageService.get(id);
        kidService.removeMessage(cid, id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted " + message.getName());
        return "redirect:/customer/" + cid + "/recipient";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/recipient/transfer")
    public String transfer(@PathVariable Integer cid, Model model) {

        try {

            List<Message> recipients = kidService.listMessages(cid);
            Kid kid = kidService.get(cid);

            model.addAttribute("recipients", messageToMessageDto.convert(recipients));
            model.addAttribute("customer", kidToKidDto.convert(kid));
            model.addAttribute("accounts", friendToFriendDto.convert(kid.getAccounts()));
            model.addAttribute("transfer", new TransferDto());
            return "recipient/transfer";

        } catch (KidNotFoundException ex) {
            return "redirect:/customer/" + cid;
        }
    }


}
