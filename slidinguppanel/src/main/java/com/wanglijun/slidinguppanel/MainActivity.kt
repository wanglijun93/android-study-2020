package com.wanglijun.slidinguppanel

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState
import kotlinx.android.synthetic.main.activity_demo.*

class MainActivity : AppCompatActivity() {
    private val itemList =
        listOf(
            "This",
            "Is",
            "An",
            "Example",
            "ListView",
            "That",
            "You",
            "Can",
            "Scroll",
            ".",
            "It",
            "Shows",
            "How",
            "Any",
            "Scrollable",
            "View",
            "Can",
            "Be",
            "Included",
            "As",
            "A",
            "Child",
            "Of",
            "SlidingUpPanelLayout"
        )
    private val TAG = "DemoActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        initListView()
        initSlidingUp()
        follow.setOnClickListener { sliding_layout.panelState = PanelState.HIDDEN }
        main.setOnClickListener { Toast.makeText(this, "点击了首页", Toast.LENGTH_SHORT).show() }
        show.setOnClickListener {
            if (sliding_layout.panelState != PanelState.HIDDEN) {
                sliding_layout.panelState = PanelState.HIDDEN
            } else {
                sliding_layout.panelState = PanelState.COLLAPSED
            }
        }
    }

    private fun initSlidingUp() {
        sliding_layout.addPanelSlideListener(object : SlidingUpPanelLayout.PanelSlideListener {
            override fun onPanelSlide(
                panel: View,
                slideOffset: Float
            ) {
                Log.i(TAG, "onPanelSlide, offset $slideOffset")
            }

            override fun onPanelStateChanged(
                panel: View,
                previousState: PanelState,
                newState: PanelState
            ) {
                Log.i(TAG, "onPanelStateChanged $newState")
            }
        })
        sliding_layout.setFadeOnClickListener(View.OnClickListener {
            sliding_layout.panelState = PanelState.COLLAPSED
        })
    }

    private fun initListView() {
        list.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "onItemClick$position", Toast.LENGTH_SHORT).show()
        }
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            itemList
        )
        list.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.demo, menu)
        val item = menu.findItem(R.id.action_toggle)
        if (sliding_layout != null) {
            if (sliding_layout.panelState == PanelState.HIDDEN) {
                item.setTitle(R.string.action_show)
            } else {
                item.setTitle(R.string.action_hide)
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_toggle -> {
                if (sliding_layout != null) {
                    if (sliding_layout.panelState != PanelState.HIDDEN) {
                        sliding_layout.panelState = PanelState.HIDDEN
                        item.setTitle(R.string.action_show)
                    } else {
                        sliding_layout.panelState = PanelState.COLLAPSED
                        item.setTitle(R.string.action_hide)
                    }
                }
                return true
            }
            R.id.action_anchor -> {
                if (sliding_layout != null) {
                    if (sliding_layout.anchorPoint == 1.0f) {
                        sliding_layout.anchorPoint = 0.7f
                        sliding_layout.panelState = PanelState.ANCHORED
                        item.setTitle(R.string.action_anchor_disable)
                    } else {
                        sliding_layout.anchorPoint = 1.0f
                        sliding_layout.panelState = PanelState.COLLAPSED
                        item.setTitle(R.string.action_anchor_enable)
                    }
                }
                return true
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (sliding_layout != null &&
            (sliding_layout.panelState == PanelState.EXPANDED ||
                    sliding_layout.panelState == PanelState.ANCHORED)
        ) {
            sliding_layout.panelState = PanelState.COLLAPSED
        } else {
            super.onBackPressed()
        }
    }
}
