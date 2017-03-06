package net.nitroshare.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import net.nitroshare.android.transfer.TransferService;

/**
 * Starts the transfer service upon boot (if enabled)
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        TransferService.startStopService(
                context,
                sharedPreferences.getBoolean(
                        context.getString(R.string.setting_behavior_receive),
                        true
                )
        );
    }
}
