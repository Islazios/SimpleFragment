package com.bombo.simplefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.bombo.simplefragment.fragment.View01Fragment;
import com.bombo.simplefragment.fragment.View02Fragment;
import com.bombo.simplefragment.fragment.View03Fragment;
import com.bombo.simplefragment.fragment.View04Fragment;

public class MainActivity extends AppCompatActivity {

    private boolean hasTrigger = true;

    private FragmentManager fragmentManager;

    private Fragment fragmentView01;
    private Fragment fragmentView02;
    private Fragment fragmentView03;
    private Fragment fragmentView04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        //Initial Fragment all
        fragmentView01 = new View01Fragment();
        fragmentView02 = new View02Fragment();
        fragmentView03 = new View03Fragment();
        fragmentView04 = new View04Fragment();

        deployFragmentAtFirstTime();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_switch) {
            Toast.makeText(MainActivity.this, getString(R.string.message_switch_fragment), Toast.LENGTH_SHORT).show();
            switchFragment();
        }
        return super.onOptionsItemSelected(item);
    }

    private void deployFragmentAtFirstTime() {

        if (fragmentManager == null) {
            return;
        }

        fragmentManager.beginTransaction()
                .add(R.id.view_container_01, fragmentView01)
                .add(R.id.view_container_02, fragmentView02)
                .addToBackStack(null)
                .commit();
    }

    private void switchFragment() {
        if (hasTrigger) {
            fragmentManager.beginTransaction()
                    .replace(R.id.view_container_01, fragmentView03)
                    .replace(R.id.view_container_02, fragmentView04)
                    .commit();
            hasTrigger = false;
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.view_container_01, fragmentView01)
                    .replace(R.id.view_container_02, fragmentView02)
                    .commit();
            hasTrigger = true;
        }
    }
}
