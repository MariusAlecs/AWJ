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
public class CopilController {
  private List<Copil> copii = new ArrayList<Copil>();

  CopilController() {
    Copil c1 = new Copil(1204515158, "Ionut",2);
    Copil c2 = new Copil(1254598521, "Dacian", 4);
    Copil c3 = new Copil(1245161867, "Bogdan", 6 );

    copii.add(c1);
    copii.add(c2);
    copii.add(c3);
  }

  @RequestMapping(value="/copil", method = RequestMethod.GET)
  public List<Copil> index() {
    return this.copii;
  }

  @RequestMapping(value="/copil/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Copil c : this.copii) {
      if(c.getId() == id) {
        return new ResponseEntity<Copil>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/copil", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Copil c) {
    this.copii.add(c);
	return new ResponseEntity<List<Copil>>(this.copii, new HttpHeaders(), HttpStatus.OK);
  }
  

  @RequestMapping(value="/Copil/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Copil c : this.copii) {
      if(c.getId() == id) {
        this.copii.remove(c);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
