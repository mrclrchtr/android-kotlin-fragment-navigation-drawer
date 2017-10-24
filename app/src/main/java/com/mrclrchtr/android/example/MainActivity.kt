package com.mrclrchtr.android.example

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.mrclrchtr.android.example.bar.BarFragment
import com.mrclrchtr.android.example.baz.BazFragment
import com.mrclrchtr.android.example.foo.FooFragment
import com.mrclrchtr.android.example.foobar.FooBarFragment
import com.mrclrchtr.android.example.util.OnFragmentInteractionListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar_main)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar_main, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fooFragment = FooFragment()
        fragmentTransaction.add(R.id.frame_layout_main_top, fooFragment)

        val barFragment = BarFragment()
        fragmentTransaction.add(R.id.frame_layout_main_bottom, barFragment)

        fragmentTransaction.commit()

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_top_foo -> {
                fragmentManager.beginTransaction().add(R.id.frame_layout_main_top, FooFragment()).commit()
            }
            R.id.nav_top_bar -> {
                fragmentManager.beginTransaction().add(R.id.frame_layout_main_top, BarFragment()).commit()
            }
            R.id.nav_bottom_foo -> {
                fragmentManager.beginTransaction().add(R.id.frame_layout_main_bottom, FooFragment()).commit()
            }
            R.id.nav_bottom_bar -> {
                fragmentManager.beginTransaction().add(R.id.frame_layout_main_bottom, BarFragment()).commit()
            }
//            R.id.nav_share -> {
//
//            }
//            R.id.nav_send -> {
//
//            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onFragmentInteraction(TAG: String, uri: Uri) {
        when (TAG) {
            BarFragment.TAG -> Log.i(this.TAG, "onFragmentInteraction with BarFragment")
            FooFragment.TAG -> Log.i(this.TAG, "onFragmentInteraction with FooFragment")
            BazFragment.TAG -> Log.i(this.TAG, "onFragmentInteraction with BazFragment")
            FooBarFragment.TAG -> Log.i(this.TAG, "onFragmentInteraction with FooBarFragment")
        }
    }
}
