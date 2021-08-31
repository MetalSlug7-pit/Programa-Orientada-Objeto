
public class Principal {
	
	public static void main(String[] args) {
		Petala p1 = new Petala();
		p1.setCorPetala("Amarelo");
		
		Petala p2 = new Petala();
		p2.setCorPetala("Verde");
		
		Petala p3 = new Petala();
		p3.setCorPetala("Azul");
		
		Petala p4 = new Petala();
		p4.setCorPetala("Vermelho");
		
		Petala p5 = new Petala();
		p5.setCorPetala("Preto");
		
		Petala p6 = new Petala();
		p6.setCorPetala("Branco");
		
		Petala p7 = new Petala();
		p7.setCorPetala("Roxo");
		
		Petala p8 = new Petala();
		p8.setCorPetala("Rosa");
		
		System.out.println("Cor da petala: " + p1.getCorPetala());
		System.out.println("Cor da petala: " + p2.getCorPetala());
		System.out.println("Cor da petala: " + p3.getCorPetala());
		System.out.println("Cor da petala: " + p4.getCorPetala());
		System.out.println("Cor da petala: " + p5.getCorPetala());
		System.out.println("Cor da petala: " + p6.getCorPetala());
		System.out.println("Cor da petala: " + p7.getCorPetala());
		System.out.println("Cor da petala: " + p8.getCorPetala());
		
		System.out.println("");
		System.out.println("");
		
		Flor amarelinha = new Flor();
		amarelinha.setPetala(p1);
		
		Petala petalaAtual1 = amarelinha.getPetala();
		
		Flor verdinha = new Flor();
		verdinha.setPetala(p2);
		
		Petala petalaAtual2 = verdinha.getPetala();
		
		Flor azulzinha = new Flor();
		azulzinha.setPetala(p3);
		
		Petala petalaAtual3 = azulzinha.getPetala();
		
		Flor vermelinha = new Flor();
		vermelinha.setPetala(p4);
		
		Petala petalaAtual4 = vermelinha.getPetala();
		
		System.out.println("Tem petala: " + amarelinha.temPetala());
		System.out.println("Nome: Amarelinha");
		System.out.println("Cor: " + petalaAtual1.getCorPetala());
		System.out.println("");
		System.out.println("Tem petala: " + verdinha.temPetala());
		System.out.println("Nome: Verdinha");
		System.out.println("Cor: " + petalaAtual2.getCorPetala());
		System.out.println("");
		System.out.println("Tem petala: " + azulzinha.temPetala());
		System.out.println("Nome: Azulzinha");
		System.out.println("Cor: " + petalaAtual3.getCorPetala());
		System.out.println("");
		System.out.println("Tem petala: " + vermelinha.temPetala());
		System.out.println("Nome: Vermelinha");
		System.out.println("Cor: " + petalaAtual4.getCorPetala());
		
		Jardim j1 = new Jardim();
		j1.setFlor(amarelinha);
		j1.setFlor(verdinha);
		
		Jardim j2 = new Jardim();
		j2.setFlor(azulzinha);
		j2.setFlor(vermelinha);
		
		Pracinha pracinha = new Pracinha();
		pracinha.setJardim(j1);
		pracinha.setJardim(j2);
	}
}
