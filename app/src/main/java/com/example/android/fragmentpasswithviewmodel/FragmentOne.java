package com.example.android.fragmentpasswithviewmodel;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.fragmentpasswithviewmodel.vm.SharedViewModel;

public class FragmentOne extends Fragment {
    private SharedViewModel model;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_one, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        final EditText inData = (EditText) view.findViewById(R.id.inMessage);

        Button buttonX = (Button)view.findViewById(R.id.btnPassData);
        buttonX.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Log.d("TRIMIS",inData.getText().toString());
                model.sendCity(inData.getText().toString());
                //DO SOMETHING! {RUN SOME FUNCTION ... DO CHECKS... ETC}
            }
        });


    }
}

