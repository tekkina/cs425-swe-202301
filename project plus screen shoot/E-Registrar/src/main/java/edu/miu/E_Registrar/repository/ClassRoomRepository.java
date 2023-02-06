package edu.miu.E_Registrar.repository;


import edu.miu.E_Registrar.model.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends CrudRepository<Classroom,Integer> {
}
