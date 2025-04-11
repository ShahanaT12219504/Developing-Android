package com.example.entrenet

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Logo Click - Opens EntreNet Website
        val ivLogo: ImageView = findViewById(R.id.ivLogo)
        ivLogo.setOnClickListener {
            val websiteUrl = "https://www.entrenet.in"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))
            startActivity(intent)
        }

        // Setup Drawer
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_checklist -> showToast("Check Lists clicked")
                R.id.nav_events -> showToast("Member Events clicked")
                R.id.nav_announcement -> showToast("Announcement clicked")
                R.id.nav_gallery -> showToast("Galleries clicked")
                R.id.nav_about -> showToast("About Us clicked")
                R.id.nav_about_app -> showToast("About App clicked")
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Bottom Navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        loadFragment(HomeFragment()) // Load Home by default

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_activity -> loadFragment(ActivityFragment2())
                R.id.nav_explore -> loadFragment(ExploreFragment())
                R.id.nav_profile -> loadFragment(ProfileFragment())
                R.id.nav_post -> loadFragment(PostFragment())
            }
            true
        }

        // Floating Chat Button - Opens ChatFragment instead of Chatbot
        val fabChatbot: FloatingActionButton = findViewById(R.id.fab_chatbot)
        fabChatbot.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, ChatFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun getActivityFragment(): ActivityFragment2? {
        return supportFragmentManager.findFragmentByTag("activityFragment") as? ActivityFragment2
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
