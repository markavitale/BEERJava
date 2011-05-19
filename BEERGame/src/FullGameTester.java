import static org.junit.Assert.assertEquals;

import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JFrame;

import org.junit.BeforeClass;
import org.junit.Test;

public class FullGameTester {
	private static Launcher l;
	private String t;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		l = new Launcher();
		l.setGame(l.readGame());
		l.getGame().setLanguage("english");
		GameBar gameBar = new GameBar(l);
		l.setGameBar(gameBar);
		System.out.println("here");
		SidePanel sidePanel = new SidePanel(l);
		l.setGamePanel(new GamePanel(l, sidePanel));
		JFrame frame = new JFrame();
		frame.setTitle("Tyler's Game");
		frame.setJMenuBar(gameBar);
		frame.setLayout(new FlowLayout());

		frame.add(sidePanel);
		
		frame.pack();
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setFrame(frame);
	}

	@Test
	public void checkFirstView() {
		assertEquals("Welcome to the game", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkInventoryEmpty() {
		assertEquals(0, l.getGame().getCurrentPlayer().getInventory().size());
	}

	@Test
	public void checkFirstViewNoChange() {
		l.getGamePanel().checkRegion(800, 800);
		assertEquals("Welcome to the game", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkFirstViewChangeToSecond() {
		l.getGamePanel().checkRegion(500, 500);
		assertEquals("A bank robber has a gun in front of you", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkSecondViewNoChange() {
		l.getGamePanel().checkRegion(500, 500);
		assertEquals("A bank robber has a gun in front of you", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkSecondViewChangeToThird() {
		l.getGamePanel().checkRegion(32, 495);
		assertEquals("You took the taser", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkSecondViewAddToInventory() {
		assertEquals("taser", l.getGame().getCurrentPlayer().getInventory()
				.get(0).getName());
	}

	@Test
	public void checkThirdViewNoChange() {
		l.getGamePanel().checkRegion(32, 495);
		assertEquals("You took the taser", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkThirdViewChangeToFourth() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(0));
		l.getGamePanel().checkRegion(435, 111);
		assertEquals("You knocked the robber unconscious", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFourthViewNoChange() {
		l.getGamePanel().checkRegion(435, 111);
		assertEquals("You knocked the robber unconscious", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFourthViewChangeToFifth() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("You took the keys from the security guard", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFourthViewAddToInventory() {
		assertEquals("keys",
				l.getGame().getCurrentPlayer().getInventory().get(1).getName());
	}

	@Test
	public void checkFifthViewNoChange() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("You took the keys from the security guard", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFifthViewChangeToSixth() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(1));
		l.getGamePanel().checkRegion(378, 177);
		assertEquals("There are matches in the deposit box", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkSixthViewNoChange() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("There are matches in the deposit box", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkSixthViewChangetoSeventh() {
		l.getGamePanel().checkRegion(378, 172);
		assertEquals("You took the matches", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkSixthViewAddToInventory() {
		assertEquals("matches", l.getGame().getCurrentPlayer().getInventory()
				.get(2).getName());
	}

	@Test
	public void checkSeventhViewNoChange() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("You took the matches", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkSeventhViewChangetoEighth() {
		l.getGamePanel().checkRegion(700, 0);
		assertEquals("Bank employees are stuck in the vault with you!", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkEighthViewNoChange() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("Bank employees are stuck in the vault with you!", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());

	}

	@Test
	public void checkEighthViewChangetoNineth() {
		l.getGamePanel().checkRegion(700, 0);
		assertEquals("A room full of safety deposit boxes", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkNinethViewNoChange() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("A room full of safety deposit boxes", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());

	}

	@Test
	public void checkNinethFrench() {
		l.getGameBar().getFrench().doClick();
		assertEquals("Une salle plein des boîtes de sécurité", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkNinethChangetoTenth() {
		l.getGameBar().getEnglish().doClick();
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(1));
		l.getGamePanel().checkRegion(515, 169);
		assertEquals("There is a string in the deposit box", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());

	}

	@Test
	public void checkTenthNoChange() {

		l.getGamePanel().checkRegion(700, 700);
		assertEquals("There is a string in the deposit box", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());

	}

	@Test
	public void checkTenthChangeToEleventh() {

		l.getGamePanel().checkRegion(526, 186);
		assertEquals("You took the string", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());

	}

	@Test
	public void checkTenthViewAddToInventory() {
		assertEquals("string", l.getGame().getCurrentPlayer().getInventory()
				.get(3).getName());
	}

	@Test
	public void checkEleventhNoChange() {
		l.getGamePanel().checkRegion(526, 186);
		assertEquals("You took the string", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkEleventhChangeToTwelth() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(1));
		l.getGamePanel().checkRegion(190, 90);
		assertEquals("There is dynamite in the deposit box", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkTwelthNoChange() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("There is dynamite in the deposit box", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkTwelthChangeToThirteenth() {
		l.getGamePanel().checkRegion(221, 101);
		assertEquals("You took the dynamite", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkTwelthViewAddToInventory() {
		assertEquals("dynamite", l.getGame().getCurrentPlayer().getInventory()
				.get(4).getName());
	}

	@Test
	public void checkThirteenthNoChange() {
		l.getGamePanel().checkRegion(500, 100);
		assertEquals("You took the dynamite", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkThirteenthChangeToFourteenth() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("You see a closed vault door and trapped employees", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}
	
	@Test
	public void checkItemDescription1() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(0));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("This taser can be used on bad guys",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}
	
	@Test
	public void checkItemDescription2() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(1));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("These keys unlock safety deposit boxes",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}
	
	@Test
	public void checkItemDescription3() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(2));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("These matches can light things on fire",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}
	
	@Test
	public void checkItemDescription4() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(3));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("This string could possibly be used as a wick...",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}
	
	@Test
	public void checkItemDescription5() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(4));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("The dynamite is missing a wick",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}

	@Test
	public void combineDynamiteWithStringFalse() {
		assertEquals(5, l.getGame().getCurrentPlayer().getInventory().size());
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(2));
		l.getGamePanel().getSidePanel().getInvPanel().checkCombineItem();
		l.getGamePanel().getSidePanel().getInvPanel()
				.checkCombineClick(new Point(15, 300));
		assertEquals(5, l.getGame().getCurrentPlayer().getInventory().size());

	}

	@Test
	public void combineDynamiteWithStringTrue() {
		assertEquals(5, l.getGame().getCurrentPlayer().getInventory().size());
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(3));
		l.getGamePanel().getSidePanel().getCombine().doClick();
		l.getGamePanel().getSidePanel().getInvPanel()
				.checkCombineClick(new Point(15, 300));
		assertEquals(4, l.getGame().getCurrentPlayer().getInventory().size());

	}

	@Test
	public void checkFourteenthNoChange() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("You see a closed vault door and trapped employees", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFourteenthChangeToFifteenth() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(3));
		l.getGamePanel().checkRegion(114, 294);
		assertEquals("You place the dynamite on the ground", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFifteenthNoChange() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("You place the dynamite on the ground", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFifteenthChangeToSixteenth() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(2));
		l.getGamePanel().checkRegion(114, 294);
		assertEquals("The dynamite is lit, back away!", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	// @Test
	// public void checkSixteenthChangeToSeventeenth() {
	// l.getGamePanel().setWaitTime(0);
	// l.getGamePanel().checkForWaitView();
	// l.getGamePanel().getWaitView().run();
	//
	// assertEquals("kaboom!",
	// l.getGamePanel().getSidePanel().getTopTextArea().getText()
	// );
	// }
	//

	@Test
	public void checkSixteenthChangeToSeventeenth() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("kaboom!", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	// @Test
	// public void checkSeventeenthChangeToEighteenth() {
	// l.getGamePanel().setWaitTime(0);
	// l.getGamePanel().checkForWaitView();
	// l.getGamePanel().getWaitView().run();
	// assertEquals("You win",
	// l.getGamePanel().getSidePanel().getTopTextArea().getText()
	// );
	// }
	//
	@Test
	public void checkSeventeenthChangeToEighteenth() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("You win", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	// FRENCH TIME BABY!!

	@Test
	public void checkNewGameInitialView() {
		l.getGameBar().getNewGame().doClick();
		l.getGameBar().getFrench().doClick();
		assertEquals("Bienvenue dans le jeu", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}
	
	@Test
	public void checkInventoryEmptyNewGame() {
		assertEquals(0, l.getGame().getCurrentPlayer().getInventory().size());
	}

	@Test
	public void checkFirstViewNoChangeFrench() {
		l.getGamePanel().checkRegion(800, 800);
		assertEquals("Bienvenue dans le jeu", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkFirstViewChangeToSecondFrench() {
		l.getGamePanel().checkRegion(500, 500);
		assertEquals("Un braqueur de banque a une pistol en face de vous", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkSecondViewNoChangeFrench() {
		l.getGamePanel().checkRegion(500, 500);
		assertEquals("Un braqueur de banque a une pistol en face de vous", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkSecondViewChangeToThirdFrench() {
		l.getGamePanel().checkRegion(32, 495);
		assertEquals("Vous avez pris le pistolet à impulsion électrique", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkSecondViewAddToInventoryNew() {
		assertEquals("taser", l.getGame().getCurrentPlayer().getInventory()
				.get(0).getName());
	}

	@Test
	public void checkThirdViewNoChangeFrench() {
		l.getGamePanel().checkRegion(32, 495);
		assertEquals("Vous avez pris le pistolet à impulsion électrique", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkThirdViewChangeToFourthFrench() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(0));
		l.getGamePanel().checkRegion(435, 111);
		assertEquals("Vous avez frappé le voleur inconscient", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFourthViewNoChangeFrench() {
		l.getGamePanel().checkRegion(435, 111);
		assertEquals("Vous avez frappé le voleur inconscient", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFourthViewChangeToFifthFrench() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("Vous avez pris les clefs du gardien de sécurité", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFourthViewAddToInventoryNew() {
		assertEquals("keys",
				l.getGame().getCurrentPlayer().getInventory().get(1).getName());
	}

	@Test
	public void checkFifthViewNoChangeFrench() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("Vous avez pris les clefs du gardien de sécurité", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFifthViewChangeToSixthFrench() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(1));
		l.getGamePanel().checkRegion(378, 177);
		assertEquals("Il y a des matchs dans la boîte", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkSixthViewNoChangeFrench() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("Il y a des matchs dans la boîte", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkSixthViewChangetoSeventhFrench() {
		l.getGamePanel().checkRegion(378, 172);
		assertEquals("Vous avez pris les matchs", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkSixthViewAddToInventoryNew() {
		assertEquals("matches", l.getGame().getCurrentPlayer().getInventory()
				.get(2).getName());
	}

	@Test
	public void checkSeventhViewNoChangeFrench() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("Vous avez pris les matchs", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkSeventhViewChangetoEighthFrench() {
		l.getGamePanel().checkRegion(700, 0);
		assertEquals("Employés de la Banque sont coincés dans la voûte avec vous!", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkEighthViewNoChangeFrench() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("Employés de la Banque sont coincés dans la voûte avec vous!", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());

	}

	@Test
	public void checkEighthViewChangetoNinethFrench() {
		l.getGamePanel().checkRegion(700, 0);
		assertEquals("Une salle plein des boîtes de sécurité", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkNinethViewNoChangeFrench() {
		l.getGamePanel().checkRegion(520, 520);
		assertEquals("Une salle plein des boîtes de sécurité", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());

	}

	@Test
	public void checkNinethEnglish() {
		l.getGameBar().getEnglish().doClick();
		assertEquals("A room full of safety deposit boxes", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkNinethChangetoTenthFrench() {
		l.getGameBar().getFrench().doClick();
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(1));
		l.getGamePanel().checkRegion(515, 169);
		assertEquals("Il y a une corde dans la boîte", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());

	}

	@Test
	public void checkTenthNoChangeFrench() {

		l.getGamePanel().checkRegion(700, 700);
		assertEquals("Il y a une corde dans la boîte", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());

	}

	@Test
	public void checkTenthChangeToEleventhFrench() {

		l.getGamePanel().checkRegion(526, 186);
		assertEquals("Vous avez pris la corde", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());

	}

	@Test
	public void checkTenthViewAddToInventoryNew() {
		assertEquals("string", l.getGame().getCurrentPlayer().getInventory()
				.get(3).getName());
	}

	@Test
	public void checkEleventhNoChangeFrench() {
		l.getGamePanel().checkRegion(526, 186);
		assertEquals("Vous avez pris la corde", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkEleventhChangeToTwelthFrench() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(1));
		l.getGamePanel().checkRegion(190, 90);
		assertEquals("Il y a de la dynamite dans la boîte", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkTwelthNoChangeFrench() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("Il y a de la dynamite dans la boîte", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkTwelthChangeToThirteenthFrench() {
		l.getGamePanel().checkRegion(221, 101);
		assertEquals("Vous avez pris la dynamite", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkTwelthViewAddToInventoryNew() {
		assertEquals("dynamite", l.getGame().getCurrentPlayer().getInventory()
				.get(4).getName());
	}

	@Test
	public void checkThirteenthNoChangeFrench() {
		l.getGamePanel().checkRegion(500, 100);
		assertEquals("Vous avez pris la dynamite", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkThirteenthChangeToFourteenthFrench() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("Vous voyez une porte fermée  et les employés attraper", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}
	
	@Test
	public void checkItemDescription1French() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(0));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("Ce pistolet à impulsion électrique peut être utilisé sur les méchants",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}
	
	@Test
	public void checkItemDescription2French() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(1));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("Ces clefs déverrouiller boîtes de sécurité",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}
	
	@Test
	public void checkItemDescription3French() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(2));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("Ces matchs peuvent allumer des choses",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}
	
	@Test
	public void checkItemDescription4French() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(3));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("Cette corde peut éventuellement être utilisé comme unemèche...",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}
	
	@Test
	public void checkItemDescription5French() {
		l.getGamePanel()
		.getSidePanel()
		.getInvPanel()
		.setSelected(
				l.getGame().getCurrentPlayer().getInventory().get(4));
		l.getGamePanel().getSidePanel().updateText();
		assertEquals("La dynamite est manquant une mèche",l.getGamePanel().getSidePanel().getBottomTextArea().getText());
	}



	@Test
	public void checkFourteenthNoChangeFrench() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("Vous voyez une porte fermée  et les employés attraper", l
				.getGamePanel().getSidePanel().getTopTextArea().getText());
	}
	@Test
	public void combineDynamiteWithStringTrueNew() {
		assertEquals(5, l.getGame().getCurrentPlayer().getInventory().size());
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(3));
		l.getGamePanel().getSidePanel().getCombine().doClick();
		l.getGamePanel().getSidePanel().getInvPanel()
				.checkCombineClick(new Point(15, 300));
		assertEquals(4, l.getGame().getCurrentPlayer().getInventory().size());

	}
	@Test
	public void checkFourteenthChangeToFifteenthFrench() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(3));
		l.getGamePanel().checkRegion(120, 294);
		assertEquals("Vous mettez la dynamite sur le terrain", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFifteenthNoChangeFrench() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("Vous mettez la dynamite sur le terrain", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkFifteenthChangeToSixteenthFrench() {
		l.getGamePanel()
				.getSidePanel()
				.getInvPanel()
				.setSelected(
						l.getGame().getCurrentPlayer().getInventory().get(2));
		l.getGamePanel().checkRegion(114, 294);
		assertEquals("Vous avez allumé la dynamite, reculez!", l.getGamePanel()
				.getSidePanel().getTopTextArea().getText());
	}

	@Test
	public void checkSixteenthChangeToSeventeenthFrench() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("Bang!", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}

	@Test
	public void checkSeventeenthChangeToEighteenthFrench() {
		l.getGamePanel().checkRegion(100, 100);
		assertEquals("Vous avez gagner!", l.getGamePanel().getSidePanel()
				.getTopTextArea().getText());
	}
}
