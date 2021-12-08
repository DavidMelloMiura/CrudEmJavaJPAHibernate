package cadastrocliente.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name = "cliente") //Nome diferente da classe e a tabela - pode usar essa anotação
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //O Bd vai gerar o id atraves do auto_increment
//	@Column(name = "cli_id") Se caso o nome do atributo fosse diferente no bd, poderia usar essa anotação para direcionar
	private Integer id;
	
//	@Column(name = "cli_nome") Se caso o nome do atributo fosse diferente no bd, poderia usar essa anotação para direcionar
	private String nome;
	
	
//	GETTERS E SETTERS
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
//	equals e hashcode
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}