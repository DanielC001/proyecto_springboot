package com.doctores.doctores.domains.responses

import java.time.Instant

data class CreatePatientResponse(
        val id_paciente: Long,
        val nombre: String,
        val apellido: String,
        val identificacion: String,
        val telefono: Long?,
        val createAt: Instant,
        val updateAt: Instant
)
