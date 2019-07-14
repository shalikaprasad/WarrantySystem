package com.sarc.view;

import java.util.ResourceBundle;

public enum FxmlView {

    HOME {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("home.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/HomeUI.fxml";
        }
    },
    LOGIN {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    },
    FORGET {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("forget.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/ForgetPassword.fxml";
        }
    },
    INPUT {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("input.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/InputItem.fxml";
        }
    },
    CUSTOMER {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("customer.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Customer.fxml";
        }
    };

    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
