package com.example.criminalintent;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab instance;

    private List<Crime> crimes;

    private CrimeLab(Context context) {
        crimes = new ArrayList<>();
         for (int i = 0; i < 100; i++) {
             Crime crime = new Crime();
             crime.setTitle("Crime #" + i);
             crime.setSolved(i % 2 == 0);
             crimes.add(crime);
         }
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public static CrimeLab getInstance(Context context) {
        if(instance == null) {
            instance = new CrimeLab(context);
        }
        return instance;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : crimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }

}
