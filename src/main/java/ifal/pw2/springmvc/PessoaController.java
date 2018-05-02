package ifal.pw2.springmvc;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ifal.pw2.springmvc.model.Pessoa;
import ifal.pw2.springmvc.service.PessoaService;

@Controller
public class PessoaController {
	
	private PessoaService personService;
	
	@Autowired(required=true)
	@Qualifier(value="pessoaService")
	public void setPersonService(PessoaService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public String listPersons(Model model) {
		
		/*Nova pessoa para form de cadastro*/
		Pessoa pessoa = new Pessoa();
		model.addAttribute("pessoa", pessoa);
		
		/*Lista de pessoas para tabela(table) pessoa com foreach*/
		List<Pessoa> listPessons = this.personService.listPessoa();
		model.addAttribute("listPersons", listPessons);
		
		return "pessoa";//pagina .jsp
	}
	
	@RequestMapping(value= "/pessoa/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("pessoa") Pessoa p){
		
		if(p.getId() == 0){
			this.personService.addPessoa(p);
		}else{
			this.personService.updatePessoa(p);
		}
		
		return "redirect:/pessoas";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePessoa(id);
        return "redirect:/pessoas";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
    	
    	Pessoa p = this.personService.getPessoaById(id);
    	Collection<Pessoa> pessoas = this.personService.listPessoa();
        model.addAttribute("pessoa", p);
        model.addAttribute("listPersons", pessoas);
        return "pessoa";
    }
	
}
