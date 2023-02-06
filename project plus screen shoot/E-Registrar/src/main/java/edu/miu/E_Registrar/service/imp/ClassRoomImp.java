package edu.miu.E_Registrar.service.imp;

import edu.miu.E_Registrar.model.Classroom;
import edu.miu.E_Registrar.repository.ClassRoomRepository;
import edu.miu.E_Registrar.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomImp implements ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;
    @Override
    public Classroom addNewClassRoom(Classroom newClassroom) {

        return classRoomRepository.save(newClassroom) ;
    }
}
