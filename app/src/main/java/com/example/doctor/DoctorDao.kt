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
interface DoctorDao {
    @Query("SELECT * FROM doctors")
    fun getAllDoctors(): LiveData<List<Doctor>>

    @Query("SELECT * FROM doctors WHERE id = :doctorId")
    fun getDoctorById(doctorId: Long): LiveData<Doctor>

    @Query("SELECT * FROM doctors WHERE specialty = :specialty")
    fun getDoctorsBySpecialty(specialty: String): LiveData<List<Doctor>>

    @Query("SELECT * FROM doctors WHERE specialtyId = :specialtyId")
    fun getDoctorsBySpecialtyId(specialtyId: Long): LiveData<List<Doctor>>

    @Query("SELECT * FROM doctors WHERE name LIKE '%' || :query || '%'")
    fun searchDoctors(query: String): LiveData<List<Doctor>>

    @Query("SELECT * FROM doctors ORDER BY rating DESC LIMIT 10")
    fun getTopDoctors(): LiveData<List<Doctor>>

    @Query("SELECT * FROM doctors WHERE isFavorite = 1")
    fun getFavoriteDoctors(): LiveData<List<Doctor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoctor(doctor: Doctor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDoctors(doctors: List<Doctor>)

    @Update
    suspend fun updateDoctor(doctor: Doctor)

    @Query("UPDATE doctors SET isFavorite = :isFavorite WHERE id = :doctorId")
    suspend fun updateFavoriteStatus(doctorId: Long, isFavorite: Boolean)
}