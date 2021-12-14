package sheridan.romeroad.finalexam.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import sheridan.romeroad.finalexam.domain.PetType

/**
 * Student ID: 991555778
 * finalexam
 * created by davidromero
 * on 2021-12-14
 **/
@Entity(tableName = "envelope")
data class EnvelopeEntity(

    @PrimaryKey(autoGenerate = true)
    var name: Long,

    @ColumnInfo(name = "pet_type")
    val petType: PetType,

    @ColumnInfo(name = "age")
    val age: Int,

    @ColumnInfo(name = "date")
    val isVax: Boolean,
)