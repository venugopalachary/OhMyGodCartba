package com.ohmygodcart.android.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.ohmygodcart.android.R;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class Onboarding extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

         // hide the title bar name
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();

        fragmentManager=getSupportFragmentManager();

        final PaperOnboardingFragment  paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataOnBoarding());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, paperOnboardingFragment);
        fragmentTransaction.commit();
    }

    private ArrayList<PaperOnboardingPage>  getDataOnBoarding()
    {
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Shop your daily needs",
                "You won’t find it cheaper anywhere else than OHMYGODCART.",
                Color.parseColor("#ffffff"), R.drawable.o1, R.drawable.cart);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Exiting offers",
                "Get new offers and great deals everyday every hour.",
                Color.parseColor("#ffffff"), R.drawable.o2, R.drawable.offers);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("1000+ products",
                "Shop and get delivery at your convenience.",
                Color.parseColor("#ffffff"), R.drawable.o3, R.drawable.products);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);

       return  elements;
    }

    public void Signup (View view)
    {
        startActivity(new Intent(Onboarding.this,Sign_up.class));
    }

}