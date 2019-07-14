package com.sarc.service;


import com.twilio.sdk.TwilioRestException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailService {

    String sendEmail(String email);
    void sendEmailImage(String email, String image) throws AddressException, MessagingException;
    //void checkUserSelection(boolean checkEmail, boolean checkSMS, String email, String serial, String sharableLink, String phone, String name) throws TwilioRestException, MessagingException;
}
