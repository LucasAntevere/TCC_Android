package com.lucas.antevere.brechlivre;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout mLinearLayoutBase;
    private DrawerLayout mDrawer;
    private FrameLayout mFrame;
    private ProgressBar mLoadingProgressbar;
    private FrameLayout mFrameLoading;

    @Override
    public void setContentView(int layoutResID) {
        mDrawer = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        mFrame = (FrameLayout) mDrawer.findViewById(R.id.base_frame);
        // add layout of BaseActivities inside framelayout.i.e. frame_container
        getLayoutInflater().inflate(layoutResID, mFrame, true);
        // set the drawer layout as main content view of Activity.
        super.setContentView(mDrawer);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setActionBarDrawerToggle(Toolbar toolbar){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_products) {
            // Handle the camera action
        } else if (id == R.id.nav_meus_interesses) {

        } else if (id == R.id.nav_vitrine) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_help) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setLoading(boolean loading){
        if(mLoadingProgressbar == null) {
            mLoadingProgressbar = (ProgressBar) findViewById(R.id.loading_progressbar);
            mLoadingProgressbar.setIndeterminate(true);
        }

        if(mFrameLoading == null){
            mFrameLoading = (FrameLayout) findViewById(R.id.frame_loading);
        }

        if(loading) {
            mLoadingProgressbar.setVisibility(View.VISIBLE);
            mFrameLoading.setVisibility(View.VISIBLE);
        }
        else {
            mLoadingProgressbar.setVisibility(View.INVISIBLE);
            mFrameLoading.setVisibility(View.INVISIBLE);
        }
    }
}
