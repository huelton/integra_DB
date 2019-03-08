package integracao.bancodedados;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import integracao.bancodedados.contatos.Contato;
import integracao.bancodedados.contatos.ContatoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BancodedadosApplicationTests {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	private Contato contato;
	
	@Before
	public void start() {
		contato = new Contato("Chefe", "0y", "9xxxxxxxx9");
	}
	
	@Test
	public void saveComDddNuloDeveLancarException() throws Exception{
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("O DDD deve ser preenchido");
		
		contato.setDdd(null);
		contatoRepository.save(contato);
	}
	
	@Test
	public void saveComTelefoneNuloDeveLancarException() throws Exception{
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("O Telefone deve ser preenchido");
		
		contato.setTelefone(null);
		contatoRepository.save(contato);
	}
	
	@Test
	public void saveComNomeNuloDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("O Nome deve ser preenchido");
		
		contato.setNome(null);
		contatoRepository.save(contato);
	}

}
