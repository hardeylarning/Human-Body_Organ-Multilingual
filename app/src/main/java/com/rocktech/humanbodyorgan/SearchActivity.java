package com.rocktech.humanbodyorgan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rocktech.humanbodyorgan.model.Utils;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    RecyclerView recycler;
    TextView notFound;
    EditText searchText;
    Button searchButton;
    SearchAdapter adapter;
    List<Organ> organs;
    private Utils utils;
    private Language language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        language = new Language(this, this);
        language.loadLocale();
        setContentView(R.layout.activity_search);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        recycler = findViewById(R.id.searchBody);
        notFound = findViewById(R.id.notFound);
        searchText = findViewById(R.id.textSearch);
        searchButton = findViewById(R.id.btnSearch);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        searchButton.setOnClickListener(view -> {
            utils = new Utils(getApplicationContext(), this);
            this.getSharedPreferences("database", Context.MODE_PRIVATE).edit().remove("allItems").apply();
            language.loadLocale();
            utils.initDatabase();
            String text = searchText.getText().toString();
            organs = utils.searchForItem(text);
            if (organs.size() < 1)
            {
                notFound.setVisibility(View.VISIBLE);
                notFound.setText(R.string.no_search_found);
                recycler.setVisibility(View.INVISIBLE);
            }
            else {
                notFound.setVisibility(View.GONE);
                recycler.setVisibility(View.VISIBLE);
                adapter = new SearchAdapter(this, this, organs);
                recycler.setAdapter(adapter);
            }
        });
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
                Toast.makeText(this, "Already here",
                        Toast.LENGTH_SHORT).show();
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

}