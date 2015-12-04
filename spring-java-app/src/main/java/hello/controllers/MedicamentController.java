package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class MedicamentController {
  private List<Medicament> medicamente = new ArrayList<Medicament>();

  MedicamentController() {
    Medicament med1 = new Medicament(1561891, "Baneocin", 22112017);
    Medicament med2 = new Medicament(18651191, "Diclofenac", 30012016);
    Medicament med3 = new Medicament(1891895, "Nurofen", 19072020);

    medicamente.add(med1);
    medicamente.add(med2);
    medicamente.add(med3);
  }

  @RequestMapping(value="/Medicament", method = RequestMethod.GET)
  public List<Medicament> index() {
    return this.medicamente;
  }

  @RequestMapping(value="/Medicament/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Medicament med : this.medicamente) {
      if(med.getId() == id) {
        return new ResponseEntity<Medicament>(med, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Medicament/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Medicament med : this.medicamente) {
      if(med.getId() == id) {
        this.medicamente.remove(med);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
