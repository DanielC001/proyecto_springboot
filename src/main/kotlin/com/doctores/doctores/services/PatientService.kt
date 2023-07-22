package com.doctores.doctores.services

import com.doctores.doctores.domains.entity.Doctor
import com.doctores.doctores.domains.entity.Patient
import com.doctores.doctores.domains.request.CreateDoctorRequest
import com.doctores.doctores.domains.request.CreatePatientRequest
import com.doctores.doctores.domains.responses.CreateDoctorResponse
import com.doctores.doctores.domains.responses.CreatePatientResponse
import com.doctores.doctores.repositories.DoctorRepository
import com.doctores.doctores.repositories.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class PatientService {
    @Autowired
    private lateinit var patientRepository: PatientRepository
    fun createPatient(request: CreatePatientRequest): CreatePatientResponse {
        val patient =  patientRepository.save(
                Patient(
                        nombre = request.nombre,
                        apellido = request.apellido,
                        identificacion = request.identificacion,
                        telefono = request.telefono
                )
        )
        return CreatePatientResponse(
                id_paciente = 1,
                nombre = request.nombre,
                apellido = request.apellido,
                identificacion = request.identificacion,
                telefono = request.telefono,
                createAt = Instant.now(),
                updateAt = Instant.now()
        )
    }

    fun getAllPatients(): List<CreatePatientResponse>{
        var response : List<CreatePatientResponse> = listOf(
                CreatePatientResponse(
                        id_paciente = 1,
                        nombre = "test",
                        apellido = "test",
                        identificacion = "001",
                        telefono = 123,
                        createAt = Instant.now(),
                        updateAt = Instant.now()
                )
        )
        return response
    }

    fun getPatientById(id: Long): CreatePatientResponse {
        var patient: Patient? =  patientRepository.getByPatientId(id)
        if (patient!=null){
            return CreatePatientResponse(
                    id_paciente = patient.id_paciente,
                    nombre = "test",
                    apellido = "test",
                    identificacion = "001",
                    telefono = 123,
                    createAt = Instant.now(),
                    updateAt = Instant.now()
            )
        }else{
            return CreatePatientResponse(
                    id_paciente = 1,
                    nombre = "test",
                    apellido = "test",
                    identificacion = "001",
                    telefono = 123,
                    createAt = Instant.now(),
                    updateAt = Instant.now()
            )
        }
    }

    fun updatePatient(id: Long): CreatePatientResponse {
        return CreatePatientResponse(
                id_paciente = 1,
                nombre = "test",
                apellido = "test",
                identificacion = "001",
                telefono = 123,
                createAt = Instant.now(),
                updateAt = Instant.now()
        )
    }
}