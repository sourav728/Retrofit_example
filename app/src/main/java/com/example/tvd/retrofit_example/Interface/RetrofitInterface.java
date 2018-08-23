package com.example.tvd.retrofit_example.Interface;

import com.example.tvd.retrofit_example.model.TestDate;
import com.example.tvd.retrofit_example.values.LoginData;
import com.example.tvd.retrofit_example.values.LoginResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
   String BASE_URL = "http://test_bc_service.hescomtrm.com/Service.asmx/";
   @GET("TestSysDate")
   Call<List<TestDate>>get_Date();
}
