package com.notivan;

import java.awt.*;                  // for the robot class
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JOptionPane;     // for the dialog boxes

/**
 * Automates the keyboard and mouse movements required to get
 * Microsoft reward points for using the Microsoft Edge browser
 */
public class BrowserRewards {
    private static Robot robot;
    private final static int MOUSE_DELAY = 100;    // delay after the mouse movement
    private final static int LOADING_DELAY = 1000;   // delay after an action

    /**
     * Adds a fraction of a second between key press and key release
     * @param key the keyboard key
     */
    private static void keystroke(int key) {
        robot.keyPress(key);
        robot.delay(100); // hold for a tenth of a second
        robot.keyRelease(key);
    }

    /**
     * Adds a fraction of a second between mouse press and mouse release
     * @param key the mouse button
     */
    private static void mouseClick(int key) {
        robot.mousePress(key);
        robot.delay(100); // hold for a tenth of a second
        robot.mouseRelease(key);
    }

    /**
     * Sets a string of text to the clipboard
     * @param text phrase or words to be pasted
     */
    private static void setClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
    }

    /**
     * Pastes and enters whatever is on the clipboard
     */
    private static void pasteEnter() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        keystroke(KeyEvent.VK_ENTER);
        robot.delay(LOADING_DELAY);
    }

    /**
     * Closes a tab with the keystrokes CTRL + W
     */
    private static void closeTab() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(LOADING_DELAY);
    }

    /**
     * Opens a tab with the keystrokes CTRL + T
     */
    private static void newTab() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(LOADING_DELAY);
    }

    /**
     * Maximizes whatever window is in focus
     */
    private static void maximizeWindow() {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.delay(100);
        keystroke(KeyEvent.VK_X);
        robot.delay(LOADING_DELAY);
    }

    /**
     * Automates the mouse movements needed to click the search bar
     */
    private static void clickSearchBar() {
        robot.mouseMove(675,140);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100);
    }

    /**
     * Goes to microsoft rewards page
     */
    private static void goToRewardsPage() {
        robot.delay(4000);
        setClipboard("https://rewards.microsoft.com/");
        maximizeWindow();
        newTab();
        pasteEnter();
        robot.delay(2150);
    }

    /**
     * Enters the text given in the parameter
     */
    private static void enterText(String text) {
        setClipboard(text);
        pasteEnter();
    }

    /**
     * Opens the Microsoft Edge browser through the rewards page
     */
    private static void goToMicrosoftEdge() {
        // click points breakdown
        robot.mouseMove(1550,295);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);

        // opens Microsoft Edge when the browser just opened
        robot.mouseMove(1150,375);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100);

        // opens Microsoft Edge when the browser is already open
        robot.mouseMove(1150,440);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(1050,230);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
    }

    /**
     * Automates the mouse movements needed to get the Microsoft rewards
     */
    private static void clickResultTabs() {
        // live
        robot.mouseMove(1090,260);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100);

        // in case there are ads right away
        robot.mouseMove(1090,590);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(LOADING_DELAY);

        // cheats
        robot.mouseMove(1030,260);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(LOADING_DELAY);

        // tips & strategies
        robot.mouseMove(930,260);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100);

        // in case there are ads after cheats tab
        robot.mouseMove(930,590);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(LOADING_DELAY);

        // guides
        robot.mouseMove(800,260);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(LOADING_DELAY);

        // trailers
        robot.mouseMove(720,260);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(LOADING_DELAY);

        // reviews
        robot.mouseMove(630,260);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(LOADING_DELAY);

        // buy
        robot.mouseMove(550,260);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(LOADING_DELAY);

        // gameplay
        robot.mouseMove(460,260);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(LOADING_DELAY);
    }

    public static void main(String[] args) throws AWTException, IOException {

        robot = new Robot();

        // opens brave browser
        Runtime.getRuntime().exec("cmd /c start brave");

        goToRewardsPage();

        goToMicrosoftEdge();

        clickSearchBar();

        enterText("flappy bird");
        // click all from search tab
        robot.mouseMove(200,190);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(LOADING_DELAY);
        clickResultTabs();

        clickSearchBar();
        enterText("diablo 3");
        clickResultTabs();

        clickSearchBar();
        enterText("diablo immortal");
        clickResultTabs();

        clickSearchBar();
        enterText("shovel knight");
        clickResultTabs();

        // close Microsoft Edge tab which closes the browser
        closeTab();

        // close Microsoft Edge tab on brave
        closeTab();

        // opens volume mixer
        robot.mouseMove(1795,1050);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(100);
        robot.mouseMove(1795,925);
        robot.delay(MOUSE_DELAY);
        mouseClick(InputEvent.BUTTON1_DOWN_MASK);

        JOptionPane.showMessageDialog(null, "Microsoft Rewards are done!");

        System.exit(0);
    }
}
