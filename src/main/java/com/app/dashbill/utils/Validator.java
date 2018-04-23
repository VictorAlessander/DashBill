package com.app.dashbill.utils;


import java.util.Objects;

public class Validator {

    public static boolean isNullOrEmpty(Object theClass) {
        if (Objects.isNull(theClass)) {
            return true;
        }

        return false;
    }
}
