package Scenario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Page.HomePagePage;
import util.BasePage;

public class ValidarExcluirProdutoCarrinho extends BasePage {
	
	private HomePagePage homePagePage;
	private String nomeProduto;
	
	@Before
	public void beforeTest() {
		navegateTo("https://www.amazon.com.br");
		homePagePage = new HomePagePage(getDriver());
	}
	
	@Test
	public void validarExcluirProdutoCarrinho() throws Exception {
		nomeProduto = "Mouse";
		homePagePage.buscarProduto(nomeProduto);
		homePagePage.validaResultadoBusca(nomeProduto,"validarExcluirProdutoCarrinho");
		homePagePage.validarProdutoCarrinho(nomeProduto);
		homePagePage.validarExcluirProduto();
	}
	
	@After
	public void afterTest() {
		closeNavegador();
	}
}
