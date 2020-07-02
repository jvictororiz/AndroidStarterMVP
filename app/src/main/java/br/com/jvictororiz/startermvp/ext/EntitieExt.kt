package br.com.jvictororiz.startermvp.ext

import br.com.jvictororiz.startermvp.data.dao.entities.UserTable
import br.com.jvictororiz.startermvp.data.entities.User

fun User.toUserTable(): UserTable{
    return UserTable(id, username, img, name)
}

fun UserTable.toUser() :User{
    return User(img, name, id, username)
}