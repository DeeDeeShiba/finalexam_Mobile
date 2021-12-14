package sheridan.romeroad.finalexam.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * Student ID: 991555778
 * finalexam
 * created by davidromero
 * on 2021-12-14
 **/
@Dao
interface EnvelopeDao {
    @Insert
    suspend fun insert(envelope: EnvelopeEntity): Long

    @Query("SELECT * FROM envelope WHERE name=:name")
    fun get(name: Long) : LiveData<EnvelopeEntity>

    @Query("SELECT * FROM envelope ORDER BY date DESC")
    fun getAll() : LiveData<List<EnvelopeEntity>>

    @Delete
    suspend fun delete(envelope: EnvelopeEntity)

    @Query("DELETE FROM envelope WHERE name=:name")
    suspend fun delete(name: Long)

    @Query("DELETE FROM envelope")
    suspend fun deleteAll()
}