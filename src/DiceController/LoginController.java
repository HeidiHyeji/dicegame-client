package DiceController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import DiceView.ClientFrame;
import DiceView.JoinFrame;
import DiceView.LoginFrame;
import DiceView.MainFrame;
import client.ClientState;

public class LoginController extends MouseAdapter {
	private ClientState clientState = null;
	String userId = null;
	String userPasswd = null;
	MainFrame mainFrame;

	public void mousePressed(MouseEvent e) {
		clientState = ClientFrame.getInstance().chat.getClient(); // ClientState객체
																	// 받아옴
		JButton btn = (JButton) e.getSource();// 이벤트로부터 버튼 받아옴

		if (btn.getText().equals("로그인")) {
			userId = LoginFrame.getInstance().idTf.getText();
			userPasswd = LoginFrame.getInstance().passwdTf.getText();
			// 아이디텍스트필드에 아이디 입력 안 한경우
			if (userId.equals("")) {
				JOptionPane.showConfirmDialog(null, "아이디를 입력하세요.", " ", JOptionPane.CLOSED_OPTION,
						JOptionPane.ERROR_MESSAGE);
			}
			// 패스워드텍스트필드에 패스워드 입력 안 한경우
			else if (userPasswd.equals("")) {
				JOptionPane.showConfirmDialog(null, "비밀번호를 입력하세요.", " ", JOptionPane.CLOSED_OPTION,
						JOptionPane.ERROR_MESSAGE);
			}
			// 모두 잘 입력하면 서버에게 메시지 보냄 로그인 시도
			else {
				clientState.handleMessageFromClientUI("로그인 " + userId + " " + userPasswd + " ");
			}

		}
		// 회원가입버튼 누름 -> 이거 릴리즈에 넣으면 안된다 이유는? 프레스이벤트가 없어서 그런가??
		else if (btn.getText().equals("회원가입")) {
			// 회원가입창 띄움 로그인창은 그대로
			JoinFrame.getInstance().setVisible(true);

		} else if (btn.getText().equals("취소")) {
			// 로그인창 dispose
			LoginFrame.getInstance().dispose();
			clientState.handleMessageFromClientUI("종료"); // 로그인 취소하겠다는 건 서버와 연결
															// 끊김
		}
	}

	public void mouseReleased(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		try {
			Thread.sleep(800);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (btn.getText().equals("로그인")) {
			// 서버한테 메시지 받아오기
			if (clientState.loginSuccess.equals("로그인완료")) { // 로그인 완료된 것 로그인창 꺼짐
				LoginFrame.getInstance().dispose();
				mainFrame = new MainFrame();
				mainFrame.setVisible(true);

			} else if (clientState.loginSuccess.equals("로그인불가")) { // 없는 아이디 OR
																	// 아이디 비밀번호
																	// 불일치
				JOptionPane.showConfirmDialog(null, "아이디와 비밀번호를 다시 확인해주세요.", "!", JOptionPane.CLOSED_OPTION,
						JOptionPane.ERROR_MESSAGE);
				// 텍스트필드 리셋
				LoginFrame.getInstance().idTf.setText("");
				LoginFrame.getInstance().passwdTf.setText("");
			}
		}

	}

}
