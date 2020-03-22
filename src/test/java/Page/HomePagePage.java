package Page;

import org.openqa.selenium.WebDriver;

import Maps.HomePageMap;
import junit.framework.Assert;
import util.BasePage;

public class HomePagePage extends BasePage{
	private HomePageMap homepageMap;

	public HomePagePage(WebDriver driver) {
		super(driver);
		homepageMap = new HomePageMap(driver);
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
			System.out.println("Bucando produto "+nomeProduto+"");
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
	 * @throws Exception 
	   */
	public void validaResultadoBusca(String nomeProduto, String nomeCaso) throws Exception {
		System.out.println("Validando o resultado da busca produto: "+nomeProduto+"");
		Assert.assertEquals(homepageMap.validarResultadoBusca(nomeProduto).isDisplayed(), true);
		takeSnapShot("validarResultadoBusca_"+nomeCaso+"");
	}
	
	/**
	   * Adiciona o produto ao carrinho de compras
	   * 
	   * @param nomeProduto
	   *          nome do produto desejado
	   * @author Lucas Abreu
	   */
	public String adicionarProdutoCarrinho(String nomeProduto) {
		System.out.println("Adicionando o produto ao carrinho");
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
	 * @throws Exception 
	   */
	public void validarProdutoCarrinho(String nomeProduto) throws Exception {
		adicionarProdutoCarrinho(nomeProduto);
		System.out.println("Validando o produto: "+nomeProduto+" no carrinho");
		Assert.assertEquals(homepageMap.validarProdutoCarrinho(nomeProduto).isDisplayed(), true);
		takeSnapShot("validarProdutoCarrinho");
	}
	
	/**
	   * Valida se o produto foi excluirdo do carrinho
	   * 
	   * @author Lucas Abreu
	 * @throws Exception 
	   */
	public void validarExcluirProduto() throws Exception {
		System.out.println("Excluindo o produto do carrinho");
		homepageMap.btnExcluirProduto().click();
		Assert.assertEquals(homepageMap.validaCarrinhoVazio().isDisplayed(), true);
		takeSnapShot("validaCarrinhoVazio");
	}
	
	/**
	   * Seleciona o produto, seleciona a quantidade, adiciona ao carrinho e valida se a quantida esta correta no carrinho
	   * 
	   * @param nomeProduto
	   *        nome do produto desejado
	   *@param numQuantidade
	   *        quantidade do protudo desejada
	   * @author Lucas Abreu
	 * @throws Exception 
	   */
	public void validarQuantidadeSelecionada(String nomeProduto, String numQuantidade) throws Exception{
		System.out.println("Adicionando o produto: "+nomeProduto+" no carrinho");
		homepageMap.selecionarProduto(nomeProduto).click();
		homepageMap.btnQuantidade().selectByVisibleText("2");
		System.out.println("Quantidade selecionada: "+numQuantidade+"");
		homepageMap.btnAdicionarCarrinho().click();
		homepageMap.btnCarrinho().click();
		Assert.assertEquals(homepageMap.validaQuantidadeItens(numQuantidade).isDisplayed(), true);
		takeSnapShot("validaQuantidade_"+numQuantidade+"_Itens");
		System.out.println("Produto validade no carrinho");
	}
}
