package br.com.jvictororiz.startermvp.data.dao

import androidx.annotation.VisibleForTesting
import androidx.room.*
import br.com.jvictororiz.startermvp.data.dao.entities.UserTable

@Dao
interface UserDao {
    @Query("SELECT * from UserTable")
    fun findAll(): List<UserTable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(listUsers: List<UserTable>)

    @VisibleForTesting
    @Query("DELETE FROM UserTable")
    fun clearAll()
}
