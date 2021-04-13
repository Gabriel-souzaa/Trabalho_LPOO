public class Notas {
    private double np1;
    private double np2;
    private double exame;
    private double sub;
    
    public Notas(double aNp1, double aNp2, double aExame, double aSub){
        this.np1 = aNp1;
        this.np2 = aNp2;
        this.exame = aExame;
        this.sub = aSub;
    }
    
    public void setNp1(double aNp1) {
        this.np1 = aNp1;
    }

    public double getNp1() {
        return this.np1;
    }
    
    public void setNp2(double aNp2) {
        this.np2 = aNp2;
    }

    public double getNp2() {
        return this.np2;
    }

    public void setExame(double aExame) {
        this.exame = aExame;
    }

    public double getExame() {
        return this.exame;
    }
    
    public void setSub(double aSub) {
        this.sub = aSub;
    }
    
    public double getSub() {
        return this.sub;
    }
}
