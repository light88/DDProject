package com.dev.moneykeeper.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.dev.moneykeeper.callback.SlidingMenuClickCallback;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends SherlockFragmentActivity implements SlidingMenuClickCallback {

    private SlidingMenu mSlidingMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("ATTACH...");
        initFragments();

        getSherlock().getActionBar().setHomeButtonEnabled(true);//.setDisplayHomeAsUpEnabled(true);


        // set the Above View
        setContentView(R.layout.content_frame);
        final FragmentManager fragmentManager = getSupportFragmentManager();


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new HelloWorldFragment())
                .commit();

        // configure the SlidingMenu
        mSlidingMenu = new SlidingMenu(this);
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
//		mSlidingMenu.setShadowDrawable(R.drawable.shadow);
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        mSlidingMenu.setFadeDegree(0.35f);
        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        mSlidingMenu.setMenu(R.layout.menu_frame);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.menu_frame, new SlidingMenuFragment())
                .commit();


    }

    @Override
    public void onBackPressed() {
        if (mSlidingMenu.isMenuShowing()) {
            mSlidingMenu.showContent();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.main, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Toast.makeText(this, "home pressed", Toast.LENGTH_LONG).show();
                mSlidingMenu.toggle();
                return true;

            }
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void OnSlidingMenuClick(int position) {
        Log.i("OnSlidingMenuClick", String.format("list item = %d", position));
        switchPage(position);
    }

    private void switchPage(int position) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.alpha_in, R.anim.alpha_out)
                .replace(R.id.content_frame, pages.get(position))
                .commit();
        mSlidingMenu.toggle();
    }

    void initFragments() {
        pages.add(new HelloWorldFragment());
        pages.add(new AboutFragment());
        pages.add(new InputFragment());
    }

    List<Fragment> pages = new ArrayList<Fragment>();

}
