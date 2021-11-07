package com.rocktech.humanbodyorgan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.rocktech.humanbodyorgan.model.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BodyActivity extends AppCompatActivity {
    RecyclerView recycler;
    BodyAdapter adapter;
    List<Organ> organs;
    Language language;
    Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utils = new Utils(this, this);
        language = new Language(this, this);
        language.loadLocale();
        setContentView(R.layout.activity_body);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        recycler = findViewById(R.id.recycler);
        organs = new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(this));

        organs.add(new Organ(1, getString(R.string.arm), R.drawable.arm, getString(R.string.arm_desc)));
        organs.add(new Organ(2, getString(R.string.ear), R.drawable.ear, getString(R.string.ear_desc)));
        organs.add(new Organ(3, getString(R.string.elbow), R.drawable.elbow, getString(R.string.elbow_desc)));
        organs.add(new Organ(4, getString(R.string.foot), R.drawable.foot, getString(R.string.foot_desc)));
        organs.add(new Organ(5, getString(R.string.hand_wrist), R.drawable.wrist, getString(R.string.hand_wrist_desc)));
        organs.add(new Organ(7, getString(R.string.knuckle), R.drawable.knucle, getString(R.string.knuckle_desc)));
        organs.add(new Organ(8, getString(R.string.middle_finger), R.drawable.middle_finger, getString(R.string.middle_finger_desc)));
        organs.add(new Organ(9, getString(R.string.palm), R.drawable.palm, getString(R.string.arm_desc)));
        organs.add(new Organ(10, getString(R.string.picky_finger), R.drawable.picky_finger, getString(R.string.picky_finger_desc)));
        organs.add(new Organ(11, getString(R.string.pointer_finger), R.drawable.pointer_finger, getString(R.string.pointer_finger_desc)));
        organs.add(new Organ(12, getString(R.string.ring_finger), R.drawable.ring_fin, getString(R.string.ring_finger_desc)));
        organs.add(new Organ(13, getString(R.string.teeth), R.drawable.teeth, getString(R.string.teeth_desc)));
        organs.add(new Organ(14, getString(R.string.thumb), R.drawable.thumb, getString(R.string.thumb_desc)));

        //
        organs.add(new Organ(15, getString(R.string.face), R.drawable.face, getString(R.string.face_desc)));
        organs.add(new Organ(16, getString(R.string.scalp), R.drawable.scalp, getString(R.string.scalp_desc)));
        organs.add(new Organ(17, getString(R.string.forehead), R.drawable.forehead, getString(R.string.forehead_desc)));
        organs.add(new Organ(18, getString(R.string.mouth), R.drawable.mouth, getString(R.string.mouth_desc)));
        organs.add(new Organ(19, getString(R.string.eyes), R.drawable.eyes, getString(R.string.eyes_desc)));
        organs.add(new Organ(20, getString(R.string.eyelid), R.drawable.eyelid, getString(R.string.eyelid_desc)));
        organs.add(new Organ(21, getString(R.string.eyelash), R.drawable.eyelashes, getString(R.string.eyelash_desc)));
        organs.add(new Organ(22, getString(R.string.jaw), R.drawable.jaw, getString(R.string.jaw_desc)));
        organs.add(new Organ(23, getString(R.string.upper_arm), R.drawable.arm, getString(R.string.upper_arm_desc)));
        organs.add(new Organ(25, getString(R.string.fingernail), R.drawable.fingers, getString(R.string.fingernail_desc)));
        organs.add(new Organ(27, getString(R.string.ankle), R.drawable.ankle, getString(R.string.ankle_desc)));
        organs.add(new Organ(28, getString(R.string.heel), R.drawable.heel, getString(R.string.heel_desc)));
        organs.add(new Organ(29, getString(R.string.torso), R.drawable.torso, getString(R.string.torso_desc)));
        organs.add(new Organ(30, getString(R.string.abdomen), R.drawable.abdomen, getString(R.string.abdomen_desc)));
        organs.add(new Organ(31, getString(R.string.belly_button), R.drawable.bellybutton, getString(R.string.belly_button_desc)));
        organs.add(new Organ(32, getString(R.string.buttock), R.drawable.buttocks, getString(R.string.buttock_desc)));

        organs.add(new Organ(33, getString(R.string.head), R.drawable.head, getString(R.string.head_desc)));
        organs.add(new Organ(34, getString(R.string.neck), R.drawable.neck, getString(R.string.neck_desc)));
        organs.add(new Organ(35, getString(R.string.chest), R.drawable.chest, getString(R.string.chest_desc)));
        organs.add(new Organ(36, getString(R.string.shoulder), R.drawable.shoulder, getString(R.string.shoulder_desc)));
        organs.add(new Organ(37, getString(R.string.hand), R.drawable.hands, getString(R.string.hand_desc)));
        organs.add(new Organ(38, getString(R.string.wrist), R.drawable.wrist, getString(R.string.wrist_desc)));
        organs.add(new Organ(39, getString(R.string.finger), R.drawable.fingers, getString(R.string.finger_desc)));
        organs.add(new Organ(40, getString(R.string.thigh), R.drawable.thigh, getString(R.string.thigh_desc)));
        organs.add(new Organ(41, getString(R.string.knee), R.drawable.knee, getString(R.string.knee_desc)));
        organs.add(new Organ(42, getString(R.string.leg), R.drawable.leg, getString(R.string.leg_desc)));
        organs.add(new Organ(43, getString(R.string.toe), R.drawable.toe, getString(R.string.toe_desc)));

        adapter = new BodyAdapter(this, this, organs);

        recycler.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        utils.exitApp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.changer:
                language.showChangeLanguageDialog();
                break;

            case R.id.search_menu:
                this.getSharedPreferences("database", Context.MODE_PRIVATE).edit().remove("allItems").apply();
                language.loadLocale();
                utils.initDatabase();
                startActivity(new Intent(this, SearchActivity.class));
                break;

            case R.id.home:
                Toast.makeText(this, "You are here already", Toast.LENGTH_SHORT).show();
                break;

            case R.id.exit:
                utils.exitApp();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}