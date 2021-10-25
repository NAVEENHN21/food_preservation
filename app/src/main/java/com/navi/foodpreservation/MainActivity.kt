package com.navi.foodpreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawer:DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var frame:FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawer=findViewById(R.id.drawer)
        navigationView=findViewById(R.id.navigation)
        toolbar=findViewById(R.id.toolbar)
        frame=findViewById(R.id.frame)
        setuptoolbar()
       opendashboard()

       val actionBarDrawerToggle=ActionBarDrawerToggle(this@MainActivity,drawer,R.string.opendrawer,R.string.closedrawer)
       drawer.addDrawerListener(actionBarDrawerToggle)
       actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dashboard->{
                    opendashboard()
                    drawer.closeDrawers()
                }
                R.id.pickling->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,pickling())
                        .commit()
                    supportActionBar?.title="PICKLING"
                    drawer.closeDrawers()
                }
                R.id.salting->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,salting())
                        .commit()
                    supportActionBar?.title="SALTING"
                    drawer.closeDrawers()
                }
                R.id.smoking->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,smoking())
                        .commit()
                    supportActionBar?.title="SMOKING"
                    drawer.closeDrawers()
                }
                R.id.canning->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,canning())
                        .commit()
                    supportActionBar?.title="CANNING"
                    drawer.closeDrawers()
                }
                R.id.bottling->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,bottling())
                        .commit()
                    supportActionBar?.title="BOTTLING"
                    drawer.closeDrawers()
                }
                R.id.refrigeration->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,refrigeration())
                        .commit()
                    supportActionBar?.title="REFRIGERATION"
                    drawer.closeDrawers()
                }
                R.id.dehydration->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,dehydration())
                        .commit()
                    supportActionBar?.title="DEHYDRATION"
                    drawer.closeDrawers()
                }
                R.id.chemicaladditives->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,chemicaladditives())
                        .commit()
                    supportActionBar?.title="CHEMICAL ADDITIVES"
                    drawer.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }
    fun opendashboard(){
        val fragment=dashboardfragment()
              val transaction= supportFragmentManager.beginTransaction()
               transaction .replace(R.id.frame,fragment)
                transaction.commit()
            supportActionBar?.title="FOOD PRESERVATION"
    }
    fun setuptoolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="FOOD PRESERVATION"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frame)
        when(frag) {
            !is dashboardfragment -> opendashboard()
           else -> super.onBackPressed()
        }
    }
}