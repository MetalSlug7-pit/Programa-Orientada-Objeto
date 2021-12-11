class Retangulo {
		int x1, y1, x2, y2;
		
		public Retangulo(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
		
		public int getArea() {
			int a = x2 - x1;
			int b = y2 - y1;
			return a*b;
		}	
	}

public class Principal {
	
	public static void main(String[] args) {
		Retangulo r=new Retangulo(0,0,10,10);
		
		System.out.println("Area do retangulo: " + r.getArea());
	}

}
