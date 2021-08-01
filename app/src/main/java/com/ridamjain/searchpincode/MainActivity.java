package com.ridamjain.searchpincode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText search;
    Button check;
    private APIClient apiClient;
    TextView x;
    String ab="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiClient = RetrofitClient.getRetrofitInstance().create(APIClient.class);
        search = findViewById(R.id.pincode);
        x = findViewById(R.id.show);
        check = findViewById(R.id.submit);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s = Integer.parseInt(search.getText().toString().trim());
                if (s==0)
                {
                    Toast.makeText(getApplicationContext(),"Pincode is Empty",Toast.LENGTH_LONG).show();
                }
                else {
                    getState(s);
                }
            }
        });
    }

    private void getState(int code) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.postalpincode.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIClient request = retrofit.create(APIClient.class);
        Call<List<postData>> call = request.getData(code);
        call.enqueue(new Callback<List<postData>>() {
            @Override
            public void onResponse(Call<List<postData>> call, Response<List<postData>> response) {
                List<postData> postData = response.body();
                for (postData postData1: postData)
                {
                    ArrayList<PostOffice>  post = new ArrayList<>(postData1.getPostOffices());
                    ab += post.get(1);
                }
               x.setText(ab);
//                Toast.makeText(getApplicationContext(),ab,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<postData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
}