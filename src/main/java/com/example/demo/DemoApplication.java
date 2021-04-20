package com.example.demo;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Patient;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    @Autowired
    private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"zaineb",new Date(),220,false));
        patientRepository.save(new Patient(null,"Hajar",new Date(),2916,false));
        patientRepository.save(new Patient(null,"Salma",new Date(),163,true));
        patientRepository.save(new Patient(null,"maryam",new Date(),1342,false));
        patientRepository.save(new Patient(null,"abdellah",new Date(),2153,false));
        patientRepository.save(new Patient(null,"Souad",new Date(),220,true));
        patientRepository.save(new Patient(null,"Hamza",new Date(),2916,false));
        patientRepository.save(new Patient(null,"Mouarad",new Date(),163,true));
        patientRepository.save(new Patient(null,"Narjiss",new Date(),1342,false));
        patientRepository.save(new Patient(null,"Naima",new Date(),2153,true));
        patientRepository.findAll().forEach(p->{
        System.out.println(p.getNom());
    });
    }

}
