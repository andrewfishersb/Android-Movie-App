package com.epicodus.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.button) Button clickButton;
    @Bind(R.id.editText) EditText titleSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        clickButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        String searchTitle = titleSearch.getText().toString();
        Intent intent = new Intent(MainActivity.this,MovieActivity.class);
        intent.putExtra("searchTitle", searchTitle);
        startActivity(intent);
    }
}
