package com.rocktech.humanbodyorgan.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rocktech.humanbodyorgan.Organ;
import com.rocktech.humanbodyorgan.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static final String TAG = "Utils";
    public static final String DATABASE_NAME = "database";
    Context context;
    Activity activity;

    public Utils(Context context) {
        this.context = context;
    }

    public Utils(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void exitApp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.exit);
        builder.setMessage(R.string.exit_title);
        builder.setPositiveButton(R.string.yes, (dialogInterface, i) -> {
            activity.finish();
            activity.finishAffinity();
            System.exit(0);
        });
        builder.setNegativeButton(R.string.no, (dialogInterface, i) -> {
            // TODO: 9/11/2020 Cancel submission
        });
        builder.show();
    }

    private void initAllItems() {
        Log.d(TAG, "initAllItems: started");
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        List<Organ> organs = new ArrayList<>();

        organs.add(new Organ(1, activity.getResources().getString(R.string.arm), R.drawable.arm, activity.getResources().getString(R.string.arm_desc)));
        organs.add(new Organ(2, activity.
                getResources().getString(R.string.ear), R.drawable.ear, activity.getResources().getString(R.string.ear_desc)));
        organs.add(new Organ(3, activity.
                getResources().getString(R.string.elbow), R.drawable.elbow, activity.getResources().getString(R.string.elbow_desc)));
        organs.add(new Organ(4, activity.
                getResources().getString(R.string.foot), R.drawable.foot, activity.getResources().getString(R.string.foot_desc)));
        organs.add(new Organ(5, activity.
                getResources().getString(R.string.hand_wrist), R.drawable.wrist, activity.getResources().getString(R.string.hand_wrist_desc)));
        organs.add(new Organ(7, activity.
                getResources().getString(R.string.knuckle), R.drawable.knucle, activity.getResources().getString(R.string.knuckle_desc)));
        organs.add(new Organ(8, activity.
                getResources().getString(R.string.middle_finger), R.drawable.middle_finger, activity.getResources().getString(R.string.middle_finger)));
        organs.add(new Organ(9, activity.
                getResources().getString(R.string.palm), R.drawable.palm, activity.getResources().getString(R.string.palm_desc)));
        organs.add(new Organ(10, activity.
                getResources().getString(R.string.picky_finger), R.drawable.picky_finger, activity.getResources().getString(R.string.picky_finger_desc)));
        organs.add(new Organ(11, activity.
                getResources().getString(R.string.pointer_finger), R.drawable.pointer_finger, activity.getResources().getString(R.string.pointer_finger_desc)));
        organs.add(new Organ(12, activity.
                getResources().getString(R.string.ring_finger), R.drawable.ring_fin, activity.getResources().getString(R.string.ring_finger_desc)));
        organs.add(new Organ(13, activity.
                getResources().getString(R.string.teeth), R.drawable.teeth, activity.getResources().getString(R.string.teeth_desc)));
        organs.add(new Organ(14, activity.
                getResources().getString(R.string.thumb), R.drawable.thumb, activity.getResources().getString(R.string.thumb_desc)));


        organs.add(new Organ(1, activity.getResources().getString(R.string.face), R.drawable.face, activity.getResources().getString(R.string.face_desc)));
        organs.add(new Organ(2, activity.
                getResources().getString(R.string.scalp), R.drawable.scalp, activity.getResources().getString(R.string.scalp_desc)));
        organs.add(new Organ(3, activity.
                getResources().getString(R.string.forehead), R.drawable.forehead, activity.getResources().getString(R.string.forehead_desc)));
        organs.add(new Organ(4, activity.
                getResources().getString(R.string.mouth), R.drawable.mouth, activity.getResources().getString(R.string.mouth_desc)));
        organs.add(new Organ(5, activity.
                getResources().getString(R.string.eyes), R.drawable.eyes, activity.getResources().getString(R.string.eyes_desc)));
        organs.add(new Organ(6, activity.
                getResources().getString(R.string.eyelid), R.drawable.eyelid, activity.getResources().getString(R.string.eyelid_desc)));
        organs.add(new Organ(7, activity.
                getResources().getString(R.string.eyelash), R.drawable.eyelashes, activity.getResources().getString(R.string.eyelash_desc)));
        organs.add(new Organ(8, activity.
                getResources().getString(R.string.jaw), R.drawable.jaw, activity.getResources().getString(R.string.jaw_desc)));
        organs.add(new Organ(9, activity.
                getResources().getString(R.string.upper_arm), R.drawable.arm, activity.getResources().getString(R.string.upper_arm_desc)));
        organs.add(new Organ(11, activity.
                getResources().getString(R.string.fingernail), R.drawable.fingers, activity.getResources().getString(R.string.fingernail_desc)));
        organs.add(new Organ(13, activity.
                getResources().getString(R.string.ankle), R.drawable.ankle, activity.getResources().getString(R.string.ankle_desc)));
        organs.add(new Organ(14, activity.
                getResources().getString(R.string.heel), R.drawable.heel, activity.getResources().getString(R.string.heel_desc)));

        organs.add(new Organ(15, activity.
                getResources().getString(R.string.torso), R.drawable.torso, activity.getResources().getString(R.string.torso_desc)));
        organs.add(new Organ(16, activity.
                getResources().getString(R.string.abdomen), R.drawable.abdomen, activity.getResources().getString(R.string.abdomen_desc)));
        organs.add(new Organ(17, activity.
                getResources().getString(R.string.belly_button), R.drawable.bellybutton, activity.getResources().getString(R.string.belly_button_desc)));
        organs.add(new Organ(18, activity.
                getResources().getString(R.string.buttock), R.drawable.buttocks, activity.getResources().getString(R.string.buttock_desc)));


        organs.add(new Organ(19, activity.
                getResources().getString(R.string.head), R.drawable.head, activity.getResources().getString(R.string.head_desc)));
        organs.add(new Organ(20, activity.
                getResources().getString(R.string.neck), R.drawable.neck, activity.getResources().getString(R.string.neck_desc)));
        organs.add(new Organ(21, activity.
                getResources().getString(R.string.chest), R.drawable.chest, activity.getResources().getString(R.string.chest_desc)));
        organs.add(new Organ(22, activity.
                getResources().getString(R.string.shoulder), R.drawable.shoulder, activity.getResources().getString(R.string.shoulder_desc)));
        organs.add(new Organ(23, activity.
                getResources().getString(R.string.hand), R.drawable.hands, activity.getResources().getString(R.string.hand_desc)));
        organs.add(new Organ(24, activity.
                getResources().getString(R.string.wrist), R.drawable.wrist, activity.getResources().getString(R.string.wrist_desc)));
        organs.add(new Organ(25, activity.
                getResources().getString(R.string.finger), R.drawable.fingers, activity.getResources().getString(R.string.finger_desc)));
        organs.add(new Organ(26, activity.
                getResources().getString(R.string.thigh), R.drawable.thigh, activity.getResources().getString(R.string.thigh_desc)));
        organs.add(new Organ(27, activity.
                getResources().getString(R.string.knee), R.drawable.knee, activity.getResources().getString(R.string.knee_desc)));
        organs.add(new Organ(28, activity.
                getResources().getString(R.string.leg), R.drawable.leg, activity.getResources().getString(R.string.leg_desc)));
        organs.add(new Organ(29, activity.
                getResources().getString(R.string.toe), R.drawable.toe, activity.getResources().getString(R.string.toe_desc)));

        String finalList = gson.toJson(organs);
        editor.putString("allItems", finalList);
        editor.apply();
    }

    public void initDatabase() {
        Log.d(TAG, "initDatabase: Stored");
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME,
                Context.MODE_PRIVATE);

        Gson gson = new Gson();

        Type type = new TypeToken<List<Organ>>() {
        }.getType();

        List<Organ> possibleItems = gson.fromJson(
                sharedPreferences.getString("allItems", ""), type);

        if (possibleItems == null) {
            initAllItems();
        }

    }

    public List<Organ> searchForItem(String text) {
        Log.d(TAG, "searchForItem: ");

        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME,
                Context.MODE_PRIVATE);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Organ>>() {
        }.getType();
        List<Organ> items = gson.fromJson(sharedPreferences.getString("allItems", null)
                , type);

        List<Organ> searchItems = new ArrayList<>();

        if (null != items) {
            for (Organ item : items) {
                if (item.getTitle().equalsIgnoreCase(text)) {
                    searchItems.add(item);
                }

                String[] splittedString = item.getTitle().split(" ");
                for (String s : splittedString) {
                    if (s.equalsIgnoreCase(text)) {
                        boolean doesExist = false;
                        for (Organ searchItem : searchItems) {
                            if (searchItem.equals(item)) {
                                doesExist = true;
                            }
                        }
                        if (!doesExist) {
                            searchItems.add(item);
                        }
                    }
                }
            }
        }
        return searchItems;
    }
}
