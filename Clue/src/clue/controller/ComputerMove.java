package clue.controller;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import clue.model.vo.Player;

public class ComputerMove extends JDialog {
	private Player[] playerArr;
	private JLabel DialogLabel;
	private JButton DialogBtn;
	int first = 0;
	// 말의 이미지 위치
	String image = "";
	Random r = new Random();

	public ComputerMove() {

	}

	public ComputerMove(Player[] playerArr, int index, JButton[] buttonArray, JLabel[] labelArray) {
		setTitle("안내");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setBounds(d.width / 2 - 150, d.height / 2 - 100, 300, 200);
		setLayout(null);
		// 랜덤 주사위값
		int move = r.nextInt(10) + 3;
		// 라벨 설정
		DialogLabel = new JLabel(
				playerArr[index].getCharacter() + "(" + playerArr[index].getName() + ") 이" + move + "만큼 움직입니다.");
		DialogLabel.setBounds(60, 30, 250, 20);

		// 버튼설정
		DialogBtn = new JButton("확인");
		DialogBtn.setBounds(110, 120, 60, 30);

		// 버튼 이벤트
		DialogBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Move(playerArr, index, move, buttonArray, labelArray);
				dispose();

			}
		});
		add(DialogLabel);
		add(DialogBtn);
		setFocusable(true);
		setVisible(true);
	}

	public void Move(Player[] playerArr, int index, int move, JButton[] buttonArray, JLabel[] labelArray) {
		if (index == 6) {
			index = 0;
		}
		if (playerArr[index].getCharacter() == "그린") {
			image = "images/그린.jpg";
		} else if (playerArr[index].getCharacter() == "머스타드") {
			image = "images/머스타드.jpg";
		} else if (playerArr[index].getCharacter() == "스칼렛") {
			image = "images/스칼렛.jpg";
		} else if (playerArr[index].getCharacter() == "플럼") {
			image = "images/플럼.jpg";
		} else if (playerArr[index].getCharacter() == "피콕") {
			image = "images/피콕.jpg";
		} else if (playerArr[index].getCharacter() == "화이트") {
			image = "images/화이트.jpg";
		}
		int location = playerArr[index].getLocation();
		// 만약 위치가 클루라면
		if (location == 73 | location == 74 | location == 75 | location == 76 | location == 83 | location == 84
				| location == 85 | location == 86 | location == 93 | location == 94 | location == 95 | location == 96) {
			// 클루에서 갈수 있는 9개의 방 랜덤정하기.
			 int method9 = r.nextInt(9) + 1;
			
			switch (method9) {
			// 게임룸으로
			case 1:
				buttonArray[location].setIcon(null);
				location = 80;
				buttonArray[location].setIcon(
						new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
				// "추측하기 세트로 복사할것"
				playerArr[index].setLocation(location);
				new ComputerGuess(playerArr, index, buttonArray,labelArray);
				break;
			// 침실로
			case 2:
				if (move > 8) {
					buttonArray[location].setIcon(null);
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 20;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 욕실로
			case 3:
				if (move > 8) {
					buttonArray[location].setIcon(null);
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "?카드뽑기"
					playerArr[index].setScore(playerArr[index].getScore() + 10);
					labelArray[index].setText(playerArr[index].getName() + "\t" + playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 3;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 서재로
			case 4:
				if (move > 9) {
					buttonArray[location].setIcon(null);
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "?카드뽑기"
					playerArr[index].setScore(playerArr[index].getScore() + 10);
					labelArray[index].setText(playerArr[index].getName() + "\t" + playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 15;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 부엌으로
			case 5:
				if (move > 7) {
					buttonArray[location].setIcon(null);
					location = 35;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "?카드뽑기"
					playerArr[index].setScore(playerArr[index].getScore() + 10);
					labelArray[index].setText(playerArr[index].getName() + "\t" + playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 39;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 식당으로
			case 6:
				if (move > 4) {
					buttonArray[location].setIcon(null);
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "?카드뽑기"
					playerArr[index].setScore(playerArr[index].getScore() + 10);
					labelArray[index].setText(playerArr[index].getName() + "\t" + playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 2) {
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 거실로
			case 7:
				if (move > 5) {
					buttonArray[location].setIcon(null);
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "?카드뽑기"
					playerArr[index].setScore(playerArr[index].getScore() + 10);
					labelArray[index].setText(playerArr[index].getName() + "\t" + playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 119;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 마당으로
			case 8:
				if (move > 5) {
					buttonArray[location].setIcon(null);
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "?카드뽑기"
					playerArr[index].setScore(playerArr[index].getScore() + 10);
					labelArray[index].setText(playerArr[index].getName() + "\t" + playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 144;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 4) {
					buttonArray[location].setIcon(null);
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 차고로
			case 9:
				if (move > 7) {
					buttonArray[location].setIcon(null);
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "?카드뽑기"
					playerArr[index].setScore(playerArr[index].getScore() + 10);
					labelArray[index].setText(playerArr[index].getName() + "\t" + playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 120;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 6) {
					buttonArray[location].setIcon(null);
					location = 120;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			}
		}
		// 만약 위치가 침실이라면
		else if (location == 0 | location == 10 | location == 20 | location == 30 | location == 31 | location == 40
				| location == 41) {
			// 침실에서 갈수있는 방 5가지 랜덤수 구하기.
			int method6 = r.nextInt(6) + 1;
			switch (method6) {
			// 욕실로
			case 1:
				buttonArray[location].setIcon(null);
				if (move > 4) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 3;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					buttonArray[location].setIcon(null);
					location = 1;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				}
				break;
			// 서재로
			case 2:
				buttonArray[location].setIcon(null);
				if (move > 5) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 15;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 게임룽
			case 3:
				buttonArray[location].setIcon(null);
				if (move > 9) {
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 클루
			case 4:
				buttonArray[location].setIcon(null);
				if (move > 8) {
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 83;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else {

					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 식당
			case 5:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추측하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 거실로 텔레포트
			case 6:
				buttonArray[location].setIcon(null);

				location = 149;
				buttonArray[location].setIcon(
						new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
				// 추측하기
				playerArr[index].setLocation(location);
				new ComputerGuess(playerArr, index, buttonArray,labelArray);
				break;
			}
		}
		// 만약 위치가 욕실이라면
		else if (location == 1 | location == 2 | location == 3 | location == 4) {
			// 욕실에서 갈수있는 방 5가지 랜덤수 구하기.
			int method5 = r.nextInt(5) + 1;
			switch (method5) {
			// 침실로
			case 1:
				buttonArray[location].setIcon(null);
				if (move > 4) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 20;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					buttonArray[location].setIcon(null);
					location = 0;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				}
				break;
			// 서재로
			case 2:
				buttonArray[location].setIcon(null);
				if (move > 4) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 15;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					location = 15;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				}
				break;
			// 게임룽
			case 3:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// "추측하기"
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 클루
			case 4:
				buttonArray[location].setIcon(null);
				if (move > 8) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 75;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 식당
			case 5:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 75;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추측하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			}
		}
		// 만약 위치가 서재라면
		else if (location == 5 | location == 6 | location == 7 | location == 8 | location == 15 | location == 16
				| location == 17 | location == 18 | location == 25 | location == 26 | location == 27 | location == 28) {
			// 서재에서 갈수있는 방4가지 랜덤수 구하기.
			int method4 = r.nextInt(4) + 1;
			switch (method4) {
			// 욕실로
			case 1:
				buttonArray[location].setIcon(null);
				if (move > 4) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 3;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				}
				break;
			// 침실로
			case 2:
				buttonArray[location].setIcon(null);
				location = 23;
				buttonArray[location].setIcon(
						new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
				// ?카드뽑기
				playerArr[index].setScore(playerArr[index].getScore()+10);
	            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
				buttonArray[location].setIcon(null);
				location = 20;
				buttonArray[location].setIcon(
						new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
				// 추리하기
				playerArr[index].setLocation(location);
				new ComputerGuess(playerArr, index, buttonArray,labelArray);
				break;
			// 게임룸으로
			case 3:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 클루로
			case 4:
				buttonArray[location].setIcon(null);
				if (move > 9) {
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 75;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			}
		}
		// 만약 위치가 부엌이라면
		else if (location == 9 | location == 19 | location == 29 | location == 39 | location == 49) {
			// 부엌에서 갈수있는 방4가지 랜덤수 구하기.
			int method4 = r.nextInt(4) + 1;
			switch (method4) {
			// 클루로
			case 1:
				buttonArray[location].setIcon(null);
				location = 35;
				buttonArray[location].setIcon(
						new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
				// ?카드뽑기
				playerArr[index].setScore(playerArr[index].getScore()+10);
	            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
				buttonArray[location].setIcon(null);
				location = 75;
				buttonArray[location].setIcon(
						new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
				playerArr[index].setLocation(location);
				new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				break;
			// 식당
			case 2:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 6) {
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 게임룽
			case 3:
				if (move > 10) {
					buttonArray[location].setIcon(null);
					location = 35;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 차고로 텔포
			case 4:
				buttonArray[location].setIcon(null);
				location = 140;
				buttonArray[location].setIcon(
						new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
				// 추리하기
				playerArr[index].setLocation(location);
				new ComputerGuess(playerArr, index, buttonArray,labelArray);
				break;

			}

		}
		// 만약 위치가 식당이라면
		else if (location == 58 | location == 59 | location == 68 | location == 69 | location == 78 | location == 79
				| location == 88 | location == 89 | location == 98 | location == 99) {
			// 식당에서 갈수있는 방4가지 랜덤수 구하기.
			int method7 = r.nextInt(7) + 1;
			switch (method7) {
			// 부엌
			case 1:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 35;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					location = 39;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					location = 39;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				}
				break;
			// 클루
			case 2:
				buttonArray[location].setIcon(null);
				if (move > 4) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 86;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else if (move > 3) {
					location = 86;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 거실
			case 3:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 119;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 6) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 119;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 마당
			case 4:
				buttonArray[location].setIcon(null);
				if (move > 9) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 7) {
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 차고
			case 5:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 120;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 게임룸
			case 6:
				buttonArray[location].setIcon(null);
				if (move > 7) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 5) {
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 침실
			case 7:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 20;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			}
		}
		// 만약 위치가 거실이라면
		else if (location == 109 | location == 119 | location == 129 | location == 139 | location == 149) {
			// 거실에서 갈수있는 방6가지 랜덤수 구하기.
			int method6 = r.nextInt(6) + 1;
			switch (method6) {
			// 식당으로
			case 1:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 6) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 클루로
			case 2:
				buttonArray[location].setIcon(null);
				if (move > 9) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 86;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else if (move > 5) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 86;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 마당으로
			case 3:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 6) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 차고로
			case 4:
				buttonArray[location].setIcon(null);
				if (move > 9) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 120;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 게임룸으로
			case 5:
				buttonArray[location].setIcon(null);
				if (move > 8) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 침실로 텔포
			case 6:
				buttonArray[location].setIcon(null);
				location = 20;
				buttonArray[location].setIcon(
						new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
				// 추리하기
				playerArr[index].setLocation(location);
				new ComputerGuess(playerArr, index, buttonArray,labelArray);
				break;
			}
		}
		// 만약 위치가 마당이라면
		else if (location == 131 | location == 132 | location == 141 | location == 142 | location == 143
				| location == 144 | location == 145 | location == 146 | location == 147 | location == 148
				| location == 137 | location == 138) {
			// 거실에서 갈수있는 방5가지 랜덤수 구하기.
			int method5 = r.nextInt(5) + 1;
			switch (method5) {
			// 클루로
			case 1:
				buttonArray[location].setIcon(null);
				if (move > 8) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 95;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else if (move > 6) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 95;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else if (move > 4) {
					location = 95;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else {
					Move(playerArr, index, move + 2, buttonArray, labelArray);
				}
				break;
			// 게임룸으로
			case 2:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 9) {
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 7) {
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 차고로
			case 3:
				buttonArray[location].setIcon(null);
				if (move > 9) {
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 120;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 5) {
					location = 120;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 거실로
			case 4:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 119;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 6) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 119;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 식당으로
			case 5:
				buttonArray[location].setIcon(null);
				if (move > 9) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 7) {
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			}
		}
		// 만약 위치가 차고라면
		else if (location == 110 | location == 120 | location == 130 | location == 140) {
			// 차고에서 갈수있는 방6가지 랜덤수 구하기.
			int method6 = r.nextInt(6) + 1;
			switch (method6) {
			// 클루로
			case 1:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 95;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);

				} else if (move > 9) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 95;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else if (move > 6) {
					location = 93;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 마당으로
			case 2:
				buttonArray[location].setIcon(null);
				if (move > 8) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 5) {
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 게임룸으로
			case 3:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 5) {
					location = 80;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 거실로
			case 4:
				buttonArray[location].setIcon(null);
				if (move > 9) {
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 119;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 식당으로
			case 5:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 9) {
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 부엌으로 텔포
			case 6:
				buttonArray[location].setIcon(null);
				location = 39;
				buttonArray[location].setIcon(
						new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
				// 추리하기
				playerArr[index].setLocation(location);
				new ComputerGuess(playerArr, index, buttonArray,labelArray);
				break;
			}

		}
		// 만약 위치가 게임룸이라면
		else if (location == 50 | location == 60 | location == 70 | location == 80 | location == 90 | location == 100) {
			// 차고에서 갈수있는 방9가지 랜덤수 구하기.
			int method9 = r.nextInt(9) + 1;
			switch (method9) {
			// 쿨루로
			case 1:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 86;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else if (move > 7) {
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 95;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				} else {
					location = 83;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					playerArr[index].setLocation(location);
					new TurnDialog(playerArr, index + 1, buttonArray, labelArray);
				}
				break;
			// 침실로
			case 2:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 20;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 9) {
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 20;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 욕실로
			case 3:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 3;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 서재로
			case 4:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 52;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 23;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 15;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 부엌
			case 5:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 39;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 식당
			case 6:
				buttonArray[location].setIcon(null);
				if (move > 7) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 5) {
					location = 78;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 거실
			case 7:
				buttonArray[location].setIcon(null);
				if (move > 8) {
					location = 97;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 129;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 마당
			case 8:
				buttonArray[location].setIcon(null);
				if (move > 11) {
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 126;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 9) {
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 7) {
					location = 145;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index, move, buttonArray, labelArray);
				}
				break;
			// 차고
			case 9:
				buttonArray[location].setIcon(null);
				if (move > 10) {
					location = 104;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// ?카드뽑기
					playerArr[index].setScore(playerArr[index].getScore()+10);
		            labelArray[index].setText(playerArr[index].getName()+playerArr[index].getScore());
					buttonArray[location].setIcon(null);
					location = 120;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else if (move > 5) {
					location = 120;
					buttonArray[location].setIcon(new ImageIcon(
							new ImageIcon(image).getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
					// 추리하기
					
					playerArr[index].setLocation(location);
					new ComputerGuess(playerArr, index, buttonArray,labelArray);
				} else {
					Move(playerArr, index + 1, move, buttonArray, labelArray);
				}
				break;
			}

		}

	}// 메소드 종료
}