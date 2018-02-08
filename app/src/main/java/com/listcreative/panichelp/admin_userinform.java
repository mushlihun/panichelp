package com.listcreative.panichelp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class admin_userinform extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_userinform);
        TextView tv = (TextView) findViewById(R.id.PesanIsi);
        tv.setMovementMethod(new ScrollingMovementMethod());
    }
}
