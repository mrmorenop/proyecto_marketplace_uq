package co.edu.uniquindio.marketplace.model;

public enum Estado {

	VENDIDO(0), PUBLICADO(1), CANCELADO(2);
	
	private int numEstado;

	private Estado(int numEstado) {
		this.numEstado = numEstado;
	}

	public int getNumEstado() {
		return numEstado;
	}

	public void setNumEstado(int numEstado) {
		this.numEstado = numEstado;
	}
	
	public Estado getEstado(int index){
		
		switch(index) {

		case 0: return Estado.VENDIDO;

		case 1: return Estado.PUBLICADO;
		
		case 2: return Estado.CANCELADO;

		default: return null;

		}
	}
}
