package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, Long> {

    Set<T> findAll();
    T findById(Long id);
    T save(T object);
    void delete(T object);
    void deleteById(Long id);

}
