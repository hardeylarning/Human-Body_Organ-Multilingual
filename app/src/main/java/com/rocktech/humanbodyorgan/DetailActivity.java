package com.rocktech.humanbodyorgan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rocktech.humanbodyorgan.model.Utils;

public class DetailActivity extends AppCompatActivity {
    TextView title;
    ImageView image;
    TextView description;

    Language language;
    Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utils = new Utils(this, this);
        language = new Language(this, this);
        language.loadLocale();
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        title = findViewById(R.id.title);
        image = findViewById(R.id.image);
        description = findViewById(R.id.description);
        getIntentData();

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
                language.loadLocale();
                new Handler().postDelayed(() -> {

                    Intent intentReturn = new Intent(this, BodyActivity.class);
                    startActivity(intentReturn);
                }, 5000);
                break;
            case R.id.search_menu:
                this.getSharedPreferences("database", Context.MODE_PRIVATE).edit().remove("allItems").apply();
                language.loadLocale();
                utils.initDatabase();
                startActivity(new Intent(this, SearchActivity.class));
                break;

            case R.id.home:
                startActivity(new Intent(this, BodyActivity.class));
                break;
            case R.id.exit:
                utils.exitApp();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    void getIntentData(){
        if (getIntent().hasExtra("title")){

            title.setText(getIntent().getStringExtra("title"));
            description.setText(getIntent().getStringExtra("description"));

            Glide.with(this).asBitmap()
                    .load(getIntent().getIntExtra("image_url", 0))
                    .centerCrop()
                    .into(image);
        }
        else {
            Toast.makeText(this, "No data found.", Toast.LENGTH_LONG).show();
        }
    }
}