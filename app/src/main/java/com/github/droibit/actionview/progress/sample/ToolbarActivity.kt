package com.github.droibit.actionview.progress.sample

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.Toolbar

class ToolbarActivity : AppCompatActivity() {

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, ToolbarActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.apply {
            inflateMenu(R.menu.menu2)
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_refresh -> {
                        MenuItemCompat.setActionView(item, R.layout.view_action_progress)
                        Handler().postDelayed({
                            MenuItemCompat.setActionView(item, null)
                        }, 2000L)
                    }
                }
                true
            }
            title = ToolbarActivity::class.java.simpleName
        }
    }
}
