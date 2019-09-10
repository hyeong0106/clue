package clue.model.vo.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clue.controller.StartDialog;
import clue.model.vo.GuessCheck;
import clue.model.vo.Help;
import clue.model.vo.Note;
import clue.model.vo.Player;

public class GameFrame extends JFrame {
	private JLabel backGroundImg;
	private static JButton[] buttonArray;
	private JLabel dice1Img;
	private JLabel dice2Img;
	private JButton noteBtn;
	private JLabel noteImg;
	private JPanel area;
	private JLabel token1;
	private static Player[] player = new Player[6];
	private int now;// 지금 플레이중
	private int check;
	private JPanel panel;
	private JLabel orderLable;
	private JLabel orderLable2;
	private static Player[] playerArr;
	private JButton diceBtn;
	private int index;
	private static JLabel resultLabel;
	private static JLabel[] labelArray = new JLabel[6];
	private String murderCards;
	private StartDialog start; 
	public GameFrame() {

	}

	public GameFrame(Player[] player, String murderCards) {
		// 플레이어 배열 이어받기
		this.player = player;
		this.murderCards = murderCards;
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setBounds(d.width / 2 - 512, d.height / 2 - 384, 1024, 768);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBounds(0, 0, 1024, 768);
		panel.setLayout(null);

		// 구역 설정
		createButton();

		// 스코어 설정
		scoreCheck();
		// 노트 설정
		noteButton();
		// 토큰 설정
		token();
		// 순서 설정
		order();
		// 정답 체크 추가
		guessCheck();
		// 설명추가
		help();
		// 배경 설정
		background();
		// 게임 시작
		gameStart();

		add(panel);
		setResizable(false);
		setVisible(true);

	}

	// 배경설정
	public void background() {
		backGroundImg = new JLabel(new ImageIcon(
				new ImageIcon("images\\Map.jpg").getImage().getScaledInstance(800, 768, Image.SCALE_DEFAULT)));
		backGroundImg.setBounds(0, 0, 800, 768);
		panel.add(backGroundImg);
		JLabel areaLabel = new JLabel(new ImageIcon(
				new ImageIcon("images\\meue.jpg").getImage().getScaledInstance(800, 768, Image.SCALE_DEFAULT)));
		areaLabel.setBounds(800, 0, 224, 768);
		panel.add(areaLabel);
	}

	// score설정
	public void scoreCheck() {

		JLabel scoreLabel = new JLabel(new ImageIcon(
				new ImageIcon("images/Score.png").getImage().getScaledInstance(140, 45, Image.SCALE_DEFAULT)));
		scoreLabel.setBounds(840, 90, 140, 45);
		scoreLabel.setFont(new Font("Serif", Font.BOLD, 20));
		panel.add(scoreLabel);
		for (int i = 0; i < 6; i++) {
			labelArray[i] = new JLabel();
			labelArray[i].setBounds(880, 150 + (i * 50), 230, 30);
			labelArray[i].setText("0");
			labelArray[i].setForeground(Color.WHITE);
			panel.add(labelArray[i]);
		}

	}

	// 구역 설정
	public void createButton() {
		area = new JPanel();
		area.setOpaque(false);
		area.setBounds(215, 110, 375, 545);
		area.setLayout(new GridLayout(15, 10));

		buttonArray = new JButton[150];
		for (int i = 0; i < 150; i++) {
			buttonArray[i] = new JButton();
			buttonArray[i].setText(Integer.toString(i));
			buttonArray[i].setFont(new Font("a", Font.ITALIC, 1));
			// 투명하게 설정
			buttonArray[i].setOpaque(false);
			// 내용역역 채우지 않게 하기
			buttonArray[i].setContentAreaFilled(false);
			// 외각선 삭제
			buttonArray[i].setBorderPainted(false);
			area.add(buttonArray[i]);
			panel.add(area);
		}
	}

