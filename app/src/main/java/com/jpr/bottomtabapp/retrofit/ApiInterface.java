package com.jpr.bottomtabapp.retrofit;

import com.jpr.bottomtabapp.ui.dashboard.model.GetStudentResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


//        @POST("/api/loginUser")
//        Call<LoginResponseModel> loginUser(@Body LoginRequestModel loginRequest);
//
//        @POST("/api/addStudent")
//        Call<AddStudentsResponseModel>  addStudent(@Body AddStudentsRequestModel addStudentsRequestModel);

        @GET("/api/getAllStudents")
        Call<GetStudentResponseModel> getAllStudents();

//        @POST("/api/updateStudent")
//        Call<AddStudentsResponseModel> updateStudent(@Body AddStudentsRequestModel addStudentsRequestModel);
//
//        @DELETE("/api/deleteStudent/{id}")
//        Call<AddStudentsResponseModel> deleteStudent(@Path("id") Integer id );

        //@GET("/api/getStudentById/{id")
        //Call<AddStudentsResponseModel> getStudentById(@Path("id") int id);

    }

