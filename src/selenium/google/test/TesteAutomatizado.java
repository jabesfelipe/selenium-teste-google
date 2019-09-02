/**
 * 
 */
package selenium.google.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author jabes
 *
 */
public class TesteAutomatizado {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		List<NavegadorEnum> listaNavegador = Arrays.asList(NavegadorEnum.values());

		listaNavegador.forEach(item -> System.setProperty(item.getChaveWebDriver(), item.getNomeWebDriver()));

		List<String> listaBuscaGoogle = new ArrayList<String>();

		listaBuscaGoogle.add("Java");
		listaBuscaGoogle.add("Oracle");
		listaBuscaGoogle.add("Angular 7");

		for (String textoBuscar : listaBuscaGoogle) {
			chamarNavegador(textoBuscar);
			Thread.sleep(5000l);
		}

		System.exit(1);

	}

	/**
	 * @param textoBuscar
	 */
	private static void chamarNavegador(String textoBuscar) {
		WebDriver webDriver = new FirefoxDriver();

		webDriver.get(PaginaNavegadorEnum.PAGINA_GOOGLE.getUrlNavegador());

		WebElement webElementInput = webDriver
				.findElement(By.name(PaginaNavegadorEnum.PAGINA_GOOGLE.getNomeCampoTextoBusca()));

		webElementInput.sendKeys(textoBuscar);
		webElementInput.submit();
	}

}

/**
 * @author jabes
 *
 */
enum PaginaNavegadorEnum {

	PAGINA_GOOGLE("https://www.google.com", "q"),

	;

	private String urlNavegador;
	private String nomeCampoTextoBusca;

	/**
	 * @param urlNavegador
	 * @param nomeCampoTextoBusca
	 */
	private PaginaNavegadorEnum(String urlNavegador, String nomeCampoTextoBusca) {
		this.urlNavegador = urlNavegador;
		this.nomeCampoTextoBusca = nomeCampoTextoBusca;
	}

	/**
	 * @return the urlNavegador
	 */
	public String getUrlNavegador() {
		return urlNavegador;
	}

	/**
	 * @return the nomeCampoTextoBusca
	 */
	public String getNomeCampoTextoBusca() {
		return nomeCampoTextoBusca;
	}

}

/**
 * @author jabes
 *
 */
enum NavegadorEnum {

	FIREFOX("Firefox", "webdriver.gecko.driver", ".\\lib\\geckodriver.exe"),

	CHROME("Chrome", "webdriver.chrome.driver", ".\\lib\\chromedriver.exe");

	;

	private String nome;
	private String chaveWebDriver;
	private String nomeWebDriver;

	/**
	 * @param nome
	 * @param chaveWebDriver
	 * @param nomeWebDriver
	 */
	private NavegadorEnum(String nome, String chaveWebDriver, String nomeWebDriver) {
		this.nome = nome;
		this.chaveWebDriver = chaveWebDriver;
		this.nomeWebDriver = nomeWebDriver;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the chaveWebDriver
	 */
	public String getChaveWebDriver() {
		return chaveWebDriver;
	}

	/**
	 * @return the nomeWebDriver
	 */
	public String getNomeWebDriver() {
		return nomeWebDriver;
	}

}
