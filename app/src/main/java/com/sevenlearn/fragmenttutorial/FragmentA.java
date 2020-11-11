package com.sevenlearn.fragmenttutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //xml to java and set view
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //give btn from layout and set action
        Button goToB=view.findViewById(R.id.btn_a_goToB);
        goToB.setOnClickListener(new View.OnClickListener() {
            @Override
            //set bnt to replace fragment
            public void onClick(View v) {
                //  use getFragmentManager() for load fragment on activity
                FragmentTransaction fragmentTransaction= getFragmentManager() != null ? getFragmentManager().beginTransaction() : null;
                fragmentTransaction.replace(R.id.frame_main_fragmentContainer,new FragmentB());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
