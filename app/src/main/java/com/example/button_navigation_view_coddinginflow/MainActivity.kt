package com.example.button_navigation_view_coddinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigatiob.setOnNavigationItemSelectedListener(navLisener)

        getSupportFragmentManager().beginTransaction().replace(
            R.id.fragment_container, HomeFragment()
        ).commit()
    }

    val navLisener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var selectedFragment: Fragment? = null
                when (item.getItemId()) {
                    R.id.nav_home -> selectedFragment = HomeFragment()
                    R.id.nav_favorites -> selectedFragment = FavoriteFragment()
                    R.id.nav_search -> selectedFragment = SearchFregment()
                }
                getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, selectedFragment!!
                ).commit()
                return true
            }

        }
}


