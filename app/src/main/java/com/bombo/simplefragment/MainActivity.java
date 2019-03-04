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

        setUpFragmentEventListener();
    }

    private void setUpFragmentEventListener() {

        ((View01Fragment) fragmentView01).setFoo01ClickEventListener(new View01Fragment.Foo01ClickEventListener() {
            @Override
            public void onFoo01Click(String message) {
                showToastMessage(message);
                switchFragment();
            }
        });

        ((View02Fragment) fragmentView02).setBar02ClickEventListener(new View02Fragment.Bar02ClickEventListener() {
            @Override
            public void onBar02Click(String message) {
                showToastMessage(message);
                switchFragment();
            }
        });

        ((View03Fragment) fragmentView03).setHot03ClickEventListener(new View03Fragment.Hot03ClickEventListener() {
            @Override
            public void onHot03Click(String message) {
                showToastMessage(message);
                switchFragment();
            }
        });

        ((View04Fragment) fragmentView04).setCold04ClickEventListener(new View04Fragment.Cold04ClickEventListener() {
            @Override
            public void onCold04Click(String message) {
                showToastMessage(message);
                switchFragment();
            }
        });
    }

    private void showToastMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
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
