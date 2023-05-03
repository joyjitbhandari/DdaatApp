package com.example.ddaatapp.commonClass

import android.content.Context
import com.example.ddaatapp.R
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView


class MyDrawerNavigationItemSelectedListener(val context: Context) : NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here
        val id: Int = item.getItemId()
        when(id){
            R.id.drawerProfile->{
                return true
            }
            R.id.drawerMyNotes->{

                return true
            }
        }
        return false
    }
}
