package br.gov.cesarschool.poo.bonusvendas.tela;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import br.gov.cesarschool.poo.bonusvendas.negocio.*;
import br.gov.cesarschool.poo.bonusvendas.dao.*;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
public class TelaManutencaoVendedor {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 * 
	 */
	//VendedorDAO vendedorDAO = new vendedorDAO();
	//LancamentoBonusDAO lancamentoBonusDAO= new lancamentoBonusDAO();
	private VendedorMediator mediator = VendedorMediator.getInstancia();
	
	private Text cpf;
	private Text nome;
	private Text nascimento;
	private Text renda;
	private Text logradouro;
	private Text numero;
	private Text complemento;
	private Text CEP;
	private Text cidade;
	private Text estado;
	private Text txtNome;
	private Text txtCpf;
	private Text txtSexo;
	private Button btnNewButton;
	private Text txtLogradouro;
	
	
	
	public static void main(String[] args) {
		try {
			TelaManutencaoVendedor window = new TelaManutencaoVendedor();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(943, 513);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Button btnButao = new Button(shell, SWT.NONE);
		btnButao.setTouchEnabled(true);
		btnButao.setBounds(332, 36, 144, 35);
		btnButao.setText("butao");
		btnButao.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // Coloque o código que deseja executar quando o botão "butao" for clicado aqui.
		        // Por exemplo, exibir uma mensagem.
		        System.out.println("Botão 'butao' foi clicado!");
		    }
		});
		
		Button btnOtoButao = new Button(shell, SWT.NONE);
		btnOtoButao.setTouchEnabled(true);
		btnOtoButao.setBounds(332, 87, 144, 35);
		btnOtoButao.setText("oto butao");
		
		Button btnboton = new Button(shell, SWT.NONE);
		btnboton.setTouchEnabled(true);
		btnboton.setBounds(332, 144, 144, 35);
		btnboton.setText("butaoao");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setText("NOME:");
		txtNome.setTouchEnabled(true);
		txtNome.setEnabled(true);
		txtNome.setBounds(112, 38, 189, 31);
		
		txtCpf = new Text(shell, SWT.BORDER);
		txtCpf.setText("cpf");
		txtCpf.setBounds(112, 89, 189, 31);
		
		txtSexo = new Text(shell, SWT.BORDER);
		txtSexo.setText("sexo");
		txtSexo.setBounds(112, 146, 189, 31);
		
		Button btnLimpada = new Button(shell, SWT.NONE);
		btnLimpada.setTouchEnabled(true);
		btnLimpada.setBounds(371, 390, 105, 35);
		btnLimpada.setText("Limpada");
		// ...

		// Adicione um ouvinte ao botão "Limpada" para lidar com o evento de clique.
		btnLimpada.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // Lógica para limpar os campos de texto
		        txtCpf.setText("");
		        txtNome.setText("");
		        txtSexo.setText("");
		        txtLogradouro.setText("Logradouro");
		        // Limpe outros campos de texto, se necessário.
		    }
		});
		// ...

		btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setTouchEnabled(true);
		btnNewButton.setBounds(351, 221, 105, 35);
		btnNewButton.setText("New Button");
		
		txtLogradouro = new Text(shell, SWT.BORDER);
		txtLogradouro.setText("Logradouro");
		txtLogradouro.setBounds(94, 225, 189, 31);
		
		

	}
}
