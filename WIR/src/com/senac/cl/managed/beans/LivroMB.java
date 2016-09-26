package com.senac.cl.managed.beans;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RateEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.senac.cl.modelos.Leitura;
import com.senac.cl.modelos.LeituraService;
import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.LivroPublico;
import com.senac.cl.service.LivroPublicoService;
import com.senac.cl.service.LivroService;
import com.senac.cl.utilitarios.Data;
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
	private Livro livroParaTransferir;
	private Livro livroEdit;
	private List<Livro> livrosPessoaLogada;
	private List<Livro> livrosSelecionados;
	private List<LivroPublico> livrosPublicosSelecionados;

	@Inject
	private LivroService livroService;

	@Inject
	private LeituraService leituraService;
	
	@Inject 
	LivroPublicoService livroPublicoService;

	@Inject
	Data data;

	private final static String LIDO = "Livro já Lido";
	private final static String LENDO = "Lendo";
	private final static String JA_FOI_LIDO = "Já Foi Lido";
	private final static String NAO_LIDO = "Livro não Lido";
	private boolean tornarpublico;

	public LivroMB() {
	}

	
	@PostConstruct
	public void init(){
		atribuirEstadoInicial();
	}
	
	private void atribuirEstadoInicial()
	{
		livro = new Livro();
	}
	
	/**
	 * Salva o livro
	 */
	public void salvar() {
		if(tornarpublico == true){
			this.livroPublicoService.salvarPublico(this.getLivro());
			if(this.livro.getIdLivro() != null){
				this.livro.setPublico(true);
				this.livroService.atualizar(this.livro);
			}
		}
		
		livroService.salvar(this.getLivro(), tornarpublico);
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Cadastro salvo com sucesso!");
		limpar();
	}
	/**
	 * Editar livro selecionado
	 */
	public void editarLivro() {
		livroService.atualizar(this.getLivroEdit());
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Cadastro alterado com sucesso!");
	}
	

	/**
	 * Salva uma nova leitura apartir do livro seleciona inline
	 */
	public void iniciarLeituraLivroInline(Livro ed) {
		if (ed.isLivroAtivo()) {
			this.leituraService.salvar(ed);
		} else {
			SistemaDeMensagens.notificaAVISO("Opa", "Parece que voce ja tem uam leitura em andamento com esse livro");
		}
	}

	/**
	 * Verifica se existe uma Leitura com o livro selecionado
	 * 
	 * @param livroED
	 */
	public boolean verificaSeExisteLeitura(Livro livroED) {
		Leitura leitura = leituraService.buscaLeituraPeloId(livroED);
		if (leitura != null) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	/**
	 * Transfere o livro que foi selecionado e e muda a booleana publica para
	 * TRUE
	 */
	public void transferir() {
		this.livroService.atualizarATransferenciaParaPublico(this.livroParaTransferir);
	}

	/**
	 * Lista livros do autocomplete que esteja com publico = false
	 * @param particula
	 * @return
	 */
	public List<Livro> listarLivrosAutoCompleteTransferir(String particula) {
		List<Livro> lista = this.livroService.listarLivrosAutoCompleteTransferir(particula);
		return lista;
	}
	
	public List<Livro> listarLivrosAutoCompleteResenha(String particula) {
		List<Livro> lista = this.livroService.listarLivrosAutoCompleteResenha(particula);
		return lista;
	}
	/**
	 * Retorna o nome da aba com contador
	 * @return
	 */
	public String nomeAbaLivrosAdm(){
		int num = listarTodosLivros().size();
		
		String retorno = "Todos os Livros Cadastrados".concat("("+num).concat(")");
		
		return retorno;
	}

	/**
	 * Deleta o livro selecionado
	 * @param livro
	 */
	public void deletar(Livro livro) {
		boolean existe = this.verificaSeExisteLeitura(livro);
		if (existe == true) {
			livroService.deletar(livro);
			limpar();
		} else {
			Leitura leitura = leituraService.buscaLeituraPeloId(livro);
			this.leituraService.pararLeitura(leitura);
			livroService.deletar(livro);
			SistemaDeMensagens.notificaINFORMACAO("Leitura excluida", "Leitura relacionada ao livro excluida");
			limpar();
		}
	}

	/**
	 * Deletar Sem as informações de sucessso para o metodo de delete em lote
	 * @param livro
	 */
	public void deletarSeminformação(Livro livro) {
		livroService.deletar(livro);
	}

	/**
	 * Carrega o arquivo upado para a entidade
	 * @param event
	 */
	public void carregarArquivo(FileUploadEvent event) {
		// Converte o arquivo do evento em um array de bytes
		// para ser armazenado no banco
		byte[] conteudo = event.getFile().getContents();
		this.livro.setArquivo(conteudo);
	}

	/**
	 * Retorna o Arquivo para downlaod do pdf
	 * @param livro
	 * @return
	 * @throws IOException
	 */
	public StreamedContent FileDownloadView(Livro livro) throws IOException {
		// Converte os bytes do livro para um arquivo
		ByteArrayInputStream bis = new ByteArrayInputStream(livro.getArquivo());
		StreamedContent file;
		// disponibiliza o formato e o tipo de arquivo para o download
		file = new DefaultStreamedContent(bis, "application/pdf", livro.getTitulo() + ".pdf");
		// retorna o arquivo
		return file;
	}

	/**
	 * Metodo para Retornar um .ZIP com todos os PDF selecionados
	 * @return
	 * @throws IOException
	 */
	public DefaultStreamedContent geradorZip() throws IOException {
		ByteArrayOutputStream arq = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(arq);
		List<Livro> listaLivrosSelecionados = this.livrosSelecionados;
		for (Livro livro : listaLivrosSelecionados) {
			byte[] buffer = new byte[99999];
			StreamedContent file = FileDownloadView(livro);
			ZipEntry entry = new ZipEntry(file.getName());
			zip.putNextEntry(entry);
			int len;
			while ((len = file.getStream().read(buffer)) > 0) {
				zip.write(buffer, 0, len);
			}
			file.getStream().close();
			zip.closeEntry();
		}
		zip.close();
		String d = this.data.getDataFormatoPTbrInteira(Calendar.getInstance());
		return new DefaultStreamedContent(new ByteArrayInputStream(arq.toByteArray()), "application/zip",
				"LivrosSelecionados" + d + ".zip");
	}

	/**
	 * Verifica o status do livro, caso seja true retorna não lido se não
	 * retorna ja lido
	 * @param livro
	 * @return
	 */
	public String VerificaStatusLivro(Livro livro) {
		if (livro.isLivroAtivo() == false && livro.isJaFoiLido() == false) {
			Leitura lei = this.buscaLivroLeitura(livro);
			if (lei != null) {
				return LENDO;
			} else {
				return LIDO;
			}
		}
		if (livro.isJaFoiLido() == true) {
			return JA_FOI_LIDO;
		} else {
			return NAO_LIDO;
		}
	}

	/**
	 * busca se existe uma leitura para o livro em questao
	 * @param ed
	 * @return
	 */
	private Leitura buscaLivroLeitura(Livro ed) {
		return this.leituraService.buscaLeituraPeloId(ed);

	}
	/**
	 * popula livro para edição
	 * @param ed
	 */
	public void populaLivroEdicao(Livro ed) {
		this.livroEdit = ed;
	}

	/**
	 * popula a string de observação que sera usada na modal de observação
	 */
	public void populaObservacaoParaModal(Livro livro) {
		this.livro = livro;
	}

	/**
	 * metodo para atualizar o resumo que foi alterado
	 */
	public void atualizaResumoLivro() {
		livroService.atualizar(this.livro);
	}

	/**
	 * metodo para fazer o delete em lote atraves do selection do dataTable
	 */
	public void deletarEmLote() {
		int contador = 0;
		List<Livro> lista = this.livrosSelecionados;
		for (Livro livro : lista) {
			deletarSeminformação(livro);
			contador++;
		}
		SistemaDeMensagens.notificaINFORMACAO("Livros deletados ", "Com sucesso, numero de livros :" + contador);
	}

	/**
	 * Metodo para atualizar a pontuação do livro apartir o evento ajax na 1
	 * camada
	 * 
	 * @param rateEvent
	 */
	public void updatePontuacaoLivro(RateEvent rateEvent) {
		Integer pontuacao = 0;
		// Pega o evento do componente do prime e passa para um int
		pontuacao = ((Integer) rateEvent.getRating()).intValue();
		this.livro.setPontuacao(pontuacao);
		livroService.atualizar(this.livro);
	}

	/**
	 * Retorna a hint do label que contem o email e username para contato
	 * 
	 * @param ed
	 * @return
	 */
	public String getHintColaborador(Livro ed) {
		String username = ed.getDono().getUsername();
		String email = ed.getDono().getMail();
		String hint = username.concat(" | ").concat(email);

		return hint;
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
		setLivroParaTransferir(null);
	}

	/**
	 * Lista todos os livros do usuario logado
	 */
	public List<Livro> listaLivrosPessoaLogada() {
		return this.livroService.listarTodosLivrosDoUsuario();
	}

	/**
	 * Lista todos os livros que estão marcados como Públicos
	 * 
	 * @return
	 */
	public List<Livro> listaLivrosPublicos() {
		return this.livroService.listaTodosLivrosPublicos();
	}

	// -----------get set
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
	 * @param livrosPessoaLogada
	 *            the livrosPessoaLogada to set
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
	 * @param livroService
	 *            the livroService to set
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
	 * @param livrosSelecionados
	 *            the livrosSelecionados to set
	 */
	public void setLivrosSelecionados(List<Livro> livrosSelecionados) {
		this.livrosSelecionados = livrosSelecionados;
	}

	/**
	 * @return the tornarpublico
	 */
	public boolean isTornarpublico() {
		return tornarpublico;
	}

	/**
	 * @param tornarpublico
	 *            the tornarpublico to set
	 */
	public void setTornarpublico(boolean tornarpublico) {
		this.tornarpublico = tornarpublico;
	}

	/**
	 * @return the livroParaTransferir
	 */
	public Livro getLivroParaTransferir() {
		return livroParaTransferir;
	}

	/**
	 * @param livroParaTransferir
	 *            the livroParaTransferir to set
	 */
	public void setLivroParaTransferir(Livro livroParaTransferir) {
		this.livroParaTransferir = livroParaTransferir;
	}

	/**
	 * @return the livroEdit
	 */
	public Livro getLivroEdit() {
		return livroEdit;
	}

	/**
	 * @param livroEdit
	 *            the livroEdit to set
	 */
	public void setLivroEdit(Livro livroEdit) {
		this.livroEdit = livroEdit;
	}


	/**
	 * @return the livrosPublicosSelecionados
	 */
	public List<LivroPublico> getLivrosPublicosSelecionados() {
		return livrosPublicosSelecionados;
	}


	/**
	 * @param livrosPublicosSelecionados the livrosPublicosSelecionados to set
	 */
	public void setLivrosPublicosSelecionados(List<LivroPublico> livrosPublicosSelecionados) {
		this.livrosPublicosSelecionados = livrosPublicosSelecionados;
	}

}
