package br.com.jvictororiz.startermvp.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.jvictororiz.startermvp.R
import br.com.jvictororiz.startermvp.data.entities.User
import br.com.jvictororiz.startermvp.presenter.MainPresenter
import br.com.jvictororiz.startermvp.ui.main.adapter.UserListAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(R.layout.activity_main), MainView {

    private val adapter: UserListAdapter by lazy {
        UserListAdapter()
    }
    private val mainPresenter by lazy {
        MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rv_users.adapter = adapter
        setupListeners()
        mainPresenter.findAllUser()
    }

    private fun setupListeners() {
        swipe_refresh.setOnRefreshListener {
            mainPresenter.findAllUser()
        }
    }

    override fun showLoad(show: Boolean) {
        swipe_refresh.isRefreshing = show
    }

    override fun showError(error: String) {
        tv_error.visibility = View.VISIBLE
        rv_users.visibility = View.GONE
        tv_error.text = error
    }

    override fun resultSuccesOnline(users: List<User>) {
        tv_error.visibility = View.GONE
        rv_users.visibility = View.VISIBLE
        adapter.users = users
    }

    override fun resultSuccesOffline(users: List<User>) {
        tv_error.visibility = View.GONE
        rv_users.visibility = View.VISIBLE
        adapter.users = users
    }

}
