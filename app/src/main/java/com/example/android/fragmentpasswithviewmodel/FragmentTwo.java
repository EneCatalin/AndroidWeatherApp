package com.example.android.fragmentpasswithviewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.fragmentpasswithviewmodel.vm.SharedViewModel;


public class FragmentTwo extends Fragment {

    TextView txtData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_two, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        model.getCity().observe(this, item -> {
            txtData = (TextView)view.findViewById(R.id.txtData);
            txtData.setText(item);
//            Log.d("PRIMIT", item);

        });
    }
}

