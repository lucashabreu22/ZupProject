package SuiteTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Scenario.ValidarExcluirProdutoCarrinho;
import Scenario.ValidarProdutoCarrinho;
import Scenario.ValidarQuantidadeProdutoCarrinho;

@RunWith(Suite.class)
@SuiteClasses({ ValidarExcluirProdutoCarrinho.class, ValidarProdutoCarrinho.class, ValidarQuantidadeProdutoCarrinho.class })
public class SuiteValidarCarrinho {
	
}
