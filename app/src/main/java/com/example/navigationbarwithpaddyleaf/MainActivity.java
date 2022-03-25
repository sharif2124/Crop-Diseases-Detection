package com.example.navigationbarwithpaddyleaf;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.navigationbarwithpaddyleaf.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.widget.PopupMenu;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationbarwithpaddyleaf.databinding.ActivityMainBinding;

import es.dmoral.toasty.Toasty;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    NavController navController;
    SmoothBottomBar smoothBottomBar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        smoothBottomBar=findViewById(R.id.bottomBar);
        navigationView = binding.navView;
        //for colourful icon
        navigationView.setItemIconTintList(null);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_share,R.id.nav_hotlinenumber,R.id.nav_rateus)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        setupbottombar();

        //for pop up message show

        Menu menu=navigationView.getMenu();
        MenuItem menuItem= menu.findItem(R.id.nav_email);
        //MenuItem menuItem1=menu.findItem(R.id.nav_rateus);
        MenuItem menuItem2=menu.findItem(R.id.nav_share);
       // menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            //@Override
            //public boolean onMenuItemClick(MenuItem menuItem) {
               // Toast.makeText(MainActivity.this, "RateUs Click", Toast.LENGTH_SHORT).show();
                //return true;
       //   //  }
      //  });
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toasty.info(MainActivity.this, "sharifk064@gmail.com", Toast.LENGTH_LONG, true).show();
                return true;
            }
        });

        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toasty.info(MainActivity.this, "Share", Toast.LENGTH_LONG, true).show();
                return true;
            }
        });



    }

  /*   @Override
 public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //for Bottom navigation
    public void setupbottombar()
    {
        PopupMenu popupMenu=new PopupMenu(this,null);
        popupMenu.inflate(R.menu.menu_bottom);
        Menu menu=popupMenu.getMenu();
       // binding.bottomBar.setupWithNavController(menu,navController);

        smoothBottomBar.setupWithNavController(menu,navController);

    }

    @Override
    public void onBackPressed() {
        if (HomeFragment.listner != null) {
            HomeFragment.listner.backPress();
        } else {
            super.onBackPressed();
        }
    }
}