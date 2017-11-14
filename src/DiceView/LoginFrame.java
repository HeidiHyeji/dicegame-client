package DiceView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import DiceController.LoginController;

public class LoginFrame extends JFrame {

	private static LoginFrame loginFrame = null;

	public static LoginFrame getInstance() {
		if (loginFrame == null) {
			loginFrame = new LoginFrame();
		}
		return loginFrame;
	}

	private JPanel contentPane;
	public JTextField idTf;
	public JTextField passwdTf;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try {
	 * LoginFrame.getInstance().setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	public LoginFrame() {
		super("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 280, 638, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel idLb = new JLabel("아이디");
		idLb.setFont(new Font("굴림", Font.PLAIN, 22));
		idLb.setBounds(150, 107, 78, 21);
		contentPane.add(idLb);

		JLabel passwdLb = new JLabel("비밀번호");
		passwdLb.setFont(new Font("굴림", Font.PLAIN, 22));
		passwdLb.setBounds(132, 181, 117, 21);
		contentPane.add(passwdLb);

		idTf = new JTextField();
		idTf.setFont(new Font("굴림", Font.PLAIN, 22));
		idTf.setBounds(266, 103, 156, 27);
		contentPane.add(idTf);
		idTf.setColumns(10);

		passwdTf = new JTextField();
		passwdTf.setFont(new Font("굴림", Font.PLAIN, 22));
		passwdTf.setBounds(266, 177, 156, 27);
		contentPane.add(passwdTf);
		passwdTf.setColumns(10);

		JButton loginBt = new JButton("로그인");
		loginBt.setFont(new Font("굴림", Font.PLAIN, 22));
		loginBt.setBounds(86, 264, 125, 29);
		loginBt.addMouseListener(new LoginController());
		contentPane.add(loginBt);

		JButton joinBt = new JButton("회원가입");
		joinBt.setFont(new Font("굴림", Font.PLAIN, 22));
		joinBt.setBounds(266, 264, 125, 29);
		joinBt.addMouseListener(new LoginController());
		contentPane.add(joinBt);

		JButton cancelBt = new JButton("취소");
		cancelBt.setFont(new Font("굴림", Font.PLAIN, 22));
		cancelBt.setBounds(429, 264, 125, 29);
		cancelBt.addMouseListener(new LoginController());
		contentPane.add(cancelBt);
	}
}
