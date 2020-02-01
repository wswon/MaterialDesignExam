package com.sample.materialdesign.collapsing_toolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.sample.materialdesign.R
import kotlinx.android.synthetic.main.activity_collapsing_toolbar.*

class CollapsingToolbarActivity : AppCompatActivity() {


    val tablist = listOf("1", "2")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar)


        tl_test.bringToFront()

        vp_test.adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(position: Int): Fragment =
                when (position) {
                    0 -> {
                        EmptyFragment()
                    }
                    else -> {
                        TestFragment()
                    }
                }


            override fun getCount(): Int =
                tablist.size


            override fun getPageTitle(position: Int): CharSequence? =
                tablist[position]

        }


        tl_test.setupWithViewPager(vp_test)
    }
}
