package com.anggariansah.coffeshop;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.anggariansah.coffeshop.adapter.CoffeAdapter;
import com.anggariansah.coffeshop.model.Coffe;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView ivLogo;
    Animation animLogoMove, animTransition;
    RelativeLayout relativeMain;

    HorizontalInfiniteCycleViewPager viewPager;
    List<Coffe> listCoffe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivLogo = findViewById(R.id.iv_logo);
        viewPager = findViewById(R.id.view_pager);
        relativeMain = findViewById(R.id.relative_main);

        animLogoMove = AnimationUtils.loadAnimation(this, R.anim.logo_move);
        animTransition = AnimationUtils.loadAnimation(this, R.anim.transition);

        initData();

        CoffeAdapter adapter = new CoffeAdapter(this, listCoffe);
        viewPager.setAdapter(adapter);

        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivLogo.setVisibility(View.VISIBLE);
                ivLogo.startAnimation(animLogoMove);

                viewPager.setVisibility(View.VISIBLE);
                viewPager.startAnimation(animTransition);
            }
        });
    }

    private void initData() {
        listCoffe.add(new Coffe("Tiraumisu", "Cappucino", getString(R.string.dummy), R.drawable.cup_capucino, R.drawable.back_cappu, R.drawable.coffee, Color.parseColor("#2d181c")));
        listCoffe.add(new Coffe("Greentea", "Latte", getString(R.string.dummy), R.drawable.cup_greentea, R.drawable.back_green, R.drawable.tea, Color.parseColor("#5d6d1b")));
        listCoffe.add(new Coffe("Mochacino", "Choco", getString(R.string.dummy), R.drawable.cup_mocha, R.drawable.back_mocha, R.drawable.choco, Color.parseColor("#b38865")));

    }
}
