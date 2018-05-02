package ifal.pw2.springmvc.dao;

import java.util.List;

import ifal.pw2.springmvc.model.Pessoa;

public interface PessoaDAO {

	public void addPessoa(Pessoa p);
	public void updatePessoa(Pessoa p);
	public List<Pessoa> listPessoa();
	public Pessoa getPessoaById(int id);
	public void removePessoa(int id);
}
