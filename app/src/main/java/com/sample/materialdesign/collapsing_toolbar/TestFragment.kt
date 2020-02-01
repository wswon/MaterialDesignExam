package com.sample.materialdesign.collapsing_toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sample.materialdesign.R
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val testAdapter = TestRvAdapter()
        rv_test.adapter = testAdapter
        testAdapter.replaceAll(listOf("1", "1", "1", "1", "1", "1", "1", "1", "v", "1"))

    }

}