package com.example.pakraden.Common;

import com.example.pakraden.Model.User;

public class Common {
    public static User currentUser;

    public static String convertCodeToStatus(String status) {
        if(status.equals("0"))
            return "Diterima";
        else if(status.equals("1"))
            return "Sedang dikirim";
        else
            return "Terkirim";
    }
}
