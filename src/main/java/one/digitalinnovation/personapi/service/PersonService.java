package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.controller.PersonController;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(Person person) {
        Person saverdPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + saverdPerson.getId())
                .build();
    }
}
