package com.example.mahesh.myproject3;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class  MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawer_layout;
    RelativeLayout profilelayout;
    ImageView profileicon;
    private ActionBarDrawerToggle mDrawerToggle;
    int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to get the width and height of the screen
        DisplayMetrics mertics = this.getResources().getDisplayMetrics();
        width = mertics.widthPixels;
        height = mertics.heightPixels;

   
         drawer_layout=(DrawerLayout)findViewById(R.id.drawer_layout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
         toolbar.getLayoutParams().width = width;
       setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setupDrawer();

      //  getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, new Home()).commit();

        }

    void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, drawer_layout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {

                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {

                invalidateOptionsMenu();
            }
        };
        mDrawerToggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Drawable overflowIcon = toolbar.getOverflowIcon();

        if (overflowIcon != null) {
            Drawable newIcon = overflowIcon.mutate();
            newIcon.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
            toolbar.setOverflowIcon(newIcon);
        }


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
