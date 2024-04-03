package com.vietphuongdo.schoolmanagement.service;

import com.vietphuongdo.schoolmanagement.model.Contact;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
@Slf4j
public class ContactService {
    private int counter = 0;
    public boolean sendMessageDetail(Contact contact){
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }

}
