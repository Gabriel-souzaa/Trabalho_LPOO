import java.util.*;

public class Cadastro {
    
    ArrayMateriaNota arrayMatNot;
    private ArrayList<Double> media;
    private double mediaFinal;
    private double coeficiente;
    private ArrayList materiasAno;
    private ArrayList mediaMaterias;
    
    //Contructor
    public Cadastro(){
        this.arrayMatNot = new ArrayMateriaNota();
        this.media = new ArrayList();
        this.materiasAno = new ArrayList();
        this.mediaMaterias = new ArrayList();
    }
    
    //Cadastro de meterias e notas
    public void cadastroMateriaNota(MateriaNota aMateriaNota){
        this.arrayMatNot.addMateria(aMateriaNota.materias);
        this.arrayMatNot.addMateriaNota(aMateriaNota);
    }
    
    //Listar todas materias
    public void listarMterias(){
        System.out.println("πππππ \033[1;32m MATERIAS  \u001B[0mπππππ");
        
        System.out.println("\033[1;33mβ β β β β β β β β β β \u001B[0m");
        
        System.out.println("");
        for(Materia materiass: this.arrayMatNot.getMaterias()){
            System.out.println("\033[1;34m*\u001B[0m MatΓ©ria: " + materiass.getMateria());
            
            System.out.println();
        }
        System.out.println("\033[1;33mβ β β β β β β β β β β \u001B[0m");
    }
    
    //Buscando por um ano especifico
    public void anoEspecifico(int anoMateria){
        System.out.println("πππππ \033[1;32m ANO ESPECΓFICO  \u001B[0mπππππ");
        System.out.println("\033[1;33mβ β β β β β β β β β β β β β β β\u001B[0m");
        
        System.out.println("");
        for(Materia materiass: this.arrayMatNot.getMaterias()){
            if(materiass.getAnoMateria() == anoMateria){
                this.materiasAno.add(materiass.getMateria());
                System.out.println("\033[1;34m*\u001B[0m MatΓ©ria: " + materiass.getMateria());
            
                System.out.println();
            }
        }
        if(this.materiasAno.size() <= 0){
            System.out.println("| NΓ£o existe nenhuma matΓ©ria do ano " + anoMateria + " |");
            System.out.println();
        }
        System.out.println("\033[1;33mβ β β β β β β β β β β β β β β β \u001B[0m");
    }
    
    public void aprovadoReprovado(){
        System.out.println("πππππ \033[1;32m MatΓ©rias Aprovadas/Reprovadas  \u001B[0mπππππ");
        System.out.println("\033[1;33mβ β β β β β β β β β β β β β β β β β β\u001B[0m");
        for(MateriaNota mt: arrayMatNot.getMateriaNota()){
            System.out.println("\033[1;34m*\u001B[0m MatΓ©ria: " + mt.materias.getMateria());
            
            this.mediaCalculo(mt.nota.getNp1(), mt.nota.getNp2(), mt.nota.getSub(), mt.nota.getExame(), "aprovacaoReprovacao");
            
            this.media.clear();
            
            this.aprovacao(this.getMediaFinal());
            System.out.println();
        }
        
        System.out.println("\033[1;33mβ β β β β β β β β β β β β β β β β β β\u001B[0m");
    }
    
    //RalatΓ³rio da Materia
    public void relatorio(){
        int dividorCoeficiente = 0;
        
        
        System.out.println("πππππ \033[1;32m TELA DE RELATΓRIOS  \u001B[0mπππππ");
        System.out.println("\033[1;33mβ β β β β β β β β β β β β β β \u001B[0m");
        
        System.out.println();
        System.out.println("---------");
        
        //Varrendo todas as informaΓ§Γ΅es de materias e todas para listar no relatΓ³rio;
        for(MateriaNota mt: arrayMatNot.getMateriaNota()){
            dividorCoeficiente +=1;
            
            //Materias
            System.out.println("\033[1;34m*\u001B[0m MatΓ©ria: " + mt.materias.getMateria());
            
            //Calculo da media final
            this.mediaCalculo(mt.nota.getNp1(), mt.nota.getNp2(), mt.nota.getSub(), mt.nota.getExame(), "relatorio");
            
            //Limpar o array para o proximo calculo
            this.media.clear();
            
            //AprovaΓ§Γ£o da Materia
            this.aprovacao(this.getMediaFinal());
            
            //Add medias no array para verificar qual Γ© maior/menos
            this.mediaMaterias.add(this.getMediaFinal());
            //this.maiorMenorMedia();
            
            //Somando medias
            this.coeficiente = (this.coeficiente + this.getMediaFinal());
            
            //EspaΓ§o
            System.out.println("---------");
            System.out.println();
        }
        
        System.out.println("\033[1;33mβ β β β β β β β β β β β β β β \u001B[0m");
        
        //Maior e menor MatΓ©ria
        this.maiorMenorMedia();
        
        System.out.println();
        
        System.out.println("\033[1;33mβ β β β β β β β β β β β β β β \u001B[0m");
        
        //Coeficiente
        System.out.println("πππππ \033[1;32m COEFICIENTES  \u001B[0mπππππ");
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
                System.out.println("\033[1;32m*\u001B[0m " + this.getMediaFinal() + " Γ© a mΓ©dia final");
            }
        }
        
        if(this.getMediaFinal() < 7){
            this.mediaFinal = (this.getMediaFinal() + exam) /2;
            if(metodoChamada == "relatorio"){
                System.out.println("\033[1;32m*\u001B[0m " + this.getMediaFinal() + " Γ© a mΓ©dia final (com exame)");
            }
        }
    }
    
    //Veirificando se foi aprovado ou nΓ£o
    public String aprovacao(double media){
        if(media >=5){
            System.out.println("\u001B[32m" + "MatΓ©ria Aprovada" + "\u001B[0m");
            return "aprovado";
        }else{
            System.out.println("\u001B[31m" + "MatΓ©ria Reprovado" + "\u001B[0m");
            return "reprovado";
        }
        
    }
    
    public double getMediaFinal(){
        return this.mediaFinal;
    }
    
    public void setMedia(double media){
        this.mediaFinal = media;
    }
    
    public void maiorMenorMedia(){
        double maior = (double) this.mediaMaterias.get(0);
        double menor = (double) this.mediaMaterias.get(0);
        
        String mensagemMaior = "Maior nota da matΓ©ria";
        String mensagemMenor = "Menor nota da matΓ©ria";

        for(int i = 1; i < this.mediaMaterias.size(); i++){
            double valor = (double) this.mediaMaterias.get(i);
            
            if(maior < valor){
                maior = valor;
            }
            if(menor > valor){
                menor = valor;
            }
        }
        
        System.out.println();
        
        System.out.println("πππππ \033[1;32m MAIOR E MENOR NOTA  \u001B[0mπππππ");
        
        System.out.println();
        
        for(MateriaNota mt: arrayMatNot.getMateriaNota()){
            
            this.mediaCalculo(mt.nota.getNp1(), mt.nota.getNp2(), mt.nota.getSub(), mt.nota.getExame(), "");
            
            if(this.getMediaFinal() == maior){
                System.out.println("\033[1;34m*\u001B[0m MatΓ©ria: " + mt.materias.getMateria());
                System.out.println("\033[1;34m" + mensagemMaior + "\u001B[0m");
                
                System.out.println();
            }
            if(this.getMediaFinal() == menor){
                System.out.println("\033[1;34m*\u001B[0m MatΓ©ria: " + mt.materias.getMateria());
                System.out.println("\033[1;33m" + mensagemMenor + "\u001B[0m");
                System.out.println();
            } 
        }
    }
}
