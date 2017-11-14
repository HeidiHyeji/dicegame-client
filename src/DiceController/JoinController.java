package DiceController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import DiceView.ClientFrame;
import DiceView.JoinFrame;
import client.ClientState;

public class JoinController extends MouseAdapter {
	private ClientState clienetState = null;
	String joinUserId = "";
	String joinUserPw = "";
	String joinUserName = "";
	
	//서버에게 보내고 받는 것 같은 이벤트에서 불가 프레스와 릴리즈로 나눔
	public void mousePressed(MouseEvent e) {
		clienetState = ClientFrame.getInstance().chat.getClient();
		JButton btn = (JButton)e.getSource();
		
		if (btn.getText().equals("가입")) {
			joinUserId = JoinFrame.getInstance().joinIdTf.getText();//텍스트필드에서 사용자가 입력한 아이디받아옴
			joinUserPw = JoinFrame.getInstance().joinPwTf.getText();//비밀번호받아옴
			joinUserName = JoinFrame.getInstance().joinNameTf.getText();//이름받아옴
			
			//빈칸검사
			if(joinUserId.equals("") || joinUserPw.equals("") || joinUserName.equals("")){
				JOptionPane.showConfirmDialog(null, "모두 채워 쓰세요.", " ", JOptionPane.CLOSED_OPTION,
								JOptionPane.ERROR_MESSAGE);
			}
			//서버한테 메시지보내기
			clienetState.handleMessageFromClientUI("가입"+" "+joinUserId+" "+joinUserPw+" "+joinUserName);
		} 
		else if (btn.getText().equals("취소")) {
			JoinFrame.getInstance().dispose(); 
		}
		
	}
	
	public void mouseRelease(MouseEvent e) {
		JButton btn = (JButton)e.getSource(); //이벤트로부터 버튼받아오기
		/* 여기있으면 작동안해서 클라이언트스테이트로 보냄
		if (btn.getText().equals("가입")) {
			if(clienetState.serverMassage.equals("가입완료")){//안됨..
				JOptionPane.showConfirmDialog(null, "가입이 완료되었습니다.", " ", JOptionPane.CLOSED_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				JoinFrame.getInstance().dispose(); //가입창 끄고 로그인해서 게임시작하기
			}else if(clienetState.serverMassage.equals("가입불가")){ //존재하는 아이디
				JOptionPane.showConfirmDialog(null, "사용할 수 없는 아이디 입니다.", " ", JOptionPane.CLOSED_OPTION,
					JOptionPane.ERROR_MESSAGE);
				
				//텍스트 필드 리셋
				JoinFrame.getInstance().joinIdTf.setText("");
				JoinFrame.getInstance().joinPwTf.setText("");
				JoinFrame.getInstance().joinNameTf.setText("");
			}
		}
		*/
		//그냥 가입취소라서 꺼지기만 하면됨
				
	}

}
