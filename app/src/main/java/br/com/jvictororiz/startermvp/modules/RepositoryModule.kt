package br.com.jvictororiz.startermvp.modules

import br.com.jvictororiz.startermvp.service.UserRepository
import br.com.jvictororiz.startermvp.service.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(userDao = get(), picPayService = get()) }
}