package DiceController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import DiceView.ClientFrame;
import DiceView.LoginFrame;
import DiceView.MainFrame;
import main.ClientMain;

public class ClientController extends MouseAdapter {
	MainFrame mainFrame;

	public void mouseClicked(MouseEvent e) {
		String host = "";
		int port = 0;
		String userID = "";
		
		mainFrame = new MainFrame();
		
		JButton btn = (JButton) e.getSource();

		if (btn.getText().equals("연결")) { 
			//try {
				//userID=ClientFrame.getInstance().userIDTf.getText();
				//System.out.println(userID);
			//} catch (ArrayIndexOutOfBoundsException e1) { //??배열의 인덱스가 왜 벗어나?????
				//System.out.println("ERROR - No login ID specified. Connection aborted.");
				//System.exit(1);
			//}
			try {
				host = ClientFrame.getInstance().serverIPTf.getText();
			} catch (ArrayIndexOutOfBoundsException e1) {
				host = "localhost";
			}

			try {
				port = Integer.parseInt(ClientFrame.getInstance().serverPortTf.getText());
			} catch (Throwable t) {
				port = 5555;  //DEFAULT_PORT;
				//System.out.println("클라이언트컨트롤러에서  포트 = " + port);
			}
			
			//여기 코드에는 서버에게 메시지 보내는건 없는데 어디서 보내는지 찾아보기
			ClientFrame.getInstance().chat = new ClientMain(host, port, userID); //아이디 무조건 보내는 방식으로 되어있음..
			boolean checkAccept = ClientFrame.getInstance().chat.getClient().isConnected();
			
			//받아들이면 로그인프레임
			if(checkAccept){
				LoginFrame.getInstance().setVisible(true);
				ClientFrame.getInstance().dispose();
			}
			else{
				//
			}
		}else if(btn.getText().equals("종료")){ //처음프레임에서 종료는 아직 연결이 되어있지 않은 상태라서 메시지 보낼필요없지 않아?
			//String msg = null;
			//ClientFrame.getInstance().chat.getClient().handleMessageFromClientUI("종료"); //?
			//ClientFrame.getInstance().chat.getClient().handleMessageFromServer(msg);
			ClientFrame.getInstance().dispose();
		}
	}
}
