package mx.edu.utez.IntJosX.service;

import mx.edu.utez.IntJosX.model.dto.PersonDto;
import mx.edu.utez.IntJosX.model.entity.PersonBean;

import java.util.List;

public interface IPerson {

    PersonBean save(PersonDto person);

    PersonBean findById(Integer id);

    List<PersonBean>findAll();

    void delete(PersonBean person);
}
