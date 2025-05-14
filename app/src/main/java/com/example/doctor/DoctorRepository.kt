package com.example.doctor

import androidx.lifecycle.LiveData
import com.example.doctor.DoctorDao
import com.example.doctor.SpecialtyDao
import com.example.doctor.Doctor
import com.example.doctor.Specialty

class DoctorRepository(
    private val doctorDao: DoctorDao,
    private val specialtyDao: SpecialtyDao
) {
    // Doctors
    val allDoctors: LiveData<List<Doctor>> = doctorDao.getAllDoctors()
    val topDoctors: LiveData<List<Doctor>> = doctorDao.getTopDoctors()
    val favoriteDoctors: LiveData<List<Doctor>> = doctorDao.getFavoriteDoctors()

    fun getDoctorById(doctorId: Long): LiveData<Doctor> {
        return doctorDao.getDoctorById(doctorId)
    }

    fun getDoctorsBySpecialty(specialty: String): LiveData<List<Doctor>> {
        return doctorDao.getDoctorsBySpecialty(specialty)
    }

    fun getDoctorsBySpecialtyId(specialtyId: Long): LiveData<List<Doctor>> {
        return doctorDao.getDoctorsBySpecialtyId(specialtyId)
    }

    fun searchDoctors(query: String): LiveData<List<Doctor>> {
        return doctorDao.searchDoctors(query)
    }

    suspend fun insertDoctor(doctor: Doctor) {
        doctorDao.insertDoctor(doctor)
    }

    suspend fun insertAllDoctors(doctors: List<Doctor>) {
        doctorDao.insertAllDoctors(doctors)
    }

    suspend fun updateDoctor(doctor: Doctor) {
        doctorDao.updateDoctor(doctor)
    }

    suspend fun updateFavoriteStatus(doctorId: Long, isFavorite: Boolean) {
        doctorDao.updateFavoriteStatus(doctorId, isFavorite)
    }

    // Specialties
    val allSpecialties: LiveData<List<Specialty>> = specialtyDao.getAllSpecialties()

    fun getSpecialtyById(specialtyId: Long): LiveData<Specialty> {
        return specialtyDao.getSpecialtyById(specialtyId)
    }

    suspend fun insertSpecialty(specialty: Specialty) {
        specialtyDao.insertSpecialty(specialty)
    }

    suspend fun insertAllSpecialties(specialties: List<Specialty>) {
        specialtyDao.insertAllSpecialties(specialties)
    }
}