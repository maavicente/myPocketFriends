package org.academiadecodigo.mypocketfriends.controller.web;

import org.academiadecodigo.mypocketfriends.model.Friend;
import org.academiadecodigo.mypocketfriends.services.FriendService;
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
@RequestMapping("/customer")
public class FriendController {

    private KidService kidService;
    private FriendService friendService;
    private FriendDtoToFriend friendDtoToFriend;
    private KidToKidDto customerToCustomerDto;


    @Autowired
    public void setCustomerService(KidService kidService) {
        this.kidService = kidService;
    }


    @Autowired
    public void setFriendService(FriendService friendService) {
        this.friendService = friendService;
    }


    @Autowired
    public void setFriendDtoToFriend(FriendDtoToFriend friendDtoToFriend) {
        this.friendDtoToFriend = friendDtoToFriend;
    }


    @Autowired
    public void setKidToKidDto(KidToKidDto kidToKidDto) {
        this.customerToCustomerDto = kidToKidDto;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/{cid}/account"})
    public String addAccount(@PathVariable Integer cid, @Valid @ModelAttribute("account") FriendDto friendDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {

        if (bindingResult.hasErrors()) {
            return "redirect:/customer/" + cid;
        }

        try {
            Friend friend = friendDtoToFriend.convert(friendDto);
            KidService.addAccount(cid, friend);
            redirectAttributes.addFlashAttribute("lastAction", "Created " + friend.getFriendType() + " account.");
            return "redirect:/customer/" + cid;

        } catch (TransactionInvalidException ex) {
            redirectAttributes.addFlashAttribute("failure", "Savings account must have a minimum value of 100 at all times");
            return "redirect:/customer/" + cid;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/{cid}/deposit"})
    public String deposit(@PathVariable Integer cid, @Valid @ModelAttribute("transaction") FriendTransactionDto friendTransactionDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("failure", "Deposit failed missing information");
            return "redirect:/customer/" + cid;
        }

        friendService.deposit(friendTransactionDto.getId(), cid, Double.parseDouble(friendTransactionDto.getAmount()));
        redirectAttributes.addFlashAttribute("lastAction", "Deposited " + friendTransactionDto.getAmount() + " into account # " + friendTransactionDto.getId());
        return "redirect:/customer/" + cid;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/{cid}/withdraw"})
    public String withdraw(@PathVariable Integer cid, @Valid @ModelAttribute("transaction") FriendTransactionDto friendTransactionDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {

        if (bindingResult.hasErrors()) {
            //this message appears when the form is submitted with value blank
            redirectAttributes.addFlashAttribute("failure", "Withdraw failed missing information");
            return "redirect:/customer/" + cid;
        }

        try {
            friendService.withdraw(friendTransactionDto.getId(), cid, Double.parseDouble(friendTransactionDto.getAmount()));
            redirectAttributes.addFlashAttribute("lastAction", "Withdrew " + friendTransactionDto.getAmount() + " from account # " + friendTransactionDto.getId());
            return "redirect:/customer/" + cid;

        } catch (TransactionInvalidException ex) {
            redirectAttributes.addFlashAttribute("failure", "Withdraw failed. " + friendTransactionDto.getAmount() + " is over the current balance for account # " + friendTransactionDto.getId());
            return "redirect:/customer/" + cid;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/account/{aid}/close")
    public String closeAccount(@PathVariable Integer cid, @PathVariable Integer aid, RedirectAttributes redirectAttributes) throws Exception {

        try {
            kidService.closeAccount(cid, aid);
            redirectAttributes.addFlashAttribute("lastAction", "Closed account " + aid);
            return "redirect:/customer/" + cid;

        } catch (TransactionInvalidException ex) {
            redirectAttributes.addFlashAttribute("failure", "Unable to perform closing operation. Account # " + aid + " still has funds");
            return "redirect:/customer/" + cid;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/{cid}/transfer"})
    public String transferToAccount(@PathVariable Integer cid, @Valid @ModelAttribute("transfer") TransferDto transferDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("failure", "Transfer failed missing information");
            return "redirect:/customer/" + cid;
        }

        try {
            transferService.transfer(transferDtoToTransfer.convert(transferDto), cid);
            redirectAttributes.addFlashAttribute("lastAction", "Account # " + transferDto.getSrcId() + " transfered " + transferDto.getAmount() + " to account #" + transferDto.getDstId());
            return "redirect:/customer/" + cid;

        } catch (TransactionInvalidException ex) {
            redirectAttributes.addFlashAttribute("failure", "Unable to perform transaction: value above the allowed amount");
            return "redirect:/customer/" + cid;
        }
    }
}
