package dev.jhordycg.dbconnection_examples.controller

import dev.jhordycg.dbconnection_examples.entity.Person
import dev.jhordycg.dbconnection_examples.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping(path = ["/person"])
class PersonController {
    @Autowired
    private lateinit var repository: PersonRepository

    @PostMapping
    @ResponseBody
    fun addNew(
        @RequestBody person: Person,
    ): Person {
        repository.save(person)
        return person
    }

    @DeleteMapping(path = ["/delete"])
    @ResponseBody
    @Transactional
    fun deleteByDni(
        @RequestParam dni: String,
    ): String {
        repository.deleteByDni(dni)
        return dni
    }

    @GetMapping(path = ["/all"])
    @ResponseBody
    fun getAllUsers(): Iterable<Person?>? {
        return repository.findAll()
    }
}