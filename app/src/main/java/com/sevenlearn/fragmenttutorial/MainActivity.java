package com.sevenlearn.fragmenttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add fragment to activity_main(start transaction)
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        //set which content to display inside which frame
        fragmentTransaction.add(R.id.frame_main_fragmentContainer,new FragmentA());
        //keep content in a stack
        fragmentTransaction.addToBackStack("FRAGMENT_A");
        fragmentTransaction.commit();

        //remove fragment(remove transaction btn)
        Button removeTransactionBtn=findViewById(R.id.btn_main_removeFragment);
        removeTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //find active fragment
                Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.frame_main_fragmentContainer);
                if (fragment!=null){
                    FragmentTransaction removeTransaction=getSupportFragmentManager().beginTransaction();
                    removeTransaction.remove(fragment);
                    removeTransaction.addToBackStack(null);
                    removeTransaction.commit();
                }

            }
        });
    }
}