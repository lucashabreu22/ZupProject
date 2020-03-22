package Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.BasePage;

public class HomePageMap extends BasePage{
	Select btnQuantidade;
	public HomePageMap(WebDriver driver) {
		super(driver);
	}
	public WebElement campoBuscar() {
		return getDriver().findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	}
	
	public WebElement btnBuscar() {
		return getDriver().findElement(By.xpath("//input[@type='submit' and @value='Ir']"));
	}
	
	public WebElement btnAdicionarCarrinho() {
		return getDriver().findElement(By.xpath("//input[@title='Adicionar ao carrinho']"));
	}
	
	public WebElement btnCarrinho() {
		return getDriver().findElement(By.xpath("//a[@id='hlb-view-cart-announce' and contains(.,'Carrinho')]"));
	}
	
	public WebElement validarResultadoBusca(String textBusca) {
		return getDriver().findElement(By.xpath("//span[contains(text(),'resultado')]//following-sibling::span[contains(text(),'"+textBusca+"')]"));
	}
	
	public WebElement selecionarProduto(String nomeProduto) {
		return getDriver().findElement(By.xpath("(//a[@class='a-link-normal a-text-normal']//span[contains(text(),'"+nomeProduto+"')])[1]"));
	}
	
	public WebElement validarProdutoCarrinho(String nomeProduto) {
		return getDriver().findElement(By.xpath("//span[@class='a-list-item']//following-sibling::span[contains(., '"+nomeProduto+"')]"));
	}
	
	public WebElement validaResultadoNaoEncontrado() {
		return getDriver().findElement(By.xpath("(//span[contains(., 'Nenhum resultado para')])[last()]"));
	}
	
	public WebElement btnExcluirProduto() {
		return getDriver().findElement(By.xpath("//input[@value='Excluir']"));
	}
	
	public Select btnQuantidade() {
		return btnQuantidade = new Select(getDriver().findElement(By.xpath("//select[@id='quantity']")));
	}
	
	public WebElement validaQuantidadeItens(String numQuantidade) {
		return getDriver().findElement(By.xpath("(//div[@data-name='Subtotals']//span[contains(.,'"+numQuantidade+"')])[last()]"));
	}
	
	public WebElement validaCarrinhoVazio() {
		return getDriver().findElement(By.xpath("//span[@id='nav-cart-count' and contains(.,'0')]"));
	}
	
}
