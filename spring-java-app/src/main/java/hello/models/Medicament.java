package hello;

import java.util.List;
import java.util.ArrayList;

public class Medicament {
  private String name;
  private int id;
  private int data_expirare;

  public Medicament() {}

  public Medicament(int id, String name, int data_expirare) {
      this.name = name;
      this.id = id;
	  this.data_expirare = data_expirare;
  }

  public String getName() {
      return this.name;
  }
  
    public int getData_exp() {
    return this.data_expirare;
	}

  public int getId() {
    return this.id;
  }
}
