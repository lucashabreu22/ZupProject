package Scenario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Page.HomePagePage;
import util.BasePage;

public class ValidarQuantidadeProdutoCarrinho extends BasePage {
	
	private HomePagePage homePagePage;
	private String nomeProduto;
	private String quantidadeProduto;
	
	@Before
	public void beforeTest() {
		navegateTo("https://www.amazon.com.br");
		homePagePage = new HomePagePage(getDriver());
	}
	
	@Test
	public void validarProdutoCarrinho() {
		nomeProduto = "Mouse";
		quantidadeProduto = "2";
		homePagePage.buscarProduto(nomeProduto);
		homePagePage.validaResultadoBusca(nomeProduto);
		homePagePage.validarQuantidadeSelecionada(nomeProduto, quantidadeProduto);
	}
	
	@After
	public void afterTest() {
		closeNavegador();
	}
}
