package com.install.install;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class InstallPlugin extends CordovaPlugin {
    public static String ACTION = "Install";

    public boolean execute(String action, JSONArray data,
            CallbackContext callbackContext) throws JSONException {
        if (ACTION.equals(action)) {
            installAPK(data.getString(0),  callbackContext);
        }
        return false;
    }

    public synchronized void installAPK(final String str,CallbackContext callbackContext) {
        final CordovaInterface cordova = this.cordova;
        Runnable runnable = new Runnable() {
            public void run() {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
                cordova.getActivity().startActivity(intent); //DO NOT forget
            }
        };
         this.cordova.getActivity().runOnUiThread(runnable);
    }
}
