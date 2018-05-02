package ifal.pw2.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ifal.pw2.springmvc.dao.PessoaDAO;
import ifal.pw2.springmvc.model.Pessoa;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	private PessoaDAO pessoaDAO;

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	@Override
	@Transactional
	public void addPessoa(Pessoa p) {
		this.pessoaDAO.addPessoa(p);
	}

	@Override
	@Transactional
	public void updatePessoa(Pessoa p) {
		this.pessoaDAO.updatePessoa(p);
	}

	@Override
	@Transactional
	public List<Pessoa> listPessoa() {
		return this.pessoaDAO.listPessoa();
	}

	@Override
	@Transactional
	public Pessoa getPessoaById(int id) {
		return this.pessoaDAO.getPessoaById(id);
	}

	@Override
	@Transactional
	public void removePessoa(int id) {
		this.pessoaDAO.removePessoa(id);
	}

}
