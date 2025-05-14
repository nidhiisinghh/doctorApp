package com.example.doctor

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.doctor.Doctor
import com.example.doctor.Specialty

@Dao
interface SpecialtyDao {
    @Query("SELECT * FROM specialties")
    fun getAllSpecialties(): LiveData<List<Specialty>>

    @Query("SELECT * FROM specialties WHERE id = :specialtyId")
    fun getSpecialtyById(specialtyId: Long): LiveData<Specialty>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpecialty(specialty: Specialty)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSpecialties(specialties: List<Specialty>)
}