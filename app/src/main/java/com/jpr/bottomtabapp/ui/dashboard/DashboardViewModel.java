package com.jpr.bottomtabapp.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jpr.bottomtabapp.retrofit.RetrofitClient;
import com.jpr.bottomtabapp.ui.dashboard.model.GetStudentResponseModel;
import com.jpr.bottomtabapp.ui.dashboard.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<List<Student>> studentList = new MutableLiveData<>();

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


    public LiveData<List<Student>> getStudentList() {

        Call<GetStudentResponseModel> call = RetrofitClient.getInstance().getApiInterface().getAllStudents();
        call.enqueue(new Callback<GetStudentResponseModel>() {
            @Override
            public void onResponse(Call<GetStudentResponseModel> call, Response<GetStudentResponseModel> response) {
                if (response.isSuccessful() && response.body().getData() !=null &&  response.body().getData().size()>0){
                    studentList.setValue(response.body().getData());
                }else{
                    mText.setValue(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetStudentResponseModel> call, Throwable t) {

            }
        });


        return studentList;
    }
}