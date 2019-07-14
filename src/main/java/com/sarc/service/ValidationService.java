package com.sarc.service;


public interface ValidationService {

    boolean validate(String field, String value, String pattern);
    boolean emptyValidation(String field, boolean empty);
    boolean notcompare(String value1, String value2);
    boolean creditcard(String cardname, String cardnumber, String cardexpirer, String cardsecurity);
}
