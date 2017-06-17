package com.github.droibit.actionview.progress.sample

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ToolbarFragmentActivity : AppCompatActivity() {

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, ToolbarFragmentActivity::class.java)
        }
    }

    class ToolbarFragment : Fragment() {

        companion object {

            fun newInstance() = ToolbarFragment()
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
            return inflater.inflate(R.layout.fragment_toolbar, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val toolbar = view.findViewById(R.id.toolbar) as Toolbar
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
                title = ToolbarFragment::class.java.simpleName
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_fragment)

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ToolbarFragment.newInstance())
                .commit()
    }
}
