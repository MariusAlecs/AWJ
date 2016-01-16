package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
public class MedicamentController {
  private List<Medicament> medicamente = new ArrayList<Medicament>();

  MedicamentController() {
    Medicament m1 = new Medicament(1561891, "Baneocin", 22112017);
    Medicament m2 = new Medicament(18651191, "Diclofenac", 30012016);
    Medicament m3 = new Medicament(1891895, "Nurofen", 19072020);

    medicamente.add(m1);
    medicamente.add(m2);
    medicamente.add(m3);
  }

  @RequestMapping(value="/medicament", method = RequestMethod.GET)
  public List<Medicament> index() {
    return this.medicamente;
  }

  @RequestMapping(value="/medicament/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Medicament m : this.medicamente) {
      if(m.getId() == id) {
        return new ResponseEntity<Medicament>(m, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/medicament", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Medicament m) {
    this.medicamente.add(m);
	return new ResponseEntity<List<Medicament>>(this.medicamente, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/medicament/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Medicament m : this.medicamente) {
      if(m.getId() == id) {
        this.medicamente.remove(m);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
