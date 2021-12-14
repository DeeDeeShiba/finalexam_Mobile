package sheridan.romeroad.finalexam.repository

import androidx.lifecycle.LiveData
import sheridan.romeroad.finalexam.domain.Envelope

/**
 * Student ID: 991555778
 * finalexam
 * created by davidromero
 * on 2021-12-14
 **/
interface EnvelopeRepository {
    suspend fun insert(envelope: Envelope): String
    fun get(id: String): LiveData<Envelope>
    fun getAll() : LiveData<List<Envelope>>
    suspend fun delete(envelope: Envelope)
    suspend fun delete(id: String)
    suspend fun deleteAll()
}