package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Maps.HomePageMap;
import junit.framework.Assert;
import util.BasePage;

public class HomePagePage extends BasePage{
	private HomePageMap homepageMap;
	WebDriverWait wait;
	

	public HomePagePage(WebDriver driver) {
		super(driver);
		homepageMap = new HomePageMap(driver);
		wait = new WebDriverWait(driver, 10);
	}
	
	/**
	   * Busca um produto no site da Amazon
	   * 
	   * @param nomeProduto
	   *          nome do produto desejado
	   * @author Lucas Abreu
	   */
	public void buscarProduto(String nomeProduto) {
		if(homepageMap.campoBuscar().isDisplayed()) {
			homepageMap.campoBuscar().sendKeys(nomeProduto);
			homepageMap.btnBuscar().click();
		}else {
			System.out.println("Campo Não Encontrado");
		}
		
	}
	
	/**
	   * Valida o resultado da busca do produto
	   * 
	   * @param nomeProduto
	   *          nome do produto desejado
	   * @author Lucas Abreu
	   */
	public void validaResultadoBusca(String nomeProduto) {
		Assert.assertEquals(homepageMap.validarResultadoBusca(nomeProduto).isDisplayed(), true);
	}
	
	/**
	   * Adiciona o produto ao carrinho de compras
	   * 
	   * @param nomeProduto
	   *          nome do produto desejado
	   * @author Lucas Abreu
	   */
	public String adicionarProdutoCarrinho(String nomeProduto) {
		String getNomeProduto = homepageMap.selecionarProduto(nomeProduto).getText();
		System.out.println(getNomeProduto);
		homepageMap.selecionarProduto(nomeProduto).click();
		homepageMap.btnAdicionarCarrinho().click();
		homepageMap.btnCarrinho().click();
		return getNomeProduto;
	}
	
	/**
	   * Valida se o produto foi adicionado corretamente ao carrinho
	   * 
	   * @param nomeProduto
	   *          nome do produto desejado
	   * @author Lucas Abreu
	   */
	public void validarProdutoCarrinho(String nomeProduto) {
		adicionarProdutoCarrinho(nomeProduto);
		Assert.assertEquals(homepageMap.validarProdutoCarrinho(nomeProduto).isDisplayed(), true);
	}
	
	/**
	   * Valida se o produto foi excluirdo do carrinho
	   * 
	   * @author Lucas Abreu
	   */
	public void validarExcluirProduto() {
		homepageMap.btnExcluirProduto().click();
		Assert.assertEquals(homepageMap.validaCarrinhoVazio().isDisplayed(), true);
	}
	
	/**
	   * Seleciona o produto, seleciona a quantidade, adiciona ao carrinho e valida se a quantida esta correta no carrinho
	   * 
	   * @param nomeProduto
	   *        nome do produto desejado
	   *@param numQuantidade
	   *        quantidade do protudo desejada
	   * @author Lucas Abreu
	   */
	public void validarQuantidadeSelecionada(String nomeProduto, String numQuantidade){
		homepageMap.selecionarProduto(nomeProduto).click();
		homepageMap.btnQuantidade().selectByVisibleText("2");
		homepageMap.btnAdicionarCarrinho().click();
		homepageMap.btnCarrinho().click();
		Assert.assertEquals(homepageMap.validaQuantidadeItens(numQuantidade).isDisplayed(), true);
	}
}