	// 노트 설정
	public void noteButton() {
		// 추리노트 버튼 생성
		noteBtn = new JButton("추리 노트");
		noteBtn.setBounds(850, 680, 120, 30);
		// 추리노트 이미지 생성
		noteImg = new JLabel();
		noteImg = new JLabel(new ImageIcon(
				new ImageIcon("images\\고서.jpg").getImage().getScaledInstance(60, 80, Image.SCALE_DEFAULT)));
		noteImg.setBounds(845, 570, 130, 120);
		panel.add(noteImg);
		panel.add(noteBtn);
		// 버튼 이벤트
		noteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Note();
			}
		});
	}

	// 토큰 설정
	public void token() {
		buttonArray[73].setIcon(new ImageIcon(
				new ImageIcon("images\\그린.jpg").getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
		buttonArray[74].setIcon(new ImageIcon(
				new ImageIcon("images\\머스타드.jpg").getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
		buttonArray[75].setIcon(new ImageIcon(
				new ImageIcon("images\\스칼렛.jpg").getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
		buttonArray[76].setIcon(new ImageIcon(
				new ImageIcon("images\\플럼.jpg").getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
		buttonArray[83].setIcon(new ImageIcon(
				new ImageIcon("images\\피콕.jpg").getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
		buttonArray[84].setIcon(new ImageIcon(
				new ImageIcon("images\\화이트.jpg").getImage().getScaledInstance(55, 35, Image.SCALE_DEFAULT)));
	}

	// 도움말
	public void help() {
		JLabel helpImg = new JLabel(new ImageIcon(
				new ImageIcon("images\\물음표.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
		helpImg.setBounds(875, 455, 70, 70);

		JButton helpButton = new JButton("게임 방법");
		helpButton.setBounds(850, 540, 120, 30);
		helpButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Help();
			}
		});
		panel.add(helpButton);
		panel.add(helpImg);
	}

	// 순서 설정
	public void order() {
		// 순서정리된 새로운 player배열 생성

		playerArr = new Player[player.length];
		for (int i = 0; i < player.length; i++) {
			switch (player[i].getStartPlayer()) {
			case 0:
				playerArr[0] = player[i];
				break;
			case 1:
				playerArr[1] = player[i];
				break;
			case 2:
				playerArr[2] = player[i];
				break;
			case 3:
				playerArr[3] = player[i];
				break;
			case 4:
				playerArr[4] = player[i];
				break;
			case 5:
				playerArr[5] = player[i];
				break;
			}
		}

		// 말의 현재위치 지정
		for (int i = 0; i < playerArr.length; i++) {
			if (playerArr[i].getCharacter() == "그린") {
				playerArr[i].setLocation(73);

			} else if (playerArr[i].getCharacter() == "머스타드") {
				playerArr[i].setLocation(74);

			} else if (playerArr[i].getCharacter() == "스칼렛") {
				playerArr[i].setLocation(75);

			} else if (playerArr[i].getCharacter() == "플럼") {
				playerArr[i].setLocation(76);

			} else if (playerArr[i].getCharacter() == "피콕") {
				playerArr[i].setLocation(83);

			} else if (playerArr[i].getCharacter() == "화이트") {
				playerArr[i].setLocation(84);

			}
		}
		// 순서 라벨 만들기
		orderLable = new JLabel(
				playerArr[0].getCharacter() + "->" + playerArr[1].getCharacter() + "->" + playerArr[2].getCharacter());
		orderLable.setFont(new Font("순서", Font.BOLD, 10));
		orderLable.setBounds(845, 40, 250, 30);
		orderLable.setForeground(Color.WHITE);
		orderLable2 = new JLabel("\n->" + playerArr[3].getCharacter() + "->" + playerArr[4].getCharacter() + "->"
				+ playerArr[5].getCharacter());
		orderLable2.setFont(new Font("순서", Font.BOLD, 10));
		orderLable2.setBounds(840, 55, 250, 30);
		orderLable2.setForeground(Color.WHITE);
		panel.add(orderLable);
		panel.add(orderLable2);
	}

	// 게임시작
	public void gameStart() {
		start = new StartDialog(playerArr);
		start.getDialogBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.dispose();
				new GameStart(playerArr, index, buttonArray, labelArray);
			}
		});
	}

	// 정답확인
	public void guessCheck() {
		JButton guess = new JButton("정답 확인");
		guess.setBounds(850, 10, 120, 30);
		guess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GuessCheck guess = new GuessCheck(playerArr, murderCards);
				
				guess.getJb().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String check;
						check = guess.getPlace() + "에서 " + guess.getPerson()+ "이(가) " +guess.getThing() + "(으)로 살인을 함";
						
						if (!guess.getPerson().equals("???") && !guess.getThing().equals("???")) {
							if (check.equals(murderCards)) {
								dispose();
								start.dispose();
							}
						} 
					}
				});
			}
		});
		panel.add(guess);
	}
}
