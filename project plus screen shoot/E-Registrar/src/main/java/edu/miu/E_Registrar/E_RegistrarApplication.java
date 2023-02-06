package edu.miu.E_Registrar;

import edu.miu.E_Registrar.model.Classroom;
import edu.miu.E_Registrar.model.Student;
import edu.miu.E_Registrar.model.Transcript;
import edu.miu.E_Registrar.service.ClassRoomService;
import edu.miu.E_Registrar.service.StudentService;
import edu.miu.E_Registrar.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class E_RegistrarApplication implements CommandLineRunner{

    private StudentService studentService;

    private TranscriptService transcriptService;

    private ClassRoomService classRoomService;

    @Autowired
    public void E_RegistrarApplication(StudentService studentService, TranscriptService transcriptService, ClassRoomService classRoomService){
        this.classRoomService = classRoomService;
        this.studentService = studentService;
        this.transcriptService = transcriptService;
    }

    public static void main(String[] args) {

        SpringApplication.run(E_RegistrarApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello spring boot, Student Management app started......");
        //creating student

        var student1 = new Student(null,"000-61-0001", "Anna","Lynn", "Smith",3.45,
                LocalDate.of(2019,5,24),null,null);
        var saveStudent1=addNewStudent(student1);
        System.out.println(saveStudent1);
        var student2=new Student(null,"000-61-0003", "LEMESSA",
                "TAYE", "ADUGNA",3.49,
                LocalDate.of(2019,6,24),null,null);
        var saveStudent2=addNewStudent(student2);
        System.out.println(saveStudent2);

        // create new Transcript
        var transcript1= new Transcript(null, "BS Computer Science",null);
        var saveTranscript= addNewTranscript(transcript1);
        System.out.println(saveTranscript);

        //create new classroom
        var classroom1= new Classroom(null,"McLaughlin building", "M105",null);
        var saveClassroom= addNewClassRoom(classroom1);
        System.out.println(saveClassroom);



        // get all

        System.out.println("..........all students ............... ");
        var studentsAll = studentService.getAllStudents();
        for(Student students:studentsAll){
            System.out.println(students);
        }

        System.out.println("student management app completed");
        System.out.println("*********************************************************************************************");

    }


    private Student addNewStudent(Student student){
        return studentService.addNewStudent(student);
    }
    Student saveStudent(Student newStudent){
        return studentService.addNewStudent(newStudent);


    }
    Transcript addNewTranscript(Transcript newTranscript){

        return transcriptService.addNewTranscript(newTranscript);
    }
    Classroom addNewClassRoom(Classroom newClassroom){

        return  classRoomService.addNewClassRoom(newClassroom);
    }
}

