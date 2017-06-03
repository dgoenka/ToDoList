package com.divyanshgoenka.todolist.util;

import android.content.BroadcastReceiver;
import android.content.Context;

/**
 * Created by divyanshgoenka on 03/06/17.
 */

public class ComponentHelper {

    public static void unregisterSafely(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception ignored) {
        }
    }
}
