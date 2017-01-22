package com.randroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.widget.TextView;

import com.randroid.model.Model;
import com.randroid.rest.RestApi;

import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2 extends AppCompatActivity {

    public static final String RootUrl = "http://api.teknorial.com/";

    private TextView text_id, text_nama, text_email, text_alamat, text_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit2);

        text_id = (TextView) findViewById(R.id.text_id);
        text_nama = (TextView) findViewById(R.id.text_nama);
        text_email = (TextView) findViewById(R.id.text_email);
        text_alamat = (TextView) findViewById(R.id.text_alamat);
        text_status = (TextView) findViewById(R.id.text_status);

        getData();
    }

    private void getData() {
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait..", false, false);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RootUrl).addConverterFactory(GsonConverterFactory.create()).build();
        RestApi service = retrofit.create(RestApi.class);
        Call<Model> call = service.getDataAdmin();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                try {
                    loading.dismiss();

                    String id = response.body().getAdmin().getId().toString();
                    String nama = response.body().getAdmin().getNama();
                    String email = response.body().getAdmin().getEmail();
                    String alamat = response.body().getAdmin().getAlamat();
                    String status = response.body().getAdmin().getStatus();

                    text_id.setText("ID : "+id);
                    text_nama.setText("Nama : "+nama);
                    text_email.setText("Email : "+email);
                    text_alamat.setText("Alamat : "+alamat);
                    text_status.setText("Status :"+status);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }
}
