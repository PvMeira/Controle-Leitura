package com.senac.cl.managed.beans;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.LivroPublico;
import com.senac.cl.service.LivroPublicoService;
import com.senac.cl.utilitarios.Data;
import com.senac.cl.utilitarios.SistemaDeMensagens;

/**
 * 
 * @author Pedro
 * @since 25/09/2016
 */
@ManagedBean
@ViewScoped
public class LivroPublicoMB {

	private LivroPublico livroPublico;
	private Livro livro;
	private List<LivroPublico> livrosPublicos;
	private List<LivroPublico> livrosPublicosSelecionados;

	@Inject
	LivroPublicoService livroPublicoService;
	

	@Inject
	Data data;

	/**
	 * Salvar livroPublico apartir da pagina de cadastro do ADM
	 * 
	 * @param ed
	 */
	public void salvarLivroPublico(LivroPublico ed) {
		this.livroPublicoService.salvarLivroPublico(ed);
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Livro publico adicionada");
		this.limpar();
	}

	
	public void salvarLivroPublicoForm() {
		this.livroPublicoService.salvarLivroPublico(this.livroPublico);
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Livro publico adicionada");
		this.limpar();
	}
	
	public void copiarLivrosPublicosParaContaUsuario(LivroPublico ed) {
		this.livroPublicoService.transferirLivroPublicoParaUsuario(ed);
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Livro transferido para sua conta");
	}
	
	public void copiarLivrosPublicosParaContaUsuarioEmLote() {
		List<LivroPublico> lista = this.livrosPublicosSelecionados;
		for (LivroPublico livro : lista) {
			this.livroPublicoService.transferirLivroPublicoParaUsuario(livro);
		}
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Livro(s) transferido(s) para sua conta");
	}
	public void transferirLivro() {
		this.livroPublicoService.salvarPublico(this.getLivro());
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Seu Livro foi adicionado a lista Publica");
	}

	

	/**
	 * Listar todos os livros publicos
	 * 
	 * @return
	 */
	public List<LivroPublico> listarLivrosPublicos() {
		List<LivroPublico> lista = this.livroPublicoService.listarLivrosPublicos();
		return lista;
	}

	/**
	 * Deletar Livro publico caso seja ADM
	 * 
	 * @param ed
	 */
	public void deletarLivroPublico(LivroPublico ed) {
		this.livroPublicoService.deletar(ed);
		SistemaDeMensagens.notificaINFORMACAO("Livro deletado ", "");
	}

	public String getHintColaborador(LivroPublico ed) {
		String username = ed.getDonoPublico().getUsername();
		String email = ed.getDonoPublico().getMail();
		String hint = username.concat(" | ").concat(email);

		return hint;
	}
	
	public void limpar(){
		this.livroPublico = new LivroPublico();
	}

	/**
	 * método para fazer upload do PDF para o sistema
	 * 
	 * @param event
	 */
	public void carregarArquivo(FileUploadEvent event) {
		byte[] conteudo = event.getFile().getContents();
		this.livroPublico.setArquivoPublico(conteudo);
	}

	/**
	 * Retorna o Arquivo para downlaod do pdf
	 * 
	 * @param livro
	 * @return
	 * @throws IOException
	 */
	public StreamedContent FileDownloadView(LivroPublico livro) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(livro.getArquivoPublico());
		StreamedContent file;
		file = new DefaultStreamedContent(bis, "application/pdf", livro.getTituloPublico() + ".pdf");
		return file;
	}

	/**
	 * Metodo para Retornar um .ZIP com todos os PDF selecionados
	 * 
	 * @return
	 * @throws IOException
	 */
	public DefaultStreamedContent geradorZip() throws IOException {
		ByteArrayOutputStream arq = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(arq);
		List<LivroPublico> listaLivrosSelecionados = this.livrosPublicosSelecionados;
		for (LivroPublico livro : listaLivrosSelecionados) {
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
	 * @return the livroPublico
	 */
	public LivroPublico getLivroPublico() {
		if(this.livroPublico == null){
			this.limpar();
		}
		return livroPublico;
	}

	/**
	 * @param livroPublico
	 *            the livroPublico to set
	 */
	public void setLivroPublico(LivroPublico livroPublico) {
		this.livroPublico = livroPublico;
	}

	/**
	 * @return the livrosPublicos
	 */
	public List<LivroPublico> getLivrosPublicos() {
		return livrosPublicos;
	}

	/**
	 * @param livrosPublicos
	 *            the livrosPublicos to set
	 */
	public void setLivrosPublicos(List<LivroPublico> livrosPublicos) {
		this.livrosPublicos = livrosPublicos;
	}

	/**
	 * @return the livrosPublicosSelecionados
	 */
	public List<LivroPublico> getLivrosPublicosSelecionados() {
		return livrosPublicosSelecionados;
	}

	/**
	 * @param livrosPublicosSelecionados
	 *            the livrosPublicosSelecionados to set
	 */
	public void setLivrosPublicosSelecionados(List<LivroPublico> livrosPublicosSelecionados) {
		this.livrosPublicosSelecionados = livrosPublicosSelecionados;
	}


	/**
	 * @return the livro
	 */
	public Livro getLivro() {
		return livro;
	}


	/**
	 * @param livro the livro to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
