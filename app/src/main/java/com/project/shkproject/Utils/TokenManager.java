package com.project.shkproject.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenManager {
    private static final String PREF_NAME = "MyPrefs";
    private static final String JWT_TOKEN_KEY = "jwt_token";

    private static TokenManager instance;
    private final SharedPreferences preferences;

    private TokenManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized TokenManager getInstance(Context context) {
        if (instance == null) {
            instance = new TokenManager(context.getApplicationContext());
        }
        return instance;
    }

    public void saveToken(String token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(JWT_TOKEN_KEY, token);
        editor.apply();
    }

    public String getToken() {
        return preferences.getString(JWT_TOKEN_KEY, null);
    }

    public void clearToken() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(JWT_TOKEN_KEY);
        editor.apply();
    }
}
