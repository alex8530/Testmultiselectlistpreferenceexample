package com.example.testmultiselectlistpreferenceexample;

import android.os.Bundle;

import androidx.preference.MultiSelectListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;


public class SettingsFragment extends PreferenceFragmentCompat {


    public SettingsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        String[] colorsListKeys = new String[]{"red_key", "yellow_key", "blue_key"};
        String[] colorsListValues = new String[]{"red", "yellow", "blue"};

        MultiSelectListPreference multiSelectListPreference = new MultiSelectListPreference(getActivity());
        multiSelectListPreference.setKey(ConstantOfApp.MULTI_SELECT_LIST_KEY);
        multiSelectListPreference.setTitle("Choose The Colors");
        multiSelectListPreference.setSummary("you can choose the colors from here");
        multiSelectListPreference.setEntries(colorsListKeys);
        multiSelectListPreference.setEntryValues(colorsListValues);


        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(getActivity());
        screen.addPreference(multiSelectListPreference);
        this.setPreferenceScreen(screen);
    }
}