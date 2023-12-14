package mx.edu.utez.IntJosX.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.IntJosX.model.dao.ClienteDao;
import mx.edu.utez.IntJosX.model.dao.EmpleadoDao;
import mx.edu.utez.IntJosX.model.dao.PersonDao;
import mx.edu.utez.IntJosX.model.dto.PersonDto;
import mx.edu.utez.IntJosX.model.entity.ClienteBean;
import mx.edu.utez.IntJosX.model.entity.EmpleadoBean;
import mx.edu.utez.IntJosX.model.entity.PersonBean;
import mx.edu.utez.IntJosX.service.IPerson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplPerson implements IPerson {

    private final PersonDao personDao;
    private final ClienteDao clienteDao;
    private final EmpleadoDao empleadoDao;

    @Override
    @Transactional
    public PersonBean save(PersonDto personDto) {
        PersonBean person = PersonBean.builder()
                .id(personDto.getId())
                .ape1(personDto.getApe1())
                .ape2(personDto.getApe2())
                .nombre(personDto.getNombre())
                .mail(personDto.getMail())
                .tel(personDto.getTel())
                .rol(personDto.getRol())
                .build();

        PersonBean savedPerson = personDao.save(person);

        switch (personDto.getRol().toUpperCase()) {
            case "empleado":
                createEmpleado(savedPerson);
                break;
            case "cliente":
                createCliente(savedPerson);
                break;
            case "EMPLEADO":
                createEmpleado(savedPerson);
                break;
            case "Cliente":
                createCliente(savedPerson);
                break;
            case "CLIENTE":
                createCliente(savedPerson);
                break;
            case "Empleado":
                createEmpleado(savedPerson);
                break;

            default:

                break;
        }

        return savedPerson;
    }

    private void createEmpleado(PersonBean person) {
        EmpleadoBean empleado = EmpleadoBean.builder()
                .personBean(person)
                .build();
        empleadoDao.save(empleado);
    }

    private void createCliente(PersonBean person) {
        ClienteBean cliente = ClienteBean.builder()
                .personBean(person)
                .build();
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonBean findById(Integer id){
        return  personDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonBean> findAll(){
        return (List<PersonBean>) personDao.findAll();
    }

    @Override
    @Transactional
    public void delete(PersonBean person){
        personDao.delete(person);
    }
}
