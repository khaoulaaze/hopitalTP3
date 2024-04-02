package ma.khaoulaemsi.hopitaltp3.web;

import lombok.AllArgsConstructor;
import ma.khaoulaemsi.hopitaltp3.entities.Patient;
import ma.khaoulaemsi.hopitaltp3.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

//    public PatientController(PatientRepository patientRepository) {
//        this.patientRepository = patientRepository;
//    }
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "3") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String key
                        ){
        //Afficher liste des patients
        //List<Patient>  patientList=patientRepository.findAll();@RequestParam(name = "p",defaultValue = "0")
        //model.addAttribute("ListPatients",patientList);

        //Pagination
        Page<Patient> patientPage=patientRepository.findByNomContains(key,PageRequest.of(page,size));
        model.addAttribute("ListPatients",patientPage.getContent());
        model.addAttribute("pages",new int[patientPage.getTotalPages()]);
        model.addAttribute("CurrentPage",page);
        model.addAttribute("keyword",key);
        return "Patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){

        patientRepository.deleteById(id);
        return  "redirect:/index?page="+page+"&keyword="+keyword    ;
    }

    @GetMapping("/")
    public String home(){
        return  "redirect:/index"   ;
    }
}
