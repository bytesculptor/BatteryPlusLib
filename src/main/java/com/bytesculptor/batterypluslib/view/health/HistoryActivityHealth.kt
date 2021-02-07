/*
 * Copyright (c) 2017 - 2021  Byte Sculptor Software  - All Rights Reserved
 *
 * All information contained herein is and remains the property of Byte Sculptor Software.  
 * Unauthorized copying of this file, via any medium, is strictly prohibited unless prior 
 * written permission is obtained from Byte Sculptor Software.
 *
 * Romeo Rondinelli - bytesculptor@gmail.com
 *
 */

package com.bytesculptor.batterypluslib.view.health

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bytesculptor.batterypluslib.R
import com.google.android.material.tabs.TabLayout

class HistoryActivityHealth : AppCompatActivity() {

    // private var dbHandler: DbHandler? = null
    private var tvStatOverheat: TextView? = null
    private var tvStatCold: TextView? = null
    private var tvStatOvervoltage: TextView? = null
    private var tvStatFailure: TextView? = null
    private var tvStatDead: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setTitle(R.string.battery_health)
        tvStatOverheat = findViewById(R.id.tvBatStatOverheatCnt)
        tvStatCold = findViewById(R.id.tvBatStatColdCnt)
        tvStatOvervoltage = findViewById(R.id.tvBatStatOvervoltageCnt)
        tvStatFailure = findViewById(R.id.tvBatStatUnspecFailureCnt)
        tvStatDead = findViewById(R.id.tvBatStatDeadCnt)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        // dbHandler = DbHandler(this)
//        loadDatabaseEntries()
    }

    fun loadDatabaseEntries() {
        val dbRes = null// dbHandler!!.queryAllHealthEvents()
        val recyclerView: RecyclerView = findViewById(R.id.rvHealthList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //     recyclerView.adapter = DbAdapter(dbRes, applicationContext)
        countHealthEvents()
    }

    private fun countHealthEvents() {
        //    var res = dbHandler!!.countHealthStatusByType(BatteryManager.BATTERY_HEALTH_OVERHEAT).toString() + "x"
        tvStatOverheat!!.text = null//  res
        //   res = dbHandler!!.countHealthStatusByType(BatteryManager.BATTERY_HEALTH_COLD).toString() + "x"
        tvStatCold!!.text = null// res
        //     res = dbHandler!!.countHealthStatusByType(BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE).toString() + "x"
        tvStatOvervoltage!!.text = null//  res
        //    res = dbHandler!!.countHealthStatusByType(BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE).toString() + "x"
        tvStatFailure!!.text = null// res
        //     res = dbHandler!!.countHealthStatusByType(BatteryManager.BATTERY_HEALTH_DEAD).toString() + "x"
        tvStatDead!!.text = null// res
    }

    companion object {
        private val TAG = HistoryActivityHealth::class.java.simpleName
    }
}