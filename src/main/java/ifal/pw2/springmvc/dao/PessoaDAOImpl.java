package ifal.pw2.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ifal.pw2.springmvc.model.Pessoa;

@Repository
public class PessoaDAOImpl implements PessoaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PessoaDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPessoa(Pessoa p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		//logger.info("Pessoa salva com sucesso. Detalhes="+p);
	}

	@Override
	public void updatePessoa(Pessoa p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		//logger.info("Pessoa atualizada com sucesso. Detalhes="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> listPessoa() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pessoa> personsList = session.createQuery("from Pessoa").list();
		//logger.info("PessoasList::");
		for(Pessoa p : personsList){
			logger.info(p.toString());
		}
		return personsList;
	}

	@Override
	public Pessoa getPessoaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		//Pessoa p = (Pessoa) session.load(Pessoa.class, new Integer(id));
		Pessoa p = (Pessoa) session.get(Pessoa.class, new Integer(id));

		logger.info("Pessoa recuperada com sucesso. Detalhes: ="+p);
		return p;
	}

	@Override
	public void removePessoa(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pessoa p = (Pessoa) session.load(Pessoa.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		//logger.info("Pessoa excluida com sucesso. Detalhes="+p);
	}

}
