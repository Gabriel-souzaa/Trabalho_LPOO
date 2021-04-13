import java.util.*;

public class Cadastro {
    
    ArrayMateriaNota arrayMatNot;
    private ArrayList<Double> media;
    private double mediaFinal;
    private double coeficiente;
    
    //Contructor
    public Cadastro(){
        this.arrayMatNot = new ArrayMateriaNota();
        this.media = new ArrayList();
    }
    
    //Cadastro de meterias e notas
    public void cadastroMateriaNota(MateriaNota aMateriaNota){
        this.arrayMatNot.addMateria(aMateriaNota.materias);
        this.arrayMatNot.addMateriaNota(aMateriaNota);
    }
    
    //Listar todas materias
    public void listarMterias(){
        System.out.println("👉👉👉👉👉 \033[1;32m MATERIAS  \u001B[0m👈👈👈👈👈");
        
        System.out.println("\033[1;33m✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ \u001B[0m");
        
        System.out.println("");
        for(Materia materiass: this.arrayMatNot.getMaterias()){
            System.out.println("\033[1;34m*\u001B[0m Matéria: " + materiass.getMateria());
            
            System.out.println();
        }
        System.out.println("\033[1;33m✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ \u001B[0m");
    }
    
    //Buscando por um ano especifico
    public void anoEspecifico(int anoMateria){
        System.out.println("👉👉👉👉👉 \033[1;32m ANO ESPECÍFICO  \u001B[0m👈👈👈👈👈");
        System.out.println("\033[1;33m✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏\u001B[0m");
        
        System.out.println("");
        for(Materia materiass: this.arrayMatNot.getMaterias()){
            if(materiass.getAnoMateria() == anoMateria){
                System.out.println("\033[1;34m*\u001B[0m Matéria: " + materiass.getMateria());
                System.out.println("\033[1;32m*\u001B[0m Ano: " + materiass.getAnoMateria());
            
                System.out.println();
            }
        }
        System.out.println("\033[1;33m✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ \u001B[0m");
    }
    
    public void aprovadoReprovado(){
        System.out.println("👉👉👉👉👉 \033[1;32m Matérias Aprovadas/Reprovadas  \u001B[0m👈👈👈👈👈");
        System.out.println("\033[1;33m✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏\u001B[0m");
        for(MateriaNota mt: arrayMatNot.getMateriaNota()){
            System.out.println("\033[1;34m*\u001B[0m Matéria: " + mt.materias.getMateria());
            
            this.mediaCalculo(mt.nota.getNp1(), mt.nota.getNp2(), mt.nota.getSub(), mt.nota.getExame(), "aprovacaoReprovacao");
            
            this.media.clear();
            
            this.aprovacao(this.getMediaFinal());
            System.out.println();
        }
        
        System.out.println("\033[1;33m✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏\u001B[0m");
    }
    
    //Ralatório da Materia
    public void relatorio(){
        int dividorCoeficiente = 0;
        
        
        System.out.println("👉👉👉👉👉 \033[1;32m TELA DE RELATÓRIOS  \u001B[0m👈👈👈👈👈");
        System.out.println("\033[1;33m✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ \u001B[0m");
        
        System.out.println();
        System.out.println("---------");
        
        //Varrendo todas as informações de materias e todas para listar no relatório;
        for(MateriaNota mt: arrayMatNot.getMateriaNota()){
            dividorCoeficiente +=1;
            
            //Materias
            System.out.println("\033[1;34m*\u001B[0m Matéria: " + mt.materias.getMateria() + " Ano: " + mt.materias.getAnoMateria());
            
            //Calculo da media final
            this.mediaCalculo(mt.nota.getNp1(), mt.nota.getNp2(), mt.nota.getSub(), mt.nota.getExame(), "relatorio");
            
            //Limpar o array para o proximo calculo
            this.media.clear();
            
            //Aprovação da Materia
            this.aprovacao(this.getMediaFinal());
            
            //Somando medias
            this.coeficiente = (this.coeficiente + this.getMediaFinal());
            
            //Espaço
            System.out.println("---------");
            System.out.println();
        }
        
        System.out.println("\033[1;33m✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ ✏ \u001B[0m");
        
        System.out.println();
        
        //Coeficiente
        System.out.println("👉👉👉👉👉 \033[1;32m COEFICIENTES  \u001B[0m👈👈👈👈👈");
        System.out.println("\033[1;32m*\u001B[0m Coeficiente (media total) = " + this.coeficiente / dividorCoeficiente);
        System.out.println("");
    }
    
    //Calculo da media
    public void mediaCalculo(double np1, double np2, double sub, double exam, String metodoChamada){
        this.media.add(np1);
        this.media.add(np2);
        this.media.add(sub);
        
        Collections.sort(this.media, Collections.reverseOrder());
        this.setMedia((media.get(0) + media.get(1)) / 2);
        
        if(this.getMediaFinal() >= 7){
            if(metodoChamada == "relatorio"){
                System.out.println("\033[1;32m*\u001B[0m " + this.getMediaFinal() + " é a média final");
            }
        }
        
        if(this.getMediaFinal() < 7){
            this.mediaFinal = (this.getMediaFinal() + exam) /2;
            if(metodoChamada == "relatorio"){
                System.out.println("\033[1;32m*\u001B[0m " + this.getMediaFinal() + " é a média final (com exame)");
            }
        }
    }
    
    //Veirificando se foi aprovado ou não
    public String aprovacao(double media){
        if(media >=5){
            System.out.println("\u001B[32m" + "Matéria Aprovada" + "\u001B[0m");
            return "aprovado";
        }else{
            System.out.println("\u001B[31m" + "Matéria Reprovado" + "\u001B[0m");
            return "reprovado";
        }
        
    }
    
    public double getMediaFinal(){
        return this.mediaFinal;
    }
    
    public void setMedia(double media){
        this.mediaFinal = media;
    }
}
