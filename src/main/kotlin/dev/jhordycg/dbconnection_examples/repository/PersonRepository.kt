package dev.jhordycg.dbconnection_examples.repository

import dev.jhordycg.dbconnection_examples.entity.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long> {
    fun deleteByDni(dni: String)
}