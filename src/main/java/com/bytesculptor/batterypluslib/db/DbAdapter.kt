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

package com.bytesculptor.batterypluslib.db

import android.content.Context
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bytesculptor.batterypluslib.R
import com.bytesculptor.batterypluslib.model.HealthEvents
import java.util.*


class DbAdapter(var batteryList: List<HealthEvents>, applicationContext: Context) : RecyclerView.Adapter<DbAdapter.ViewHolder>() {

    val context = applicationContext

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.listitem_battery_history, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = batteryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.tvEvent.text = getEventName(batteryList[position])
    }

    fun getEventName(id: HealthEvents): String {
        when (id) {
            HealthEvents.OVER_VOLTAGE -> return context.getString(R.string.szBatOvervoltage)
            HealthEvents.COLD -> return context.getString(R.string.szBatCold)
            HealthEvents.OVERHEAT -> return context.getString(R.string.szBatOverheat)
            HealthEvents.DEAD -> return context.getString(R.string.szBatDead)
            HealthEvents.UNSPECIFIED -> return context.getString(R.string.szBatUnspec)
            else -> return ""
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val tvTimest: ImageView = itemView.ivHealthIcon
        //val tvEvent: TextView = itemView.tvHealthEvent
    }


    /*
        val timeAsLong = cursor.getLong(ciTimestamp)
        val healthStatus = cursor.getInt(ciHealthEvent)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeAsLong
        val currenTimeZone = Date(timeAsLong)
        //Toast.makeText(TimeStampChkActivity.this, sdf.format(currenTimeZone), Toast.LENGTH_SHORT).show();
        val timeFormated = getTimestampAsDateString(timeAsLong) + " - " + getTimestampAsTimeString(timeAsLong)
        //tvTimest.setText(sdf.format(currenTimeZone));
        var healthStatusString = ""
        healthStatusString = when (healthStatus) {
            BatteryManager.BATTERY_HEALTH_UNKNOWN -> context.getString(R.string.szBatUnknown)
            BatteryManager.BATTERY_HEALTH_GOOD -> context.getString(R.string.szGood)
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> context.getString(R.string.szBatOverheat)
            BatteryManager.BATTERY_HEALTH_DEAD -> context.getString(R.string.szBatDead)
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> context.getString(R.string.szBatOvervoltage)
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> context.getString(R.string.szBatUnspec)
            BatteryManager.BATTERY_HEALTH_COLD -> context.getString(R.string.szBatCold)
            else -> context.getString(R.string.szBatUnknown)
        }
        tvEvent.text = healthStatusString
        val ivMemo = view.findViewById<ImageView>(R.id.ivHealthIcon)
        if (healthStatus == 2) {
            ivMemo.setImageResource(R.drawable.good)
        } else {
            ivMemo.setImageResource(R.drawable.bad)
        }
    }


     */


    private fun getTimestampAsDateString(timestamp: Long): String {
        val cal = Calendar.getInstance()
        cal.timeInMillis = timestamp
        return DateFormat.format("dd.MM.yy", cal).toString()
    }

    private fun getTimestampAsTimeString(timestamp: Long): String {
        val cal = Calendar.getInstance()
        cal.timeInMillis = timestamp
        return DateFormat.format("HH:mm", cal).toString()
    }

}