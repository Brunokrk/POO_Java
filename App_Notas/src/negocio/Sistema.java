package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.Semestre;
import dados.Disciplina;
import dados.Avaliacao;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;


public class Sistema {
	private List<Semestre> semestres = new ArrayList<Semestre>();
	
	//M�todos previstos na modelagem
	//cadastrarSemestre OK
	//excluirSemestre OK
	//editarSemestre ??
	//cadastrarDisciplina OK
	//excluirDisciplina OK
	//editarDisciplina OK
	//cadastrarAvaliacao OK
	//excluirAvaliacao OK
	//editarAvaliacao
	
	public void cadastrarSemestre(Semestre semestre) {
		this.semestres.add(semestre);
	}
	
	public void excluirSemestre(String identifica��o) {
		
		for(int i=0; i<semestres.size();i++) {
			Semestre s = semestres.get(i);
			if(s.getIdentificacao().equals(identifica��o)) {
				semestres.remove(s);
				break;
			}
		}
	}
	
	public void cadastrarDisciplina(Semestre semestre, Disciplina disciplina) {
		for(Semestre item : semestres) {
			if(item.equals(semestre)) {
				if(item.verificaPossibilidadeAddDisciplina(disciplina)) {
					item.cadastrarDisciplina(disciplina);					
				}else {
					System.out.println("ERRO 004 - DISCIPLINA J� EXISTE");
				}
			}
		}
	}
	
	public void excluirDisciplina(String identificacao, String cod) {
		for(Semestre item : semestres) {
			if (item.getIdentificacao().equals(identificacao)) {
				item.excluirDisciplina(cod);
			}
		}
	}
	
	public void editarDisciplina(Semestre semestre, Disciplina disciplina) {
		//Na apresenta��o, criar um m�todo que identifica a disciplina informando o C�digo
		//E criar um m�todo que busca as novas informa��es
		for(Semestre item : semestres) {
			if (item.equals(semestre)) {
				item.editarDisciplina(disciplina);
			}
		}
	}
	
