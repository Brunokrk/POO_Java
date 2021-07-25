package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.Semestre;
import dados.Disciplina;
import dados.Avaliacao;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.Paragraph;
//import persistencia.*;
import excecoes.*;


public class Sistema {
	private static Sistema instance = null;
	private List<Semestre> semestres;
	private SemestreDAO semestreDAO; 
	private DisciplinaDAO disciplinaDAO;
	private AvaliacaoDAO avaliacaoDAO;

	public Sistema() {
		semestres = semestreDAO.getInstance().selectAll();
	}
	
	public static Sistema getInstance() {
		if (instance == null) {
			instance = new Sistema();
		}
		return instance;
	}
	
	public void cadastrarSemestre(Semestre semestre) {
		this.semestres.add(semestre);
		semestreDAO.getInstance().insert(semestre);
	}
	
	public void excluirSemestre(String identificação) {
		
		for(int i=0; i<semestres.size();i++) {
			Semestre s = semestres.get(i);
			if(s.getIdentificacao().equals(identificação)) {
				Semestre aux = semestreDAO.getInstance().select(s.getId());
				semestreDAO.getInstance().delete(aux);
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
					disciplinaDAO.getInstance().insert(disciplina);
					
				}else {
					System.out.println("ERRO 004 - DISCIPLINA JÁ EXISTE");
				}
			}
		}
	}
	
	public void excluirDisciplina(String identificacao, String cod) {
		for(Semestre item : semestres) {
			if (item.getIdentificacao().equals(identificacao)) {
				List<Disciplina> disciplinas = disciplinaDAO.getInstance().selectAll(item.getId());
				
				for(Disciplina dis : disciplinas) {
					if(dis.getCodDisciplina().equals(cod)) {
						disciplinaDAO.getInstance().delete(dis);
						item.excluirDisciplina(cod);
					}
				}
			}
		}
	}
	
	public void editarDisciplina(Disciplina disciplinaA, Semestre semestre, Disciplina disciplinaB) {
		//E criar um método que busca as novas informações
		disciplinaB.setId(disciplinaA.getId());
		for(Semestre item : semestres) {
			if (item.equals(semestre)) {
				for(Disciplina dis : item.getDisciplinas()) {
					if(dis.equals(disciplinaB)) {
						disciplinaDAO.getInstance().update(disciplinaB);	
						item.editarDisciplina(disciplinaA, disciplinaB);
					}
				}
			}
		}
	}
	
	public void cadastrarAvaliacao(Semestre semestre, Disciplina disciplina, Avaliacao avaliacao) {
		for(Semestre item : semestres) {
			if (item.equals(semestre)) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.equals(disciplina)) {
						second_item.cadastrarAvaliacao(avaliacao);
						avaliacaoDAO.getInstance().insert(avaliacao);
						disciplinaDAO.getInstance().updateMedias(second_item.getId());
					}
				}
			}
		}
	}
	
	public void editarAvaliacao(Avaliacao avA, Avaliacao avB, Semestre semestre, Disciplina disciplina) {
		avB.setId(avA.getId());
		avB.setIdDisciplina(avA.getIdDisciplina());
		for(Semestre item : semestres) {
			if (item.equals(semestre)) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.equals(disciplina)) {
						for(Avaliacao third_item : second_item.avaliacoes) {
							if(third_item.equals(avA)) {
								avaliacaoDAO.getInstance().update(avB);
								second_item.editarAvaliacao(avA, avB);
							}
						}
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
						//achou a disciplina que contem a avaliacao
						List<Avaliacao> avs = avaliacaoDAO.getInstance().selectAll(second_item.getId());
						for(Avaliacao av : avs) {
							if(av.getNome().equals(nome)) {
								avaliacaoDAO.getInstance().delete(av);
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
			//mostraDisciplinas(item);
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
		System.out.println("**********AVALIAÇÕES CADASTRADAS**********");
		for(Avaliacao item : d.avaliacoes) {
			System.out.println("| "+item.toString()+" |");
		}
	
	}
	
	public void mostraAvaliacoes(String identificacao, String cod) {
		System.out.println("**********AVALIAÇÕES CADASTRADAS**********");
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
	
	public void geradorNotasESituacao(String id) {
		//Este método gera as médias de todas as disciplinas do semestre X, para plotagem no PDF resultante
		
		for(Semestre semestre : semestres) {
			if(semestre.getIdentificacao().equals(id)) {
				for (Disciplina disciplina : semestre.disciplinas) {
					disciplina.calculoMedia();
					if(disciplina.getMedia() < 7.0) {
						disciplina.setSituacao(false);
						disciplina.notaNecessaria();
					}else {
						disciplina.setSituacao(true);
					}
				}
			}
		}
	}
		
	
	//----Métodos referentes á Biblioteca itext---- EM ANDAMENTO, NÃO FAZ PARTE DA ENTREGA 2
	//Posteriormente entrará na persistencia de dados
	
	public void gerarPDF(String identificacao) {
		String nomePDF = "C:\\Users\\pires\\Documents\\GitHub\\poo\\App_Notas\\relatorios\\Semestre" + identificacao+".pdf";
		Document documentoPDF = new Document(); //documento vazio
		geradorNotasESituacao(identificacao);
		try {
			PdfWriter.getInstance(documentoPDF, new FileOutputStream(nomePDF));
			documentoPDF.open();//abre o documento
			documentoPDF.setPageSize(PageSize.A4);
			
			//Cabeçalho para todos os relatórios---
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
						PdfPTable table = this.gerarTabelas(identificacao, second_item.getCodDisciplina());
						documentoPDF.add(table);	
						PdfPTable situacoes = new PdfPTable(2);
						PdfPCell cel1 = new PdfPCell(new Paragraph("Média: "+second_item.getMedia()));
						second_item.notaNecessaria();
						PdfPCell cel2 = null;
						if(second_item.isSituacao() == false) {
							cel2 = new PdfPCell(new Paragraph("Situação: Não Aprovado     Necessário: "+second_item.getNota_aprovacao()));
						}else if(second_item.isSituacao() == true) {
							cel2 = new PdfPCell(new Paragraph("Situação: Aprovado"));
						}
						situacoes.addCell(cel1);
						situacoes.addCell(cel2);
						documentoPDF.add(situacoes);
					}
				}
			}
			Desktop.getDesktop().open(new File(nomePDF));
			documentoPDF.close();
		}catch(Exception e) {
			
		}
		
	}
	
	public PdfPTable gerarTabelas(String identificacao, String codDiscip) {
		//EM ANDAMENTO
		PdfPTable table = new PdfPTable(4);
		for(Semestre item : semestres) {
			if(item.getIdentificacao().equals(identificacao)) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.getCodDisciplina().equals(codDiscip)) {
						
						PdfPCell cel1 = new PdfPCell(new Paragraph("Avaliação"));
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
		}
		return table;
	}

}
