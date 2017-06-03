package com.divyanshgoenka.todolist.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.divyanshgoenka.todolist.services.ToDoRefreshService;

import static android.content.Context.ALARM_SERVICE;

/**
 * Triggers the service that polls for changes to the To Do List
 */
public class ToDoListBootReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase(
                Intent.ACTION_BOOT_COMPLETED)) {
            Intent i = new Intent(context, ToDoRefreshService.class);
            PendingIntent pi = PendingIntent.getService(context, 0, i, 0);
            AlarmManager am = (AlarmManager) context.getSystemService(ALARM_SERVICE);
            am.cancel(pi); // cancel any existing alarms
            am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_HALF_HOUR,
                    AlarmManager.INTERVAL_HALF_HOUR, pi);

        }
    }
}
