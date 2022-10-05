package ClassesConexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JButton btnCadastrar;
	private JButton btnEntrar;
	private JLabel lblAquiTemUma;
	private JLabel lblOlSejaBemvindo;
	private JLabel lblFaaSeuLogin_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("E-MAIL:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(359, 324, 86, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSenha.setBounds(359, 383, 86, 33);
		contentPane.add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
		tfUsuario.setBounds(455, 324, 644, 33);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		pfSenha.setBounds(455, 383, 644, 33);
		contentPane.add(pfSenha);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBackground(new Color(255, 140, 0));
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					
					Connection con = Conexao.faz_conexao();
					String sql = "select *from cadastro_usuario where email=? and senha=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, new String(pfSenha.getPassword()));
					ResultSet rs = stmt.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Entrando!");
						TelaOpcoes exibir = new TelaOpcoes();
						exibir.setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "E-mail ou senha incorreto!");
					}
					stmt.close();
					con.close();
							
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
		btnEntrar.setBounds(534, 517, 195, 72);
		contentPane.add(btnEntrar);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(new Color(255, 140, 0));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					TelaCadastro exibir = new TelaCadastro();
					exibir.setVisible(true);
					setVisible(false);
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 18));
		btnCadastrar.setBounds(885, 517, 183, 72);
		contentPane.add(btnCadastrar);
		
		lblAquiTemUma = new JLabel("AQUI TEM UMA OPORTUNIDADE PARA VOCÊ...");
		lblAquiTemUma.setForeground(Color.BLACK);
		lblAquiTemUma.setHorizontalAlignment(SwingConstants.CENTER);
		lblAquiTemUma.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAquiTemUma.setBounds(0, 141, 1551, 28);
		contentPane.add(lblAquiTemUma);
		
		lblOlSejaBemvindo = new JLabel("OLÁ, SEJA BEM-VINDO!");
		lblOlSejaBemvindo.setForeground(Color.BLACK);
		lblOlSejaBemvindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblOlSejaBemvindo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblOlSejaBemvindo.setBounds(0, 110, 1540, 28);
		contentPane.add(lblOlSejaBemvindo);
		
		lblFaaSeuLogin_1 = new JLabel("FAÇA SEU LOGIN E VERIFIQUE AS VAGAS DISPONÍVEIS EM NOSSO PORTAL.");
		lblFaaSeuLogin_1.setForeground(Color.BLACK);
		lblFaaSeuLogin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaaSeuLogin_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFaaSeuLogin_1.setBounds(0, 174, 1551, 28);
		contentPane.add(lblFaaSeuLogin_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ariane Sousa\\Pictures\\PRO4TECH.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 517, 100);
		contentPane.add(lblNewLabel_1);
	}
}
