package edu.miu.E_Registrar.repository;



import edu.miu.E_Registrar.model.Transcript;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends CrudRepository<Transcript,Integer> {
}
