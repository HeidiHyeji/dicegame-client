package DiceView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DiceController.JoinController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class JoinFrame extends JFrame {
	
	private static JoinFrame joinFrame = null;
	
	public static JoinFrame getInstance() {
		if (joinFrame == null) {
			joinFrame = new JoinFrame();
		}
		return joinFrame;
	}

	private JPanel contentPane;
	public JTextField joinIdTf;
	public JTextField joinPwTf;
	public JTextField joinNameTf;
	
	public JButton joinBt;
	public JButton cancelBt;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinFrame.getInstance().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JoinFrame() {
		super("회원가입");
		setBounds(450, 280, 638, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel joinIdLb = new JLabel("아이디");
		joinIdLb.setFont(new Font("굴림", Font.PLAIN, 22));
		joinIdLb.setBounds(161, 82, 78, 21);
		contentPane.add(joinIdLb);
		
		JLabel joinPwLb = new JLabel("비밀번호");
		joinPwLb.setFont(new Font("굴림", Font.PLAIN, 22));
		joinPwLb.setBounds(147, 148, 108, 21);
		contentPane.add(joinPwLb);
		
		JLabel joinPwCheckLb = new JLabel("이름");
		joinPwCheckLb.setFont(new Font("굴림", Font.PLAIN, 22));
		joinPwCheckLb.setBounds(175, 217, 68, 21);
		contentPane.add(joinPwCheckLb);
		
		joinIdTf = new JTextField();
		joinIdTf.setFont(new Font("굴림", Font.PLAIN, 22));
		joinIdTf.setBounds(306, 78, 189, 27);
		contentPane.add(joinIdTf);
		joinIdTf.setColumns(10);
		
		joinPwTf = new JTextField();
		joinPwTf.setFont(new Font("굴림", Font.PLAIN, 22));
		joinPwTf.setBounds(306, 144, 189, 27);
		contentPane.add(joinPwTf);
		joinPwTf.setColumns(10);
		
		joinNameTf = new JTextField();
		joinNameTf.setFont(new Font("굴림", Font.PLAIN, 22));
		joinNameTf.setBounds(306, 213, 189, 27);
		contentPane.add(joinNameTf);
		joinNameTf.setColumns(10);
		
		joinBt = new JButton("가입");
		joinBt.setFont(new Font("굴림", Font.PLAIN, 22));
		joinBt.setBounds(161, 319, 125, 29);
		joinBt.addMouseListener(new JoinController());
		contentPane.add(joinBt);
		
		cancelBt = new JButton("취소");
		cancelBt.setFont(new Font("굴림", Font.PLAIN, 22));
		cancelBt.setBounds(337, 319, 125, 29);
		cancelBt.addMouseListener(new JoinController());
		contentPane.add(cancelBt);
	}
}
