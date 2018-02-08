package com.listcreative.panichelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class PilihanLainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan_lain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void menuBidanClick (View view) {
        Intent intent = new Intent(PilihanLainActivity.this, ListActivity.class);
        startActivity(intent);
    }//
    public void menuTukangUrutClick (View view) {
        Intent intent = new Intent(PilihanLainActivity.this, ListActivity.class);
        startActivity(intent);
    }
    public void menuKhitanClick (View view) {
        Intent intent = new Intent(PilihanLainActivity.this, ListActivity.class);
        startActivity(intent);
    }
    public void menuAmbulanClick (View view) {
        Intent intent = new Intent(PilihanLainActivity.this, ListActivity.class);
        startActivity(intent);
    }
}
