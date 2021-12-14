package sheridan.romeroad.finalexam.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import sheridan.romeroad.finalexam.database.EnvelopeDao
import sheridan.romeroad.finalexam.database.EnvelopeEntity
import sheridan.romeroad.finalexam.domain.Envelope
import javax.inject.Inject

/**
 * Student ID: 991555778
 * finalexam
 * created by davidromero
 * on 2021-12-14
 **/
class EnvelopeRepositoryRoom @Inject constructor (
    private val envelopeDao: EnvelopeDao
    ):EnvelopeRepository {

    override suspend fun insert(envelope: Envelope): String {
        return envelopeDao.insert(envelope.toEntity()).toString()
    }

    override fun get(id: String): LiveData<Envelope> {
        return envelopeDao.get(id.toLong()).map { it.toEnvelope() }
    }

    override fun getAll() : LiveData<List<Envelope>> {
        return envelopeDao.getAll().map { list -> list.map { item -> item.toEnvelope() }}
    }

    override suspend fun delete(envelope: Envelope){
        if(envelope.name is String){
            envelopeDao.delete(envelope.name.toLong())
        }
    }

    override suspend fun delete(name: String){
        envelopeDao.delete(name.toLong())
    }

    override suspend fun deleteAll(){
        envelopeDao.deleteAll()
    }
}

fun Envelope.toEntity(): EnvelopeEntity {
    return EnvelopeEntity(name?.toLong() ?: 0L, petType, age, isVax)
}

fun EnvelopeEntity.toEnvelope(): Envelope {
    return Envelope(name.toString(), petType, age, isVax)

}