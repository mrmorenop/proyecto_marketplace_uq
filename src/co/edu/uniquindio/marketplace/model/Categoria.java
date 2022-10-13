package co.edu.uniquindio.marketplace.model;

public enum Categoria {
	
	MUEBLE(0), ELECTRODOMESTICO(1), CONSTRUCCION(2);
	
	private int numCategoria;

	private Categoria(int numCategoria) {
		this.numCategoria = numCategoria;
	}

	public int getNumCategoria() {
		return numCategoria;
	}

	public void setNumCategoria(int numCategoria) {
		this.numCategoria = numCategoria;
	}
	
	public Categoria getCategoria(int index){

		switch(index) {

		case 0: return Categoria.MUEBLE;

		case 1: return Categoria.ELECTRODOMESTICO;

		case 2: return Categoria.CONSTRUCCION;

		default: return null;

		}
	}
}
