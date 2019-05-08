package com.rebo.navbartest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String themeValue = pref.getString("theme", "default");
        ThemePreferenceActivity themePreferenceActivity = new ThemePreferenceActivity();
        themePreferenceActivity.setContext(this);
        themePreferenceActivity.setTheme(themeValue);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.preferences_fragment, themePreferenceActivity)
                .commit();
    }
}
