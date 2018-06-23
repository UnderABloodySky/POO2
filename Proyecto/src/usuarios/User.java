package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList; 
import java.util.List;

import EventoDeInteres.Interesante;
import EventoDeInteres.Interesado;
import apuesta.Apuesta;
import casaDeApuesta.CasaDeApuestas;

public class User extends Interesado{
	private List<Apuesta> apuestas;
	private String mail;
	
		public User(String _mail){
			apuestas = new ArrayList<Apuesta>(0);
			this.setMail(_mail);
		}
		
		public User(List<Apuesta> _apuestas){
			apuestas = _apuestas;
		}
		
			public void setMail(String _mail) {
				mail = _mail;
			}
			
			//creo que hay que pasarle la apuesta a la cual se refiere la ganacia bruta y neta 
			public BigDecimal gananciaBruta() {
				BigDecimal total = new BigDecimal(0); 
				for(Apuesta apuesta : apuestas) {
					total.add(apuesta.gananciaBruta());
				}
				return total;
			}
			
			public BigDecimal gananciaNeta() {
				BigDecimal total = new BigDecimal(0); 
				for(Apuesta apuesta : apuestas) {
					total.add(apuesta.gananciaNeta());
				}
				return total;
			}
		
			public void agregarNuevaApuesta(Apuesta _apuesta) {
				apuestas.add(_apuesta);
			}
			
			
			public List<Apuesta> apuestasPropias(){			
				return apuestas;
				
			}
	
			@Override
			public void cambio(Interesante eventoDeInteres) {
				//No queda claro que hace
			}
	
			public boolean leInteresa(Interesante eventoDeInteres) {
				return this.apostoAEsteEvento(eventoDeInteres);
			}
	
			private boolean apostoAEsteEvento(Interesante eventoDeInteres) {
				List<Interesante> listaDePartidosApostados = new ArrayList<Interesante>();
				for(Apuesta _apuesta : apuestas) {
					listaDePartidosApostados.add(_apuesta.getEventoDeInteres());
				}
				return listaDePartidosApostados.contains(eventoDeInteres);
			}
	
			public String getMail() {
				return mail;
			}		
}
