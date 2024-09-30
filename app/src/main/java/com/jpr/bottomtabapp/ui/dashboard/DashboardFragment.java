package com.jpr.bottomtabapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jpr.bottomtabapp.databinding.FragmentDashboardBinding;
import com.jpr.bottomtabapp.ui.dashboard.model.Student;

import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String msg) {
              binding.stdRv.setVisibility(View.GONE);
              binding.noDataTv.setVisibility(View.VISIBLE);
              binding.noDataTv.setText(msg);
            }
        });

        dashboardViewModel.getStudentList().observe(getViewLifecycleOwner(), new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                LinearLayoutManager manager = new LinearLayoutManager(requireActivity());
                binding.stdRv.setLayoutManager(manager);
                binding.stdRv.setHasFixedSize(true);
                StudentAdapter adapter = new StudentAdapter();
                adapter.setStudentList(students);
                binding.stdRv.setAdapter(adapter);

                binding.stdRv.setVisibility(View.VISIBLE);
                binding.noDataTv.setVisibility(View.GONE);

            }
        });
       
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}