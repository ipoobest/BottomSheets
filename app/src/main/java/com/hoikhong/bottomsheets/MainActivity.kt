package com.hoikhong.bottomsheets

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var LayoutBottomSheets: LinearLayout
    lateinit var btnBottomSheet: Button
    lateinit var behavior: BottomSheetBehavior<View>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        bindView()

        bottomSheets()

    }


    private fun bindView() {
        LayoutBottomSheets = findViewById(R.id.bottom_sheet)
        btnBottomSheet = findViewById(R.id.btn_bottom_sheet)
        btnBottomSheet.setOnClickListener(this)

    }

    private fun bottomSheets() {
        behavior = BottomSheetBehavior.from(LayoutBottomSheets)
        behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // React to state change

                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        true
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        btnBottomSheet.text = "Close Sheet"
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        btnBottomSheet.text = "Expand Sheet"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        true
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        true
                    }
                }

                Log.e("onStateChanged", "onStateChanged:" + newState)
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // React to dragging events
                Log.e("onSlide", "onSlide")
            }
        })
    }


    override fun onClick(v: View?) {
        if (v == btnBottomSheet) {
            if (behavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
                btnBottomSheet.text = "Close sheet"
            } else {
                behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                btnBottomSheet.text = "Expand sheet"
            }
        }
    }
}
