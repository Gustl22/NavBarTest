package com.rebo.navbartest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

public class ThemePreferenceActivity extends PreferenceFragmentCompat {
    public static final int RESULT_CODE_THEME_UPDATED = 1;

    Activity mActivity;

    public void setContext(Activity activity){
        mActivity = activity;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        findPreference("theme").setOnPreferenceChangeListener(new RefershActivityOnPreferenceChangeListener(RESULT_CODE_THEME_UPDATED));
    }

    private class RefershActivityOnPreferenceChangeListener implements Preference.OnPreferenceChangeListener {
        private final int resultCode;
        public RefershActivityOnPreferenceChangeListener(int resultCode) {
            this.resultCode = resultCode;
        }

        @Override
        public boolean onPreferenceChange(Preference p, Object newValue) {
            //setResult(resultCode); // TODO
            if(newValue instanceof String)
                setTheme((String) newValue);
            mActivity.recreate();
            return true;
        }
    }

    public void setTheme(String themeValue){
        if ("light".equals(themeValue)) {
            mActivity.setTheme(R.style.AppTheme_Light);
        } else if ("dark".equals(themeValue)) {
            //Toast.makeText(this, "set theme", Toast.LENGTH_SHORT).show();
            mActivity.setTheme(R.style.AppTheme_Dark);
        } else {
            mActivity.setTheme(R.style.AppTheme);
        }
    }
}
