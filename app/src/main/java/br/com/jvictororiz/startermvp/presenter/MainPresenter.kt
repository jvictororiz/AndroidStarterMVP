package br.com.jvictororiz.startermvp.presenter

import br.com.jvictororiz.startermvp.service.UserRepository
import br.com.jvictororiz.startermvp.ui.main.MainView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject

class MainPresenter(val view: MainView) {

    private val repository: UserRepository by inject(UserRepository::class.java)

    fun findAllUser() {
        GlobalScope.launch {
            view.showLoad(true)
            val result = repository.listAll()
            withContext(Dispatchers.Main) {
                when {
                    result.isSuccessful() -> {
                        result.data?.let { view.resultSuccesOnline(it) }
                    }
                    result.isCacheSuccessful() -> {
                        result.data?.let { view.resultSuccesOffline(it) }
                    }
                    else -> {
                        view.showError(result.errorMessage())
                    }
                }
                view.showLoad(false)
            }
        }
    }
}