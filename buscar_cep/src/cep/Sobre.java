package cep;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	//começo da aplicação
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home_icon.png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblVersao = new JLabel("Buscar CEP - Ver 1.0");
		lblVersao.setBounds(64, 39, 150, 21);
		getContentPane().add(lblVersao);
		
		JLabel lblAutor = new JLabel("@Autor Gustavo Henrique");
		lblAutor.setBounds(64, 71, 150, 21);
		getContentPane().add(lblAutor);
		
		JLabel lblWebService = new JLabel("WEB Service: ");
		lblWebService.setBounds(64, 103, 91, 21);
		getContentPane().add(lblWebService);
		
		JLabel lblUrlWebService = new JLabel("republicavirtual.com.br");
		lblUrlWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //evento de clique no URLWebService
				link("https://www.republicavirtual.com.br/");
			}
		});
		lblUrlWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUrlWebService.setForeground(new Color(0, 128, 255));
		lblUrlWebService.setBounds(165, 103, 131, 21);
		getContentPane().add(lblUrlWebService);
		
		JButton btnGithub = new JButton("");
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //clicar no botao github
				link("https://github.com/Gustavo7K");
			}
		});
		btnGithub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/github_icon.png")));
		btnGithub.setBounds(64, 156, 48, 48);
		getContentPane().add(btnGithub);

	}// fim do construtor
	
	//metodo para abrir sites externos
	private void link(String site) {  // metodo e parametro
		Desktop desktop = Desktop.getDesktop(); //objeto desktop obtendo a interface do usuario
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
