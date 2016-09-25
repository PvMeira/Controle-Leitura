package com.senac.cl.relatorios.livro;



public class LivroExportar {
	
/*public StreamedContent exportaRelatorioExcel(List<ProcessoDocumentoED> processoDocumento){
		
		List<DocumentoBean> listaDocumentosBean = new ArrayList<DocumentoBean>();
		DocumentoBean documentoBean;
		
		for (ProcessoDocumentoED processo : processoDocumento) {
			
			documentoBean = new DocumentoBean();
			
			if(processo.getDocumento() != null){
				documentoBean.setNomeDocumento(processo.getDocumento().getNomeDocumento());
				documentoBean.setDataDocumento(Data.calendarToString(processo.getDocumento().getDtDocumento(), "dd/MM/yyyy"));
				documentoBean.setNomeProcurador(processo.getDocumento().getFuncionarioPgeResponsavel().getNomeFunc());
			}
			
			if(processo.getProcesso() != null){
				documentoBean.setNumeroProcesso(processo.getProcesso().getNroProcJudicial().toString());
			}
			
			if(processo.getDocumento().getTipoOrigemEnum() != null){
				documentoBean.setOrigemDocumento(processo.getDocumento().getTipoOrigemEnum().getDescricao());
			}
			
			if(processo.getDocumento().getTipoPeca() != null){
				String tipoPeca = processo.getDocumento().getTipoPeca().getNroIntTipoPeca().toString().concat(" - ").concat(processo.getDocumento().getTipoPeca().getNomeTipoPeca());
				documentoBean.setTipoPeca(tipoPeca);
			}
			
			if(StringUtils.isNotBlank(processo.getTpAtuacao())){
				documentoBean.setTipoAtuacao(processo.getTpAtuacao());
			}
			
			listaDocumentosBean.add(documentoBean);
		}
		
		return this.exportarXls("documentoRelatorioXLS", listaDocumentosBean, new HashMap<String, Object>());
		
	}*/
}
