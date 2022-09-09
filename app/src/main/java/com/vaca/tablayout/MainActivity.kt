package com.vaca.tablayout

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabs: TabLayout = findViewById(R.id.tabs)

        val mTitles = arrayOf(
            "aa", "bb", "cc", "dd"
        )

        for (i in mTitles.indices) {
            val tab: TabLayout.Tab = tabs.newTab()
            tab.text = mTitles[i]
            tab.customView = getTabView(i, mTitles)
            tabs.addTab(tab)
        }

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.e("fuck",tab.position.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }


    private fun getTabView(currentPosition: Int, strings: Array<String>): View {
        val view = LayoutInflater.from(this).inflate(R.layout.history_tab_item, null)
        val textView: TextView = view.findViewById(R.id.tab_item_textview)
        textView.text = strings[currentPosition]
        return view
    }
}