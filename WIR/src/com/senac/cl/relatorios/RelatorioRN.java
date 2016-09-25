package com.senac.cl.relatorios;

import java.io.Serializable;

public abstract class RelatorioRN implements Serializable{
	
	private static final long serialVersionUID = 6713780850953747876L;
	
	/*
	@Inject
	JasperReportsExporter exporter;
	
	
	*//**
	 * @param nomeRelatorio - No padrão "RCPJ007"...
	 * @param listaRelatorio
	 * @return
	 *//*
	protected StreamedContent imprimeStream(String nomeRelatorio, List listaRelatorio, HashMap<String, Object> parameters) {
		ReportED report = new ReportED("/reports/"+nomeRelatorio+".jasper", listaRelatorio);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		Iterator it = parameters.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        report.addParameter((String)pairs.getKey(), pairs.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		
		exporter.exportPdfToStream(report, os);
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		return new DefaultStreamedContent(is, "application/pdf", nomeRelatorio+".pdf");  
	}
	
	*//**
	 * Gera relatorio em formato excel
	 * @param nomeRelatorio
	 * @param listaRelatorio
	 * @param parameters
	 * @return
	 *//*
	protected StreamedContent exportarXls(String nomeRelatorio, List listaRelatorio, HashMap<String, Object> parameters) {
		ReportED report = new ReportED("/reports/"+nomeRelatorio+".jasper", listaRelatorio);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		Iterator it = parameters.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        report.addParameter((String)pairs.getKey(), pairs.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		
	    try {
	    	JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, exporter.getJasperPrint(report));
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, os);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
			exporterXLS.exportReport();  
		} catch (JRException e) {
			e.printStackTrace();
		}
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		return new DefaultStreamedContent(is, "application/xls", nomeRelatorio+".xls");  
	}
	
	
	protected StreamedContent exportarTxt(String nomeTxt, StringBuilder conteudoTxt) {
		InputStream is = null;
		try {
			is = IOUtils.toInputStream(conteudoTxt.toString(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new DefaultStreamedContent(is, "application/txt", nomeTxt+".txt");   
		*/
	}
