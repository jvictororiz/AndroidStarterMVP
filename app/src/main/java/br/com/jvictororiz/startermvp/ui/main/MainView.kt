package br.com.jvictororiz.startermvp.ui.main

import androidx.annotation.StringRes
import br.com.jvictororiz.startermvp.data.entities.User

interface MainView {

    fun showLoad(show: Boolean)
    fun showError(error: String)
    fun resultSuccesOnline(users: List<User>)
    fun resultSuccesOffline(users: List<User>)

}