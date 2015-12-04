package hello;

import java.util.List;
import java.util.ArrayList;

public class Copil {
  private String name;
  private int id;
  private int varsta;

  public Copil() {}

  public Copil(int id, String name, int varsta) {
      this.name = name;
      this.id = id;
  this.varsta = varsta;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }

   public int getVarsta() {
    return this.varsta;
  }
  
  }
