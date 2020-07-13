package org.apache.cordova;

import android.content.Context;
import android.util.Log;

import org.apache.cordova.data.CordovaError;
import org.apache.cordova.data.CordovaSuccess;
import org.json.JSONArray;
import org.json.JSONException;

public abstract class BaseCordovaPlugin extends CordovaPlugin {

    private static final String TAG = BaseCordovaPlugin.class.getSimpleName();

    private static final int SUCCESS_CODE = 1000;

    protected String action;
    private CallbackContext callback;

    public abstract boolean execute(JSONArray args) throws JSONException;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "[CordovaPlugin] action: " + action);
        this.action = action;
        this.callback = callbackContext;

        if (!execute(args)) {
            sendErrorCallback(8001, "알 수 없는 플러그인 실행 요청입니다. [" + action + "]");
        }
        return true;
    }

    @SuppressWarnings("SameParameterValue")
    public void sendSuccessCallback() {
        this.callback.success(CordovaSuccess.getCordovaSuccess(SUCCESS_CODE));
    }

    @SuppressWarnings("SameParameterValue")
    public void sendSuccessCallback(String message) {
        this.callback.success(CordovaSuccess.getCordovaSuccess(SUCCESS_CODE, message));
    }

    @SuppressWarnings("SameParameterValue")
    public void sendSuccessCallback(String message, String data) {
        this.callback.success(CordovaSuccess.getCordovaSuccess(SUCCESS_CODE, message, data));
    }

    @SuppressWarnings("SameParameterValue")
    public void sendErrorCallback(int code, String message) {
        this.callback.error(CordovaError.getCordovaError(code, message));
    }

    @SuppressWarnings("SameParameterValue")
    public void sendErrorCallback(int code, String message, String data) {
        this.callback.error(CordovaError.getCordovaError(code, message, data));
    }

    public CordovaExtActivity getActivity() {
        if (cordova.getActivity() instanceof CordovaExtActivity) {
            return (CordovaExtActivity) cordova.getActivity();
        }
        return null;
    }

    public Context getContext() {
        return cordova.getContext();
    }

    public String getAction() {
        return action;
    }
}
