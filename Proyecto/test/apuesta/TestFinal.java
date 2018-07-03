package apuesta;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;

	public class TestFinal {
		private Apuesta stubApuesta;
		private TipoApuesta finalSUT;

			@Before
			public void setUp() {
				finalSUT = new Final();
				stubApuesta = mock(Apuesta.class);
			}
			
			@Test
			public void testAlCancelarTiraError() throws Exception {
				finalSUT.cancelar(stubApuesta);
				verify(stubApuesta, never());
				//Falta implementar, como corroborar que la excepcion se lance?
			}
			
			@Test
			public void testAlReactivarTiraError()throws Exception{
				finalSUT.reactivar(stubApuesta);
				verify(stubApuesta, never());
				//Falta implementar, como corroborar que la excepcion se lance?
			}
			
			@Test
			public void testLaGananciaBrutaEsLaMultiplicacionEntreLaCuotaConvenidaYElMonto() {
				Float dos = new Float(2);
				Float cuatro = new Float(4);
				
				when(stubApuesta.cuotaConvenida()).thenReturn(dos);
				when(stubApuesta.monto()).thenReturn(cuatro);
				
				BigDecimal esperado = new BigDecimal(dos * cuatro); 
				assertEquals(esperado, finalSUT.gananciaBruta(stubApuesta));
			}
}
