package com.randroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.randroid.model.Post;
import com.randroid.rest.APIService;
import com.randroid.rest.BaseURL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Insert extends AppCompatActivity {

    public EditText textUsername, textPassword;
    public APIService APIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        textUsername = (EditText) findViewById(R.id.textUsername);
        textPassword = (EditText) findViewById(R.id.textPassword);

        APIService = BaseURL.getBaseURL();
    }

    public void button_insert(View view) {
        InsertData();
    }

    private void InsertData() {
        String username = textUsername.getText().toString();
        String password = textPassword.getText().toString();

        if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Kosong!", Toast.LENGTH_LONG).show();
        }

        if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            sendPost(username, password);
        }
    }

    public void sendPost(String username, String password) {
        APIService.savePost(username, password).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Toast.makeText(getApplicationContext(), "onRespone", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "onFailure", Toast.LENGTH_LONG).show();
            }
        });
    }
}
