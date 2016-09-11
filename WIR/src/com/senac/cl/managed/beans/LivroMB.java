package com.senac.cl.managed.beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.senac.cl.modelos.Livro;
import com.senac.cl.service.LivroService;
import com.senac.cl.utilitarios.SistemaDeMensagens;

/**
 * 
 * @author Pedro
 * @since 11/09/2016
 */
@ManagedBean
@ViewScoped
public class LivroMB {

	private Livro livro;
	
	
	private List<Livro> livrosPessoaLogada;
	
	private List<Livro> livrosSelecionados;
	
	
	@Inject
	private LivroService livroService;
	
	private final static String LIDO ="Livro já Lido";
	private final static String NAO_LIDO ="Livro não Lido";
	
	

	public LivroMB() {
	}

	/**
	 * Salva o livro
	 */
	public void salvar() {
		livroService.salvar(this.getLivro());
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Cadastro salvo com sucesso!");
		limpar();
	}

	/**
	 * Deleta o livro selecionado
	 * 
	 * @param livro
	 */
	public void deletar(Livro livro) {
		livroService.deletar(livro);
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Cadastro deletado ");
		limpar();
	}
	
	
	/**
	 * Carrega o arquivo upado para a entidade
	 * @param event
	 */
	public void carregarArquivo(FileUploadEvent event)  {
		//Converte o arquivo do evento em um array de bytes
		//para ser armazenado no banco
		byte[] conteudo = event.getFile().getContents();
		this.livro.setArquivo(conteudo);
	}
	
	/**
	 * Retorna o Arquivo para downlaod do pdf
	 * @param livro
	 * @return
	 * @throws IOException
	 */
	public StreamedContent  FileDownloadView(Livro livro) throws IOException {   
		//Converte os bytes do livro para um arquivo
		ByteArrayInputStream bis = new ByteArrayInputStream(livro.getArquivo());
		StreamedContent file;
		//disponibiliza o formato e o tipo de arquivo para o download 
        file = new DefaultStreamedContent(bis, "application/pdf", livro.getTitulo()+".pdf");
        //retorna o arquivo
        return file;
    }
	
	/**
	 * Verifica o status do livro, caso seja true retorna não lido
	 * se não retorna ja lido
	 * @param livro
	 * @return
	 */
	public String VerificaStatusLivro(Livro livro){
		if(livro.isLivroAtivo() == false){
			return LIDO;
		}
		return NAO_LIDO;
	}
	
	/**
	 * popula a string de observação que sera usada 
	 * na modal de observação
	 */
	public void populaObservacaoParaModal(Livro livro){
		this.livro = livro;
	}
	public void atualizaResumoLivro(){
		livroService.atualizar(this.livro);
	}

	/**
	 * Listar todos os livros do banco
	 * 
	 * @return
	 */
	public List<Livro> listarTodosLivros() {
		return livroService.listarTodosRegistros();
	}

	/**
	 * seta um novo livro
	 */
	public void limpar() {
		setLivro(new Livro());
	}
	
	/**
	 * Lista todos os livros do usuario logado
	 */
	public List<Livro> listaLivrosPessoaLogada(){
		return this.livroService.listarTodosLivrosDoUsuario();
	}
	
	
	//-----------get set
	/**
	 * @return the livro
	 */
	public Livro getLivro() {
		if (this.livro == null) {
			limpar();
		}
		return livro;
	}

	/**
	 * @param livro
	 *            the livro to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	/**
	 * @return the livrosPessoaLogada
	 */
	public List<Livro> getLivrosPessoaLogada() {
		return livrosPessoaLogada;
	}


	/**
	 * @param livrosPessoaLogada the livrosPessoaLogada to set
	 */
	public void setLivrosPessoaLogada(List<Livro> livrosPessoaLogada) {
		this.livrosPessoaLogada = livrosPessoaLogada;
	}


	/**
	 * @return the livroService
	 */
	public LivroService getLivroService() {
		return livroService;
	}


	/**
	 * @param livroService the livroService to set
	 */
	public void setLivroService(LivroService livroService) {
		this.livroService = livroService;
	}

	/**
	 * @return the livrosSelecionados
	 */
	public List<Livro> getLivrosSelecionados() {
		return livrosSelecionados;
	}

	/**
	 * @param livrosSelecionados the livrosSelecionados to set
	 */
	public void setLivrosSelecionados(List<Livro> livrosSelecionados) {
		this.livrosSelecionados = livrosSelecionados;
	}
	

}
