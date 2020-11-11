package com.sevenlearn.fragmenttutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentB extends Fragment {

    @Nullable
    @Override
    //xml to java and set view
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //use getChildFragmentManager() for load fragment on fragment
        FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_b_fragmentContainer,new FragmentC());
        fragmentTransaction.commit();
    }
}
