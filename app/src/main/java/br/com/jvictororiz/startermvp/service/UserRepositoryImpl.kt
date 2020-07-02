package br.com.jvictororiz.startermvp.service

import br.com.jvictororiz.startermvp.ext.backgroundCall
import br.com.jvictororiz.startermvp.data.dao.UserDao
import br.com.jvictororiz.startermvp.data.dao.entities.UserTable
import br.com.jvictororiz.startermvp.data.entities.ResultRest
import br.com.jvictororiz.startermvp.data.entities.User
import br.com.jvictororiz.startermvp.data.service.PicPayService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface UserRepository {
    suspend fun listAll(): ResultRest<List<User>?>
    suspend fun listAllCache(): List<UserTable>?
    suspend fun saveUsers(users: List<UserTable>)
}


class UserRepositoryImpl(
    private val picPayService: PicPayService,
    private val userDao: UserDao
): UserRepository {

    override suspend fun listAll() = picPayService.getUsers().backgroundCall(Dispatchers.IO)

    override suspend fun listAllCache() = withContext(Dispatchers.Default) { userDao.findAll() }

    override suspend fun saveUsers(users: List<UserTable>) = withContext(Dispatchers.Default) { userDao.saveAll(users) }



}

