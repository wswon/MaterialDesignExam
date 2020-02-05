package com.sample.materialdesign.tablayout

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.sample.materialdesign.R
import kotlinx.android.synthetic.main.activity_tab_layout.*
import java.text.SimpleDateFormat
import java.util.*

class TabLayoutActivity : AppCompatActivity() {

    @SuppressLint("SimpleDateFormat")
    private val titleFormat = SimpleDateFormat(getString(R.string.month_format))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        tl_date.run {
            val pastCalendar = Calendar.getInstance().apply {
                set(2016, 0, 1)
            }
            while (true) {
                addTab(newTab().setText(titleFormat.format(pastCalendar.time)))
                pastCalendar.add(Calendar.MONTH, 1)
                if (pastCalendar.time > Date()) {
                    break
                }
            }

            setScrollPosition(tabCount - 1, 0f, true)
        }

        tv_title.post {
            for (i in 0 until tl_date.tabCount) {
                val layout =
                    (tl_date.getChildAt(0) as LinearLayout).getChildAt(i) as LinearLayout
                layout.layoutParams =
                    (layout.layoutParams as LinearLayout.LayoutParams).apply {
                        width = tv_title.width / 3
                    }
            }
            Handler().postDelayed({
                val maxScrollX =
                    hsv_date.getChildAt(0).measuredWidth - windowManager.defaultDisplay.width
                setTabSelectedListener(maxScrollX)

            }, 10)
        }



    }

    private fun setTabSelectedListener(maxScrollX: Int) {
        tl_date.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val scrollX =
                    (tab!!.position - 1) * (maxScrollX / (tl_date.tabCount - 3))

                hsv_date.post {
                    hsv_date.scrollTo(scrollX, 0)
                }

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })
    }
}
