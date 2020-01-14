package com.sample.materialdesign.collapsing_toolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.materialdesign.R
import kotlinx.android.synthetic.main.activity_collapsing_toolbar.*

class CollapsingToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar)


        rv_test.adapter = TestRvAdapter()
    }
}
