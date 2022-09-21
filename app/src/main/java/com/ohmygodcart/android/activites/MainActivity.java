package com.ohmygodcart.android.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ohmygodcart.android.R;
import com.ohmygodcart.android.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {


     Fragment homeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hide the title bar name
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();

        //

          homeFragment=new HomeFragment();
          loadfragment(homeFragment);

    }

    private void loadfragment(Fragment homeFragment) {

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_container,homeFragment);
        transaction.commit();

    }
}