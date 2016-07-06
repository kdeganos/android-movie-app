package com.epicodus.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.getMovieButton) Button mGetMovieButton;
    @Bind(R.id.movieEditText) EditText mMovieEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mGetMovieButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if(view == mGetMovieButton) {
            String title = mMovieEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, MovieActivity.class);
            intent.putExtra("title", title);
            startActivity(intent);
        }
    }
}
