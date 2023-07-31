package utilidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSuma()
	{
		assertSame(5, Calculadora.suma(3, 2), "La suma debería devolver 5");
		assertSame(2, Calculadora.suma(-3, 5), "La suma debería devolver 2");
	}
	
	@Test
	void testSumaAll()
	{
		assertAll
		(
			() -> assertSame(5, Calculadora.suma(3, 2), "La suma debería devolver 5"),
			() -> assertSame(2, Calculadora.suma(-3, 5), "La suma debería devolver 2")
		);
	}

	@Test
	void testDivide()
	{
		assertSame(2, Calculadora.divide(4, 2), "La división debería devolver 2");
		assertThrows(ArithmeticException.class, () -> Calculadora.divide(4, 0));
	}

	@Test
	void testPotencia() throws ExponenteDebeSerPositivoException
	{
		assertSame(9, Calculadora.potencia(3, 2), "La potencia debería devolver 9");
		assertSame(1, Calculadora.potencia(-9, 0), "Todos los numeros elevados a 0 dan 1");
		assertThrows(ExponenteDebeSerPositivoException.class, () -> Calculadora.potencia(9, -2));
	}
	
	@Test
	void testCalculaRetencion()
	{
		assertEquals(0.01 * 500, Calculadora.calculaRetencion(2, 500), "Debe devolver un 1% de 500, es decir, 5");
		assertEquals(0, Calculadora.calculaRetencion(6, 500), "Debe devolver un 0% de 500, es decir, 0");
		assertEquals(1600 * 0.03, Calculadora.calculaRetencion(1, 1600), "Debe devolver un 3% de 1600, es decir, " + 1600 * 0.03);
		assertEquals(1600 * 0.02, Calculadora.calculaRetencion(4, 1600), "Debe devolver un 2% de 1600, es decir, " + 1600 * 0.02);
		assertEquals(2500 * 0.12, Calculadora.calculaRetencion(0, 2500), "Debe devolver un 12% de 2500, es decir, " + 2500 * 0.12);
		assertEquals(2500 * 0.08, Calculadora.calculaRetencion(4, 2500), "Debe devolver un 8% de 2500, es decir, " + 2500 * 0.08);
		//casos límite
		assertEquals(1000 * 0.03, Calculadora.calculaRetencion(1, 1000),"Debe devolver un 3% de 100, es decir " + 1000 * 0.03);
		assertEquals(1000 * 0.02, Calculadora.calculaRetencion(5, 1000),"Debe devolver un 2% de 100, es decir " + 1000 * 0.02);
		assertEquals(1000 * 0.02, Calculadora.calculaRetencion(3, 1000),"Debe devolver un 2% de 100, es decir " + 1000 * 0.02);

		assertEquals(2000 * 0.03, Calculadora.calculaRetencion(1, 2000),"Debe devolver un 3% de 100, es decir " + 2000 * 0.03);
		assertEquals(2000 * 0.02, Calculadora.calculaRetencion(5, 2000),"Debe devolver un 2% de 100, es decir " + 2000 * 0.02);
		assertEquals(2000 * 0.02, Calculadora.calculaRetencion(3, 2000),"Debe devolver un 2% de 100, es decir " + 2000 * 0.02);
	}
	
	@BeforeAll
	public static void inicializar ()
	{
		System.out.println("Inicializando los Test...");
	}
	
	@AfterAll
	public static void finalizar ()
	{
		System.out.println("Liberando recursos...");
	}
	
	@BeforeEach
	public void inicioTest ()
	{
		System.out.println("Iniciando nuevo test...");
	}
	
	@AfterEach
	public void finTest ()
	{
		System.out.println("Finalizando test...");
	}
}
