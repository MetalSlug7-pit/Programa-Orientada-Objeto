public class Principal {
	
	public static void main(String[] args) {
        
        Quadrado quadrado=new Quadrado();
        quadrado.draw();
        
        Circulo circulo=new Circulo();
        circulo.draw();
        
        Triangulo triangulo=new Triangulo();
        triangulo.draw();
        
        passaParametroPorHeranca(quadrado);
        passaParametroPorHeranca(circulo);
        passaParametroPorHeranca(triangulo);
        
    }
    
    public static void passaParametroPorHeranca(Figura fig){
        fig.drawShape();
    }
}
