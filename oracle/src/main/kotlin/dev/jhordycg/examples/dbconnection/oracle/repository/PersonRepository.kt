package dev.jhordycg.examples.dbconnection.oracle.repository

import dev.jhordycg.examples.dbconnection.oracle.entity.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long> {
    fun deleteByDni(dni: String)
}