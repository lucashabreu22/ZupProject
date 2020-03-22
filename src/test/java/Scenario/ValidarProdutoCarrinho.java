package Scenario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Page.HomePagePage;
import util.BasePage;

public class ValidarProdutoCarrinho extends BasePage {
	
	private HomePagePage homePagePage;
	private String nomeProduto;
	
	@Before
	public void beforeTest() {
		navegateTo("https://www.amazon.com.br");
		homePagePage = new HomePagePage(getDriver());
	}
	
	@Test
	public void validarProdutoCarrinho() {
		nomeProduto = "Mouse";
		homePagePage.buscarProduto(nomeProduto);
		homePagePage.validaResultadoBusca(nomeProduto);
		homePagePage.validarProdutoCarrinho(nomeProduto);
	}
	
	@After
	public void afterTest() {
		closeNavegador();
	}
}
