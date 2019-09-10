package clue.controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import clue.model.vo.Player;

public class ComputerGuess extends JDialog {
	private JLabel guessLabel;
	private JButton DialogBtn;
	private JLabel resultLabel;

	public ComputerGuess(Player[] playerArr, int index, JButton[] buttonArray, JLabel[] labelArray) {

		setTitle("안내");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setBounds(d.width / 2 - 150, d.height / 2 - 100, 300, 200);
		setLayout(null);

		// 추측하기
		Random r = new Random();
		// 사람 랜덤으로 뽑기
		int personRnd = r.nextInt(playerArr[index].getPersonInfo().size());
		String guessPerson = (String) (playerArr[index].getPersonInfo().get(personRnd));
		// 현재장소 뽑기
		int location = playerArr[index].getLocation();
		String guessPlace = "";
		// 만약 위치가 침실이라면
		if (location == 0 | location == 10 | location == 20 | location == 30 | location == 31 | location == 40
				| location == 41) {
			guessPlace = "침실";
		}
		// 만약위치가 욕실이라면
		else if (location == 1 | location == 2 | location == 3 | location == 4) {
			guessPlace = "욕실";
		}
		// 만약 위치가 서재라면
		else if (location == 5 | location == 6 | location == 7 | location == 8 | location == 15 | location == 16
				| location == 17 | location == 18 | location == 25 | location == 26 | location == 27 | location == 28) {
			guessPlace = "서재";
		}
		// 만약 위치가 부엌이라면
		else if (location == 9 | location == 19 | location == 29 | location == 39 | location == 49) {
			guessPlace = "부엌";
		}
		// 만약 위치가 식당이라면
		else if (location == 58 | location == 59 | location == 68 | location == 69 | location == 78 | location == 79
				| location == 88 | location == 89 | location == 98 | location == 99) {
			guessPlace = "식당";
		}
		// 만약 위치가 거실이라면
		else if (location == 109 | location == 119 | location == 129 | location == 139 | location == 149) {
			guessPlace = "거실";
		}
		// 만약 위치가 마당이라면
		else if (location == 131 | location == 132 | location == 141 | location == 142 | location == 143
				| location == 144 | location == 145 | location == 146 | location == 147 | location == 148
				| location == 137 | location == 138) {
			guessPlace = "마당";
		}
		// 만약 위치가 차고라면
		else if (location == 110 | location == 120 | location == 130 | location == 140) {
			guessPlace = "차고";
		}
		// 만약 위치가 게임룸이라면
		else if (location == 50 | location == 60 | location == 70 | location == 80 | location == 90 | location == 100) {
			guessPlace = "게임룸";
		}
		// 도구 랜덤으로 뽑기
		int thingsRnd = r.nextInt(playerArr[index].getThingsInfo().size());
		String guessThings = (String) (playerArr[index].getThingsInfo().get(personRnd));

		// 추측라벨
		guessLabel = new JLabel("추측 : " + guessPerson + "이/가 " + guessPlace + "에서 " + guessThings + "를 가지고 죽였다!");
		guessLabel.setFont(new Font("추측", Font.BOLD, 11));
		guessLabel.setBounds(1, 20, 300, 20);

		// for (int i = 0; i < playerArr.length; i++) {
		// for (int a = 0; a < 3; a++) {
		// System.out.print(playerArr[i].getMyCard()[a] + " ");
		// }
		// System.out.println();
		// }

		resultLabel = new JLabel();
		// 결과추출하기
		
		int resultIndex = index;
		outer: while (true) {
			resultIndex--;
			if (resultIndex == -1) {
				resultIndex = 5;
			}
			for (int i = 0; i < 3; i++) {
				if (playerArr[resultIndex].getMyCard()[i].equals(guessPerson)
						|| playerArr[resultIndex].getMyCard()[i].equals(guessPlace)
						|| playerArr[resultIndex].getMyCard()[i].equals(guessThings)) {
					
					if (playerArr[index].getName().equals("나 ")) {
						if (playerArr[resultIndex].getMyCard()[i].equals(guessPerson)) {
							if(playerArr[resultIndex].getMyCard()[i].equals(guessPlace)) {
								if(playerArr[resultIndex].getMyCard()[i].equals(guessThings)) {
									int rnd = r.nextInt(3) + 1;
									switch(rnd) {
									case 1: resultLabel.setText(playerArr[resultIndex].getCharacter() + "("
											+ playerArr[resultIndex].getName() + ")" + "이/가 " + guessPerson + " 카드를 보여줬습니다."); break;
									case 2:resultLabel.setText(playerArr[resultIndex].getCharacter() + "("
											+ playerArr[resultIndex].getName() + ")" + "이/가 " + guessPlace + " 카드를 보여줬습니다.");break;
									case 3:	resultLabel.setText(playerArr[resultIndex].getCharacter() + "("
											+ playerArr[resultIndex].getName() + ")" + "이/가 " + guessThings + " 카드를 보여줬습니다.");break;
									}
								} else {
									int rnd = r.nextInt(2) + 1;
									switch(rnd) {
									case 1: resultLabel.setText(playerArr[resultIndex].getCharacter() + "("
											+ playerArr[resultIndex].getName() + ")" + "이/가 " + guessPerson + " 카드를 보여줬습니다."); break;
									case 2:resultLabel.setText(playerArr[resultIndex].getCharacter() + "("
											+ playerArr[resultIndex].getName() + ")" + "이/가 " + guessPlace + " 카드를 보여줬습니다."); break;
									}
								}
							}else {
								resultLabel.setText(playerArr[resultIndex].getCharacter() + "("
										+ playerArr[resultIndex].getName() + ")" + "이/가 " + guessPerson + " 카드를 보여줬습니다."); break;
							}
							
						} else if (playerArr[resultIndex].getMyCard()[i].equals(guessPlace)) {
							resultLabel.setText(playerArr[resultIndex].getCharacter() + "("
									+ playerArr[resultIndex].getName() + ")" + "이/가 " + guessPlace + " 카드를 보여줬습니다.");
						} else {
							resultLabel.setText(playerArr[resultIndex].getCharacter() + "("
									+ playerArr[resultIndex].getName() + ")" + "이/가 " + guessThings + " 카드를 보여줬습니다.");
						}

					} else {
						resultLabel.setText(playerArr[resultIndex].getCharacter() + "("
								+ playerArr[resultIndex].getName() + ")" + "이/가 카드를 보여줬습니다.");
					}
					break outer;
				}
			}
			if (index + 1 == resultIndex) {
				break;
			}
		}

		if (resultLabel.getText().equals("")) {
			resultLabel.setText("카드를 가지고 있는 사람이 없습니다.");
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		for (int i = 0; i < playerArr.length; i++) {
			System.out.println(playerArr[i].toString());
		}
		// 결과라벨

		resultLabel.setBounds(1, 70, 300, 20);

		// 버튼설정
		DialogBtn = new JButton("확인");
		DialogBtn.setBounds(110, 120, 60, 30);

		// 버튼 이벤트
		DialogBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TurnDialog(playerArr, index + 1, buttonArray, labelArray);

			}
		});

		add(guessLabel);
		add(resultLabel);
		add(DialogBtn);
		setFocusable(true);
		setVisible(true);

	}
}
