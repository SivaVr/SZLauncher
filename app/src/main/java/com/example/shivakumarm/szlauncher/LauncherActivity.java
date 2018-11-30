package com.example.shivakumarm.szlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LauncherActivity extends AppCompatActivity implements Homescreen.OnFragmentInteractionListener {

    public static Context baseContext = new LauncherActivity();

    public static Drawable getActivityIcon(Context context, String s, String s1) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(s, s1));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);
        return resolveInfo.loadIcon(pm);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        ImageView appDrawerBtn = (ImageView) findViewById(R.id.appDrawerBtn);
        appDrawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAppDrawer(v);
            }
        });

        ImageView chromeIcon = (ImageView) findViewById(R.id.chromebut);
        chromeIcon.setImageDrawable(getActivityIcon(this,"com.android.chrome", "com.google.android.apps.chrome.Main"));



        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPager);
        LauncherAdapter mPagerAdapter = new LauncherAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);


    }

    public void startAppDrawer(View v){
        Intent appDr = new Intent();
        appDr.setClass(this, AppDrawer.class);
        startActivity(appDr);
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
