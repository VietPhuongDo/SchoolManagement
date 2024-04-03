package com.vietphuongdo.schoolmanagement.controller;

import com.vietphuongdo.schoolmanagement.model.Contact;
import com.vietphuongdo.schoolmanagement.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;



@Controller
@Slf4j
@RequestScope
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact",new Contact());
        return "contact";
    }

    @PostMapping(value = "/saveMsg")
    public String sendMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if (errors.hasErrors()){
            log.error("contact failed due to"+errors.toString());
            return "contact";
        }
        contactService.sendMessageDetail(contact);
        contactService.setCounter(contactService.getCounter()+1);
        log.info("Number of times the Contact form is submitted : "+contactService.getCounter());
        return "redirect:/contact";
    }
}
