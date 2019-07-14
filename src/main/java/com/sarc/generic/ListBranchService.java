package com.sarc.generic;

import com.sarc.bean.Head_Company;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListBranchService {

    public ObservableList<String> getBranch(String companyName) {

        if(companyName.equals("Singer") || companyName.equals("singer") || companyName.equals("SINGER")){
           return FXCollections.observableArrayList(
                    "Horana",
                    "Colombo",
                    "Kelaniya",
                    "Gampaha",
                    "Anuradhapura",
                    "Galle",
                    "Hambantota",
                    "Jaffna",
                    "Kandy",
                    "Kurunegala",
                    "Matara",
                    "Monaragala",
                    "Nuwara Eliya"
            );
        }else if(companyName.equals("LG") || companyName.equals("lg") || companyName.equals("Lg")){
            return FXCollections.observableArrayList(
                    "Horana",
                    "Colombo",
                    "Kelaniya",
                    "Gampaha",
                    "Anuradhapura",
                    "Galle",
                    "Hambantota",
                    "Jaffna",
                    "Kandy",
                    "Kurunegala",
                    "Matara",
                    "Monaragala",
                    "Nuwara Eliya"
            );
        }
        else {
            return FXCollections.observableArrayList(
                    "Colombo"
            );
        }
    }




}
