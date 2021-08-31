
public class Flor {
	Petala petala;
	
	public void setPetala(Petala petala) {
		this.petala = petala;
	}
	
	public boolean temPetala() {
		if(petala == null)
			return false;
		return true;
	}
	
	public Petala getPetala() {
		return petala;
	}
}
