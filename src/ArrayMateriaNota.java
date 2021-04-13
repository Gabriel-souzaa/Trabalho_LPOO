import java.util.ArrayList;

public class ArrayMateriaNota {
    private ArrayList<Materia> materias;
    private ArrayList<Notas> notas;
    private ArrayList<MateriaNota> materiaNota;
    
    public ArrayMateriaNota(){
        materias = new ArrayList<>();
        notas = new ArrayList<>();
        materiaNota = new ArrayList();
    }
    
    public void addMateria(Materia materia){
        materias.add(materia);
    }
    
    public ArrayList<Materia> getMaterias(){
        return materias;
    }
    
    public void addNotas(Notas nota){
        notas.add(nota);
    }
    
    public ArrayList<Notas> getNotas(){
        return notas;
    }
    
    public void addMateriaNota(MateriaNota aMateriaNota){
       materiaNota.add(aMateriaNota);
    }
    
    public ArrayList<MateriaNota> getMateriaNota(){
        return materiaNota;
    }
}
