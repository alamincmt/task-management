package com.example.taskmangement.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.taskmangement.R
import com.example.taskmangement.fragment.CalenderFragment
import com.example.taskmangement.fragment.ReportFragment
import com.example.taskmangement.fragment.TasksFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationItemView = findViewById<BottomNavigationView
                >(R.id.bottom_navigatin_view)

        bottomNavigationItemView.menu.getItem(0).isCheckable = true
        setFragment(CalenderFragment())

        bottomNavigationItemView.setOnNavigationItemSelectedListener {menu ->

            when(menu.itemId){

                R.id.nav_calender -> {
                    setFragment(CalenderFragment())
                    true
                }

                R.id.nav_tasks -> {
                    setFragment(TasksFragment())
                    true
                }

                R.id.nav_report -> {
                    setFragment(ReportFragment())
                    true
                }

                R.id.nav_more -> {
                    Toast.makeText(this,"More Clicked",Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

    }

    fun setFragment(fr : Fragment){
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.fragment,fr)
        frag.commit()
    }
}