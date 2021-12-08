package cadastrocliente.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
//	Esse bloco vai ajudar a fazer interação no BD baseado no persistence.xml
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Cliente-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();//	Gerente de Entidades
		
// VER O QUE ESTA NO BD
//		Cliente cliente = entityManager.find(Cliente.class, 2);
//		System.out.println(cliente.getNome());
		

/*
 		
//============= ADICIONANDO DADOS =============
//	Objeto criado para adicionar no Banco de Dados
		Cliente cliente = new Cliente();
		cliente.setNome("Shopee");
		
//	Transaction - Se der erro ele faz um Rollback (Revercao) não salva no BD
		entityManager.getTransaction().begin(); //comeca
		
//	Metodo persiste passa cliente e o JPA vai persistir desse objeto (cliente)
		entityManager.persist(cliente);
		
		entityManager.getTransaction().commit();
*/		
		

		
/*
		
//============= REMOVENDO DADOS =============
//		Cliente cliente = entityManager.find(Cliente.class, 4);
//Busca no BD pelo find - Só consegue remover objetos que existem
//	que o entityManager ja sabe que existem, que esta sobre o gerenciamento
//		
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
*/
		
		
		
		
//============= ALTERANDO DADOS =============
		Cliente cliente = new Cliente();
//		cliente.setId(5);
		cliente.setNome("WhatsApp");
		
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
	 // merge vai gerenciar o objeto como na classe Cliente tem a anotacao @id @GeneratedValue(fala que o Bd vai gerenciar o id)
    // ele pega o id Setid acima e muda o valor atraves do setNome		
		entityManager.getTransaction().commit();
		
//		Se não usar o setId o merge entende que é registro novo - então ele registra atribuindo um novo id
		

/*		
//============= ALTERANDO DADOS - INCLUINDO A MAIS, CONCATENANDO COM O QUE JA ESTA NO BD =============
		Cliente cliente = entityManager.find(Cliente.class, 5);
		entityManager.getTransaction().begin();
		cliente.setNome(cliente.getNome() + "Mercado Livre"); //Adicionou a mais do que ja estava concatenou com o que estava no BD
		entityManager.getTransaction().commit();
*/
		
		
		
//	Fechando a conexão
		entityManager.close();
		entityManagerFactory.close();
	}

}
