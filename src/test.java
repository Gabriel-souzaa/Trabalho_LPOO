public class test {
    
    public static void main(String[] args) {
        Cadastro c = new Cadastro();
        
        //Cadastro de materias/notas
        c.cadastroMateriaNota(new MateriaNota(new Materia("Estatistica",2021), new Notas(4.0,4.0,4.9,5.0)));
        c.cadastroMateriaNota(new MateriaNota(new Materia("LPOO",2020), new Notas(9.0,3.0,8.9,7.0)));
        c.cadastroMateriaNota(new MateriaNota(new Materia("Matematica",2021), new Notas(2.0,1.0,8.9,3.0)));
        //c.cadastroMateriaNota(new MateriaNota(new Materia("Banco de dados",2021), new Notas(4.0,4.0,4.9,5.0)));
        
        //Imprmir todas Materias
        //c.listarMterias();
        
        //Imprimir materias de um ano especifico
        //c.anoEspecifico(2021);
        
        //Imprimir meterias aprovadas/reprovadas
        //c.aprovadoReprovado();
        
        //Relatório para saber se foi aprovado ou reprovado
        c.relatorio();
    }
}
