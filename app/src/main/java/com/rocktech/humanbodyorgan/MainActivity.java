package com.rocktech.humanbodyorgan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Language language = new Language(this, this);
        language.loadLocale();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(getResources().getString(R.string.app_name));

        new Handler().postDelayed(() -> {

            Intent intent = new Intent(MainActivity.this, MaleActivity.class);
            startActivity(intent);
        }, 5000);


    }


}