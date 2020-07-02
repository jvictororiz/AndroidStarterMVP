package br.com.jvictororiz.startermvp.data.dao.databaseConfig

import androidx.room.*
import br.com.jvictororiz.startermvp.data.dao.databaseConfig.AplicationDatabase.Companion.VERSION
import br.com.jvictororiz.startermvp.data.dao.UserDao
import br.com.jvictororiz.startermvp.data.dao.entities.UserTable

@Database(
    entities = [
        UserTable::class
    ],
    version = VERSION
)
abstract class AplicationDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {

        const val NAME = "database-db"
        const val VERSION = 1

    }

}