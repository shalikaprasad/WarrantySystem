package com.sarc.service.impl;

import com.sarc.service.AlertService;
import com.sarc.service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationServiceImpl implements ValidationService {

    AlertService alertService = new AlertServiceImpl();
    @Override
    public boolean validate(String field, String value, String pattern) {
        if (!value.isEmpty()) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(value);
            if (m.find() && m.group().equals(value)) {
                return true;
            } else {
                alertService.validationAlert(field, false);
                return false;
            }
        } else {
            alertService.validationAlert(field, true);
            return false;
        }
    }

    @Override
    public boolean emptyValidation(String field, boolean empty) {
        if (!empty) {
            return true;
        } else {
            alertService.validationAlert(field, true);
            return false;
        }
    }

    @Override
    public boolean notcompare(String value1, String value2) {
        if(!value1.equals(value2)){
            alertService.validationAlert("Pass", false);
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean creditcard(String cardname, String cardnumber, String cardexpirer, String cardsecurity) {
        return true;
    }

}
