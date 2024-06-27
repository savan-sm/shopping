package com.example.blog_gridview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    int i  = 0;
    Toolbar toolbar;
    ShapeableImageView view,save,save1,save2,save3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.logo);
        save = findViewById(R.id.shapeableImageView1);
        save1 = findViewById(R.id.shapeableImageView2);
        save2 = findViewById(R.id.shapeableImageView3);
        save3 = findViewById(R.id.shapeableImageView4);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    save.setImageResource(R.mipmap.save);
                    i++;
                } else if (i == 1) {
                    save.setImageResource(R.mipmap.unsave);
                    i--;
                }
            }
        });
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    save1.setImageResource(R.mipmap.save);
                    i++;
                } else if (i == 1) {
                    save1.setImageResource(R.mipmap.unsave);
                    i--;
                }
            }
        });
        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    save2.setImageResource(R.mipmap.save);
                    i++;
                } else if (i == 1) {
                    save2.setImageResource(R.mipmap.unsave);
                    i--;
                }
            }
        });
        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    save3.setImageResource(R.mipmap.save);
                    i++;
                } else if (i == 1) {
                    save3.setImageResource(R.mipmap.unsave);
                    i--;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.bag){
            Toast.makeText(this, "Shopping!!!", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}