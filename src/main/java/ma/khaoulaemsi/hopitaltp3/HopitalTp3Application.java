package ma.khaoulaemsi.hopitaltp3;

import ma.khaoulaemsi.hopitaltp3.entities.Patient;
import ma.khaoulaemsi.hopitaltp3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalTp3Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HopitalTp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //en utilisant un constructeur sans parametres
//        Patient patient = new Patient();
//        patient.setId(null);
//        patient.setNom("Khaoula");
//        patient.setMalade(false);
//        patient.setScore(56);
//        patient.setDateNaissance(new Date());
//
//        //en utilisant contructeur avec parametres
//        Patient patient1=new Patient(null,"Khaoula",new Date(),false,6758);
//
//        //en utilisant builder
//        Patient patient2=Patient.builder()
//                .nom("Khaoula")
//                .dateNaissance(new Date())
//                .score(678)
//                .malade(true)
//                .build();

        patientRepository.save(new Patient(null,"Khaoula",new Date(),false,6758));
        patientRepository.save(new Patient(null,"Najat",new Date(),false,746));
        patientRepository.save(new Patient(null,"Aymane",new Date(),true,74673));
    }
}
