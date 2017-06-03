package com.divyanshgoenka.todolist.util;

import java.util.Collection;

/**
 * Created by divyanshgoenka on 03/06/17.
 */

public class Validations {
    public static boolean isEmptyOrNull(Collection collection) {
        return collection != null && collection.size() < 1;
    }
}