	public void cadastrarAvaliacao(Semestre semestre, Disciplina disciplina, Avaliacao avaliacao) {
		for(Semestre item : semestres) {
			if (item.equals(semestre)) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.equals(disciplina)) {
						second_item.cadastrarAvaliacao(avaliacao);
					}
				}
			}
		}
	}
	
	public void excluirAvaliacao (String identificacao, String cod, String nome) {
		for(Semestre item : semestres) {
			if (item.getIdentificacao().equals(identificacao)) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.getCodDisciplina().equals(cod)) {
						for(Avaliacao third_item : second_item.avaliacoes) {
							if(third_item.getNome().equals(nome)) {
								second_item.excluirAvaliacao(nome);
							}
						}
					}
				}
			}
		}
	}
	
	public void editarAvaliacao (Semestre semestre, Disciplina disciplina, Avaliacao avaliacao) {
		for(Semestre item : semestres) {
			if (item.equals(semestre)) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.equals(disciplina)) {
						for(Avaliacao third_item : second_item.avaliacoes) {
							if(third_item.equals(avaliacao)) {
								second_item.editarAvaliacao(avaliacao);
							}
						}
					}
				}
			}
		}
	}
	
	public List<Semestre> getSemestres(){
		return semestres;
	}
	
	public Semestre getSemestre(String id) {
		for(Semestre item : semestres) {
			if(item.getIdentificacao().equals(id)) {
				return item;
			}
		}
		return null;
	}
	
	public void mostraSemestres() {
		System.out.println("**********SEMESTRES CADASTRADOS**********");
		for(Semestre item : semestres) {
			System.out.println("        | "+item.toString()+" | ");
		}
	}
	
	public void mostraDisciplinas(Semestre b) {
		System.out.println("**********DISCIPLINAS CADASTRADAS**********");
		
		for(Semestre item : semestres) {
			if(item.equals(b)) {			
				item.mostraDisciplinas();
			}
		}
	}
	
	public void mostraDisciplinas(String identificacao) {
		System.out.println("**********DISCIPLINAS CADASTRADAS**********");
		for(Semestre item : semestres) {
			if(item.getIdentificacao().equals(identificacao)) {			
				item.mostraDisciplinas();
			}
		}
	}
	
	public void mostraAvaliacoes(Disciplina d) {
		System.out.println("**********AVALIA��ES CADASTRADAS**********");
		for(Avaliacao item : d.avaliacoes) {
			System.out.println("| "+item.toString()+" |");
		}
	
	}
	
	public void mostraAvaliacoes(String identificacao, String cod) {
		System.out.println("**********AVALIA��ES CADASTRADAS**********");
		for(Semestre item : semestres) {
			if(item.getIdentificacao().equals(identificacao)) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.getCodDisciplina().equals(cod)) {
						for(Avaliacao third_item : second_item.avaliacoes) {
							System.out.println("| "+third_item.toString()+" |");
						}
					}
				}
			}
			break;
		}
		
	}
	
	public boolean verificaPossibilidadeAddSemestre(Semestre a) {
		for(Semestre item : semestres) {
			if(item.equals(a)) {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean verificaPossibilidadeExclSemestre(String a) {
		for(Semestre item : semestres) {
			if(item.getIdentificacao().equals(a)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verificaPossibilidadeExclDisciplina(String id, String cod) {
		for(Semestre item : semestres) {
			if(item.getIdentificacao().equals(id)) {
				if(item.verificaPossibilidadeExclDisciplina(cod)) {
					return true;
				}
			}
		}
		return false;
	}
	
	//----M�todos referentes � Biblioteca itext---- EM ANDAMENTO, N�O FAZ PARTE DA ENTREGA 2
	//Posteriormente entrar� na persistencia de dados
	
	public void gerarPDF(String identificacao) {
		String nomePDF = "C:\\Users\\pires\\Documents\\GitHub\\poo\\App_Notas\\relatorios\\Semestre" + identificacao+".pdf";
		Document documentoPDF = new Document(); //documento vazio
		
		try {
			PdfWriter.getInstance(documentoPDF, new FileOutputStream(nomePDF));
			documentoPDF.open();//abre o documento
			documentoPDF.setPageSize(PageSize.A4);
			
			//Cabe�alho para todos os relat�rios---
			Paragraph p = new Paragraph("Semestre "+identificacao);
			p.setAlignment(1);
			documentoPDF.add(p);
			p = new Paragraph("\n");
			documentoPDF.add(p);
			//---
			//Gerando tabelas
			for(Semestre item : semestres) {
				if(item.getIdentificacao().equals(identificacao)) {
					for(Disciplina second_item : item.disciplinas) {
						documentoPDF.add(new Paragraph(second_item.toString()));
						documentoPDF.add(new Paragraph("\n"));
						PdfPTable table = this.gerarTabelas(identificacao);
						documentoPDF.add(table);	
						PdfPTable situacoes = new PdfPTable(2);
						PdfPCell cel1 = new PdfPCell(new Paragraph("M�dia"));
						PdfPCell cel2 = new PdfPCell(new Paragraph("Situa��o"));
						situacoes.addCell(cel1);
						situacoes.addCell(cel2);
						documentoPDF.add(situacoes);
					}
				}
			}
			
			
			
			
			documentoPDF.close();
		}catch(Exception e) {
			
		}
		
	}
	
	public PdfPTable gerarTabelas(String identificacao) {
		
		//EM ANDAMENTO
		PdfPTable table = new PdfPTable(4);
		for(Semestre item : semestres) {
			if(item.getIdentificacao().equals(identificacao)) {
				for(Disciplina second_item : item.disciplinas) {
					PdfPCell cel1 = new PdfPCell(new Paragraph("Avalia��o"));
					cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell cel2 = new PdfPCell(new Paragraph("Data"));
					cel2.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell cel3 = new PdfPCell(new Paragraph("Peso"));
					cel3.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell cel4 = new PdfPCell(new Paragraph("Nota"));
					cel4.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cel1);
					table.addCell(cel2);
					table.addCell(cel3);
					table.addCell(cel4);
					
					for(Avaliacao av : second_item.avaliacoes) {
						cel1 = new PdfPCell(new Paragraph(av.getNome()));
						cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
						cel2 = new PdfPCell(new Paragraph(av.getData()));
						cel2.setHorizontalAlignment(Element.ALIGN_CENTER);
						cel3 = new PdfPCell(new Paragraph(" "+av.getPeso()+" "));
						cel3.setHorizontalAlignment(Element.ALIGN_CENTER);
						cel4 = new PdfPCell(new Paragraph(" "+av.getNota()+" "));
						cel4.setHorizontalAlignment(Element.ALIGN_CENTER);
						table.addCell(cel1);
						table.addCell(cel2);
						table.addCell(cel3);
						table.addCell(cel4);
					}
					
				}
			}
		}
		return table;
		
	}

}
