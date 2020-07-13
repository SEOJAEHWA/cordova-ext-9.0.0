package org.apache.cordova.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

public class CordovaSuccess {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private JsonElement data;

    private CordovaSuccess(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private CordovaSuccess(int code, String message, String data) {
        this.code = code;
        this.message = message;
        JsonElement parser = new JsonParser().parse(data);
        if (parser.isJsonObject() || parser.isJsonArray()) {
            this.data = parser;
        } else {
            throw new IllegalArgumentException("data is not JsonObject.");
        }
    }

    public static String getCordovaSuccess(int code) {
        return getCordovaSuccess(code, "");
    }

    public static String getCordovaSuccess(int code, String message) {
        return new Gson().toJson(new CordovaSuccess(code, message), CordovaSuccess.class);
    }

    public static String getCordovaSuccess(int code, String message, String data) {
        return new Gson().toJson(new CordovaSuccess(code, message, data), CordovaSuccess.class);
    }
}
