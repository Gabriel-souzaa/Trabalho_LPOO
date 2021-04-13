import java.util.ArrayList;

public class Materia {
    private String materia;
    private int anoMateria;
    Notas notas;
    
    public Materia(String aMateria, int aAnoMateria){
        this.materia = aMateria;
        this.anoMateria = aAnoMateria;
    }

    public String getMateria() {
        return this.materia;
    }

    public int getAnoMateria() {
        return this.anoMateria;
    }
    
    public void setMateria(String newMateria) {
        this.materia = newMateria;
    }

    public void setAnoMateria(int newAno) {
        this.anoMateria = newAno;
    }
}
