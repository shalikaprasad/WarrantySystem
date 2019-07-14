package com.sarc.service;

import com.twilio.sdk.TwilioRestException;

public interface SmsService {

    void sendSms(String image_url, String number, String cusname) throws TwilioRestException;
}
