package com.example.tvd.retrofit_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tvd.retrofit_example.Interface.RetrofitInterface;
import com.example.tvd.retrofit_example.model.TestDate;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * https://www.simplifiedcoding.net/retrofit-android-example/
 **/

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText username, password, group;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);
        progressBar.setVisibility(View.INVISIBLE);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_system_date();
            }
        });
    }

    public void get_system_date() {
        progressBar.setVisibility(View.VISIBLE);
        //Creating a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        //creating the api interface
        RetrofitInterface api = retrofit.create(RetrofitInterface.class);
        //now making the call object
        //Here we are using the api method that we created inside the api interface
        Call<List<TestDate>> call = api.get_Date();
        //then finallly we are making the call using enqueue()
        //it takes callback interface as an argument
        //and callback is having two methods onRespnose() and onFailure
        //if the request is successfull we will get the correct response and onResponse will be executed
        //if there is some error we will get inside the onFailure() method
        call.enqueue(new Callback<List<TestDate>>() {
            @Override
            public void onResponse(Call<List<TestDate>> call, Response<List<TestDate>> response) {


                //thats damn easy right ;)
                List<TestDate> gitmodel = response.body();
                //now we can do whatever we want with this list
                assert gitmodel != null;
                for (int i = 0; i < gitmodel.size(); i++) {
                    Toast.makeText(MainActivity.this, "System_Date " + gitmodel.get(i).getSysdate1(), Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onFailure(Call<List<TestDate>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

}

