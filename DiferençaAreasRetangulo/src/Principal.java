class Retangulo {
		int x1, y1, x2, y2;
		
		public Retangulo(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
		
		public int getArea() {
			int a = Math.abs(x2 - x1);
			int b = Math.abs(y2 - y1);
			return a*b;
		}	
		
		public int calcularDiferencaArea(Retangulo ret) {
			int result = Math.abs(this.getArea() - ret.getArea());
			return result;
		}
	}

public class Principal {
	
	public static void main(String[] args) {
		Retangulo r=new Retangulo(0,0,10,10);
		Retangulo s=new Retangulo(1,1,5,5);
		
		System.out.println("Area da diferença dos retangulos: " + r.calcularDiferencaArea(s));
	}

}
