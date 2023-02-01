package edu.miu.cs.cs425.fairfieldlibraryapp;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.*;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.AddressService;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.BookService;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDate;

@SpringBootApplication
public class Lesson9JpaFairfieldlibrarycliappApplication implements CommandLineRunner {

    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Lesson9JpaFairfieldlibrarycliappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World of Spring Boot version 3.0.2");
        System.out.println("Starting FairfieldLibraryCLIAPP...");
        // Create 3 new publishers
        var mcgrawHill = new Publisher(null, "McGraw-Hill Publishers, Inc.", "(451) 009-1223", "sales@mcgraw.com", null);
        var apress = new Publisher(null, "Apress, Inc.", "(891) 009-1201", "info@apress.com", null);
        var longman = new Publisher(null, "Longman Publishers", "(451) 009-0001", "sales@longman.net", null);
//        var nullPublisher = new Publisher(null, "   ", "(451) 009-1223", "sales@mcgraw.com");
        var addison_wesley = new Publisher(null, "Addison-Wesley", "(641) 123-1234", "sales@aw.com",
                new Address(null, "101", "N Canon Street", "Des Moines", "IA", "52434", null));

//        var savedMcGrawHill = createNewPublisher(mcgrawHill);
//        var savedApress = createNewPublisher(apress);
//        var savedLongmon = createNewPublisher(longman);
//        var savedNull = createNewPublisher(nullPublisher);
//        var savedAddisonWesley = createNewPublisher(addison_wesley);

        var publishers = getAllPublishers();
        publishers.forEach(System.out::println);

        // Get Publisher by Id
        var publisherId = 1;
        var publisher = getPublisherById(publisherId);
        if(publisher != null) {
            System.out.printf("Publisher with ID, %d is: %s\n", publisherId, publisher);
        } else {
            System.out.printf("Publisher with ID, %d does not exist\n", publisherId);
        }

        // Add Address for McGraw-Hill
//        var mcgrawAddress = new Address(null, "1234", "West Collins Avenue", "Miami", "FL", "76543", null);
//        var savedMcgrawAddress = addressService.addNewAddress(mcgrawAddress);
//        var mcgraw = getPublisherById(publisherId);
//        mcgraw.setPrimaryAddress(savedMcgrawAddress);
//        publisherService.updatePublisherById(publisherId, mcgraw);

        // Update
//        var updatedPublisher = updatePublisher(publisherId);
//        if(updatedPublisher != null) {
//            System.out.printf("Publisher with ID, %d is updated: %s\n", publisherId, updatedPublisher);
//        } else {
//            System.out.printf("Publisher with ID, %d does not exist\n", publisherId);
//        }


        // Delete Publisher by id
//        var deleteStatus = publisherService.deletePublisherById(publisherId);
//        System.out.println(deleteStatus);
        // Option 2: Handles exception
//        try {
//            publisherService.deletePublisherById(publisherId);
//        } catch (EmptyResultDataAccessException ex) {
//            System.out.printf("Publisher with id, %d is not found.", publisherId);
//            System.out.println(ex.toString());
//        }

        getAllPublishers().forEach(System.out::println);

        // Add Book
//        var poeaa = new Book(null, "978-0001", "Patterns of Enterprise App Architecture",
//                LocalDate.of(2021, 11, 12), 10, new Money(25.0, "USD"),
//                new Publisher(null, "Pearsons, Inc", null, null, null), null);
//
//        var savedBook = bookService.addNewBook(poeaa);
//        System.out.println(savedBook);

//        var annaSmith = new Author(null, "Anna", "Smith", null);
//        var bobJones = new Author(null, "Bob", "Jones", null);
//        var coreJava = new Book(null, "978-00098", ""Core Java, Volume 1")

        System.out.println("FairfieldLibraryCLIAPP completed");
    }

    // CRUD operations

    // CREATE new Publisher
    private Publisher createNewPublisher(Publisher newPublisher) {
        return publisherService.addNewPublisher(newPublisher);
    }

    // READ - getAllPublishers
    private Iterable<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    // Find Publishers by Id
    private Publisher getPublisherById(Integer publisherId) {
        return publisherService.getPublisherById(publisherId).orElse(null);
    }

    // Update publisher by id
    private Publisher updatePublisher(Integer publisherId) {
        var publisher = publisherService.getPublisherById(publisherId);
        if(publisher.isPresent()) {
            var longman = publisher.get();
            longman.setName("Longman Publishers, Inc.");
            longman.setEmailAddress("marketing@longman.net");
            return publisherService.updatePublisherById(publisherId, longman);
        } else {
            return null;
        }
    }
}
