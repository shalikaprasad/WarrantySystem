package com.sarc.service;

import com.sarc.bean.Sub_Company;

public interface AlertService {

   void saveAlert();
   void logAlert(String topic, boolean check);
   void updateAlert(Sub_Company sub_company);
   void validationAlert(String field, boolean empty);
   void showValueAlert(String value, boolean editable);
   void getDefaultAlert(String title, String body);
   void newAlert(String field, String method);
}
