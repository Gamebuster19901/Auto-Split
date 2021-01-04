package com.gamebuster19901.autosplit;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.gamebuster19901.autosplit.input.SpecialKey;
import com.gamebuster19901.autosplit.swing.DynamicallySized;
import com.gamebuster19901.autosplit.swing.FontSettings;
import com.gamebuster19901.autosplit.swing.GButton;
import com.gamebuster19901.autosplit.swing.GCheckBox;
import com.gamebuster19901.autosplit.swing.GImagePanel;
import com.gamebuster19901.autosplit.swing.GLabel;
import com.gamebuster19901.autosplit.swing.GTextField;

import static javax.swing.JFrame.DISPOSE_ON_CLOSE;

public class Main {

	public static final Main INSTANCE;
	static {
		try {
			INSTANCE = new Main();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			throw new Error(e);
		}
	}
	
	private final FontSettings fontSettings = new FontSettings();
	
	final JPanel centralWidget;
	final GLabel splitImageFolderLabel;
	final GTextField splitImageFolderLineEdit;
	final GButton browseButton;
	final GLabel xLabel;
	final GLabel yLabel;
	final GCheckBox liveImageCheckBox;
	final GCheckBox loopCheckBox;
	final GCheckBox autoRestartOnResetCheckBox;
	final GButton selectRegionButton;
	final GButton alignRegionButton;
	final GButton selectWindowButton;
	final GLabel similarityThresholdLabel;
	final JSpinner similarityThresholdDoubleSpinBox;
	final GButton startAutoSplitterButton;
	final GButton resetButton;
	final GButton undoSplitButton;
	final GButton skipSplitButton;
	final GButton maxFPSButton;
	final GLabel fpsLabel;
	final GCheckBox showLiveSimilarityCheckBox;
	final GCheckBox showHighestSimilarityCheckBox;
	final GLabel liveSimilarityLabel;
	final GLabel highestSimilarityLabel;
	final GLabel splitLabel;
	final GLabel resetLabel;
	final GLabel skipSplitLabel;
	final GLabel undoSplitLabel;
	final GLabel pauseLabel;
	final GLabel pauseTimeAfterSplitLabel;
	final GTextField splitLineEdit;
	final GTextField undoSplitLineEdit;
	final GTextField skipSplitLineEdit;
	final GTextField resetLineEdit;
	final GTextField pauseHotKeyLineEdit;
	final GButton setSplitHotKeyButton;
	final GButton setResetHotKeyButton;
	final GButton setSkipSplitHotKeyButton;
	final GButton setUndoSplitHotKeyButton;
	final GButton setPauseHotKeyButton;
	final GLabel timerGlobalHotKeysLabel;
	final GImagePanel liveImage;
	final GImagePanel currentSplitImage;
	final GLabel imageLoopLabel;
	final GLabel widthLabel;
	final GLabel heightLabel;
	//final GLabel fpsValueLabel;
	final JSpinner widthSpinBox;
	final JSpinner heightSpinBox;
	final GLabel captureRegionLabel;
	final GLabel currentSplitImageLabel;
	final GLabel fpsLimitLabel;
	final JSpinner fpsLimitSpinBox;
	final GLabel currentSplitImageFileLabel;
	final GButton takeScreenshotButton;
	final JSpinner xSpinBox;
	final JSpinner ySpinBox;
	final JComboBox<Comparison> comparisonMethodComboBox;
	final JSpinner pauseDoubleSpinBox;
	final GCheckBox customThresholdCheckBox;
	final GCheckBox customPauseTimeCheckBox;
	final GLabel comparisonMethodLabel;
	final GCheckBox groupDummySplitsCheckBox;
	
	public static void main(String[] args) {}
	
	public Main() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		JFrame frame = new JFrame();
		
		int column1 = 5;
		
		int row3column2 = 250;
		int row3column3 = 490;
		int row3column2padding = 10;
		
		/*
		 * 
		 * Main Window
		 * 
		 */
		
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		frame.setName("mainWindow");
		frame.setTitle("Auto Split (Java)");
		
		try {
			frame.setIconImage(new ImageIcon(Main.class.getResource("/icon.png")).getImage());
		}
		catch(Exception e) {
			System.out.println("Could not retrieve window icon.");
			e.printStackTrace();
		}
		
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		/*
		 * 
		 * Central Widget
		 * 
		 */
		
		centralWidget = new JPanel();
		centralWidget.setName("centralWidget");
		centralWidget.setLayout(null);
		
		frame.add(centralWidget);
		
		/*
		 * 
		 * Split Image Folder Label
		 * 
		 */
		
		splitImageFolderLabel = new GLabel("Split Image Folder", "splitImageFolderLabel");
		splitImageFolderLabel.setBounds(90, 13, getStringWidth(splitImageFolderLabel), 16);
		
		centralWidget.add(splitImageFolderLabel);
		
		/*
		 * 
		 * Split Image Folder Line Edit
		 * 
		 */
		
		splitImageFolderLineEdit = new GTextField("Select a folder -->", false, "splitImageFolderLineEdit");
		splitImageFolderLineEdit.setBounds(new Rectangle(rightOf(splitImageFolderLabel, 3), 11, 247, 20));
		
		centralWidget.add(splitImageFolderLineEdit);
		
		/*
		 * 
		 * Browse Button
		 * 
		 */
		
		browseButton = new GButton("Browse", "browseButton");
		browseButton.setBounds(new Rectangle(rightOf(splitImageFolderLineEdit, 6), 9, calculateButtonWidth(browseButton), 24));

		centralWidget.add(browseButton);
		
		/*
		 * 
		 * X Label
		 * 
		 */
		
		xLabel = new GLabel("X", "xLabel");
		xLabel.setBounds(25, 139, getStringWidth(xLabel), 16);
		
		centralWidget.add(xLabel);
		
		/*
		 * 
		 * Y Label
		 * 
		 */
		
		yLabel = new GLabel("Y", "yLabel");
		yLabel.setBounds(75, 139, getStringWidth(yLabel), 16);
		
		centralWidget.add(yLabel);
		
		/*
		 * 
		 * Loop Check Box
		 * 
		 */
		
		loopCheckBox = new GCheckBox("Loop Split Images", "loopCheckBox", true);
		loopCheckBox.setBounds(new Rectangle(row3column3 + 10, 314, calculateCheckBoxWidth(loopCheckBox), 17));
		
		centralWidget.add(loopCheckBox);
		
		/*
		 * 
		 * Auto Restart on Reset Check Box
		 * 
		 */
		
		autoRestartOnResetCheckBox = new GCheckBox("Auto Start On Reset", "autoRestartOnResetCheckBox", true);
		autoRestartOnResetCheckBox.setBounds(row3column3 + 10, 344, calculateCheckBoxWidth(autoRestartOnResetCheckBox), 17);
		
		centralWidget.add(autoRestartOnResetCheckBox);
		
		/*
		 * 
		 * Select Region Button
		 * 
		 */
		
		selectRegionButton = new GButton("Select Region", "selectRegionButton");
		selectRegionButton.setBounds(new Rectangle(column1 + 6, 67, 90, 20));
		
		centralWidget.add(selectRegionButton);
		
		/*
		 * 
		 * Align Region Button
		 * 
		 */
		
		alignRegionButton = new GButton("Align Region", "alignRegionButton");
		alignRegionButton.setBounds(selectRegionButton.getX(), belowButton(selectRegionButton, 3), 90, 20);
		
		centralWidget.add(alignRegionButton);
		
		/*
		 * 
		 * Select Window Button
		 * 
		 */
		
		selectWindowButton = new GButton("Select Window", "selectWindowButton");
		selectWindowButton.setBounds(selectRegionButton.getX(), belowButton(alignRegionButton, 3), 90, 20);
		
		centralWidget.add(selectWindowButton);
		
		/*
		 * 
		 * Similarity Threshold Label
		 * 
		 */
		
		similarityThresholdLabel = new GLabel("Similarity Threshold", "similarityThresholdLabel");
		similarityThresholdLabel.setBounds(new Rectangle(column1, 378, getStringWidth(similarityThresholdLabel), 16));
		
		centralWidget.add(similarityThresholdLabel);
		
		/*
		 * 
		 * Similarity Threshold Double Spin Box
		 * 
		 */
		
		similarityThresholdDoubleSpinBox = new JSpinner(new SpinnerNumberModel(0.9d, 0d, 1d, 0.05d));
		similarityThresholdDoubleSpinBox.setBounds(new Rectangle(160, 383, 64, 22));
		similarityThresholdDoubleSpinBox.setName("similarityThresholdDoubleSpinBox");
		
		centralWidget.add(similarityThresholdDoubleSpinBox);
		
		/*
		 * 
		 * Start Auto Splitter Button
		 * 
		 */
		startAutoSplitterButton = new GButton("Start Auto Splitter", "startAutoSplitterButton");
		startAutoSplitterButton.setBounds(506, 425, calculateButtonWidth(startAutoSplitterButton), 31);
		
		centralWidget.add(startAutoSplitterButton);
		
		/*
		 * 
		 * Reset Button
		 * 
		 */
		resetButton = new GButton("Reset", "resetButton");
		resetButton.setBounds(506, 385, calculateButtonWidth(startAutoSplitterButton), 31);
		
		centralWidget.add(resetButton);
		
		/*
		 * 
		 * Check FPS Button
		 * 
		 */
		
		maxFPSButton = new GButton("Max FPS", "maxFPSButton");
		maxFPSButton.setBounds(column1, 225, calculateButtonWidth(maxFPSButton), 21);
		
		centralWidget.add(maxFPSButton);
		
		/*
		 * 
		 * Show Live Similarity Check Box
		 * 
		 */
		
		showLiveSimilarityCheckBox = new GCheckBox("Show live similarity", "showLiveSimilarityCheckBox", true);
		showLiveSimilarityCheckBox.setBounds(column1, 329, calculateCheckBoxWidth(showLiveSimilarityCheckBox), 17);
		
		centralWidget.add(showLiveSimilarityCheckBox);
		
		/*
		 * 
		 * Show Highest Similarity Check Box
		 * 
		 */
		
		showHighestSimilarityCheckBox = new GCheckBox("Show highest similarity", "showHighestSimilarityCheckBox", true);
		showHighestSimilarityCheckBox.setBounds(column1, below(showLiveSimilarityCheckBox), calculateCheckBoxWidth(showHighestSimilarityCheckBox), 17);
		
		centralWidget.add(showHighestSimilarityCheckBox);
		
		/*
		 * 
		 * Live Similarity Label
		 * 
		 */
		
		liveSimilarityLabel = new GLabel("-.--", "liveSimilarityLabel");
		liveSimilarityLabel.setBounds(160, showLiveSimilarityCheckBox.getY(), 46, 13);
		
		centralWidget.add(liveSimilarityLabel);
		
		/*
		 * 
		 * Highest Similarity Label
		 * 
		 */
		
		highestSimilarityLabel = new GLabel("-.--", "highestSimilarityLabel");
		highestSimilarityLabel.setBounds(160, showHighestSimilarityCheckBox.getY(), 46, 13);
		
		centralWidget.add(highestSimilarityLabel);
		
		/*
		 * 
		 * Split Label
		 * 
		 */
		
		splitLabel = new GLabel("Start / Split", "splitLabel");
		splitLabel.setBounds(row3column2, 317, getStringWidth(splitLabel), 16);
		
		centralWidget.add(splitLabel);
		
		/*
		 * 
		 * Reset Label
		 * 
		 */
		
		resetLabel = new GLabel("Reset", "resetLabel");
		resetLabel.setBounds(row3column2, below(splitLabel, row3column2padding), getStringWidth(resetLabel), 16);
		
		centralWidget.add(resetLabel);
		
		/*
		 * 
		 * Skip Split Label
		 * 
		 */
		
		skipSplitLabel = new GLabel("Skip Split", "skipSplitLabel");
		skipSplitLabel.setBounds(row3column2, below(resetLabel, row3column2padding), getStringWidth(skipSplitLabel), 16);
		
		centralWidget.add(skipSplitLabel);
		
		/*
		 * 
		 * Undo Split Label
		 * 
		 */
		
		undoSplitLabel = new GLabel("Undo Split", "undoSplitLabel");
		undoSplitLabel.setBounds(row3column2, below(skipSplitLabel, row3column2padding), getStringWidth(undoSplitLabel), 16);
		
		centralWidget.add(undoSplitLabel);
		
		/*
		 * 
		 * Pause Label
		 * 
		 */
		
		pauseLabel = new GLabel("Pause", "pauseLabel");
		pauseLabel.setBounds(row3column2, below(undoSplitLabel, row3column2padding), getStringWidth(pauseLabel), 16);
		
		centralWidget.add(pauseLabel);
		
		/*
		 * 
		 * Pause Time After Split Label
		 * 
		 */
		
		pauseTimeAfterSplitLabel = new GLabel("Pause time after split (sec)", "pauseTimeAfterSplitLabel");
		pauseTimeAfterSplitLabel.setBounds(column1, 420, getStringWidth(pauseTimeAfterSplitLabel), 16);
		
		centralWidget.add(pauseTimeAfterSplitLabel);
		
		/*
		 * 
		 * Split Line Edit
		 * 
		 */
		
		splitLineEdit = new GTextField(SpecialKey.NUM_1.toString(), false, "splitLineEdit");
		splitLineEdit.setBounds(rightOf(splitLabel, 12), splitLabel.getY(), 81, 20);
		
		centralWidget.add(splitLineEdit);
		
		/*
		 * 
		 * Undo Split Line Edit
		 * 
		 */
		
		undoSplitLineEdit = new GTextField(SpecialKey.NUM_8.toString(), false, "undoSplitLineEdit");
		undoSplitLineEdit.setBounds(splitLineEdit.getX(), undoSplitLabel.getY(), 81, 20);
		
		centralWidget.add(undoSplitLineEdit);
		
		/*
		 * 
		 * Skip Split Line Edit
		 * 
		 */
		
		skipSplitLineEdit = new GTextField(SpecialKey.NUM_2.toString(), false, "skipSplitLineEdit");
		skipSplitLineEdit.setBounds(splitLineEdit.getX(), skipSplitLabel.getY(), 81, 20);
		
		centralWidget.add(skipSplitLineEdit);
		
		/*
		 *
		 * Reset Line Edit
		 * 
		 */
		
		resetLineEdit = new GTextField(SpecialKey.NUM_3.toString(), false, "resetLineEdit");
		resetLineEdit.setBounds(splitLineEdit.getX(), resetLabel.getY(), 81, 20);
		
		centralWidget.add(resetLineEdit);
		
		/*
		 * 
		 * Pause Hot Key Line Edit
		 * 
		 */
		
		pauseHotKeyLineEdit = new GTextField(SpecialKey.NONE.toString(), false, "pauseHotKeyLineEdit");
		pauseHotKeyLineEdit.setBounds(splitLineEdit.getX(), pauseLabel.getY(), 81, 20);
		
		centralWidget.add(pauseHotKeyLineEdit);
		
		/*
		 * 
		 * Set Split Hot Key Button
		 * 
		 */
		
		setSplitHotKeyButton = new GButton("Set Hotkey", "setSplitHotKeyButton");
		setSplitHotKeyButton.setBounds(rightOf(splitLineEdit, 5), splitLineEdit.getY(), 81, 21);
		
		centralWidget.add(setSplitHotKeyButton);
		
		/*
		 * 
		 * Set Reset Hot Key Button
		 * 
		 */
		
		setResetHotKeyButton = new GButton("Set Hotkey", "setResetHotKeyButton");
		setResetHotKeyButton.setBounds(setSplitHotKeyButton.getX(), resetLineEdit.getY(), 81, 21);
		
		centralWidget.add(setResetHotKeyButton);
		
		/*
		 * 
		 * Set Skip Split Hot Key Button
		 * 
		 */
		
		setSkipSplitHotKeyButton = new GButton("Set Hotkey", "setSkipSplitHotKeyButton");
		setSkipSplitHotKeyButton.setBounds(setSplitHotKeyButton.getX(), skipSplitLineEdit.getY(), 81, 21);
		
		centralWidget.add(setSkipSplitHotKeyButton);
		
		/*
		 * 
		 * Set Undo Split Hot Key Button
		 * 
		 */
		
		setUndoSplitHotKeyButton = new GButton("Set Hotkey", "setUndoSplitHotKeyButton");
		setUndoSplitHotKeyButton.setBounds(setSplitHotKeyButton.getX(), undoSplitLineEdit.getY(), 81, 21);
		
		centralWidget.add(setUndoSplitHotKeyButton);
		
		/*
		 * 
		 * Set Pause Hot Key Button
		 * 
		 */
		
		setPauseHotKeyButton = new GButton("Set Hotkey", "setPauseHotKeyButton");
		setPauseHotKeyButton.setBounds(setSplitHotKeyButton.getX(), pauseHotKeyLineEdit.getY(), 81, 21);
		
		centralWidget.add(setPauseHotKeyButton);
		
		/*
		 * 
		 * Timer Global Hot Keys Label
		 * 
		 */
		
		timerGlobalHotKeysLabel = new GLabel("Timer Global Hotkeys", "timerGlobalHotKeysLabel");
		timerGlobalHotKeysLabel.setBounds(leftOf(splitLineEdit, 4), below(splitLineEdit, -50), getStringWidth(timerGlobalHotKeysLabel), 20);
		
		centralWidget.add(timerGlobalHotKeysLabel);
		
		/*
		 * 
		 * Live Image
		 * 
		 */
		
		liveImage = new GImagePanel();
		liveImage.setBounds(111, 69, 249, 180);
		centralWidget.add(liveImage);
		
		/*
		 * 
		 * Live Image Check Box
		 * 
		 */
		
		liveImageCheckBox = new GCheckBox("Live Capture Region", "liveImageCheckBox", true);
		liveImageCheckBox.setBounds(new Rectangle(liveImage.getX() + 15, below(liveImage, 2), calculateCheckBoxWidth(liveImageCheckBox), 17));
		
		centralWidget.add(liveImageCheckBox);
		
		/*
		 * 
		 * Take Screenshot Button
		 * 
		 */
		
		takeScreenshotButton = new GButton("Take Screenshot", "takeScreenshotButton");
		takeScreenshotButton.setBounds(rightOf(liveImageCheckBox) + 3, liveImageCheckBox.getY(), calculateButtonWidth(takeScreenshotButton), 21);
		
		centralWidget.add(takeScreenshotButton);
		
		/*
		 * 
		 * Current Split Image
		 * 
		 */
		currentSplitImage = new GImagePanel();
		currentSplitImage.setBounds(rightOf(liveImage, 6), liveImage.getY(), liveImage.getWidth(), liveImage.getHeight());
		
		centralWidget.add(currentSplitImage);
		
		/*
		 * 
		 * Undo Split Button
		 * 
		 */
		
		undoSplitButton = new GButton("Undo Split", "undoSplitButton");
		undoSplitButton.setBounds(489, below(currentSplitImage, 2), calculateButtonWidth(undoSplitButton), 21);
		
		centralWidget.add(undoSplitButton);
		
		/*
		 * 
		 * Skip Split Button
		 * 
		 */
		
		skipSplitButton = new GButton("Skip Split", "skipSplitButton");
		skipSplitButton.setBounds(rightOf(undoSplitButton, 4), undoSplitButton.getY(), 61, 21);
		
		centralWidget.add(skipSplitButton);
		
		/*
		 * 
		 * Image Loop Label
		 *
		 */
		imageLoopLabel = new GLabel("Image Loop #:", "imageLoopLabel");
		imageLoopLabel.setBounds(currentSplitImage.getX(), undoSplitButton.getY(), getStringWidth(imageLoopLabel), 20);
		
		centralWidget.add(imageLoopLabel);
		
		
		/*
		 * 
		 * Width Label
		 * 
		 */
		widthLabel = new GLabel("Width", "widthLabel");
		widthLabel.setBounds(centeredOn(widthLabel, xLabel), 177, getStringWidth(widthLabel), 20);
		widthLabel.setLocation(14, 177);
		
		centralWidget.add(widthLabel);
		
		/*
		 * 
		 * Height Label
		 * 
		 */
		heightLabel = new GLabel("Height", "heightLabel");
		heightLabel.setBounds(0, 0, getStringWidth(heightLabel), 20);
		heightLabel.setLocation(centeredOn(heightLabel, yLabel), 177);
		
		centralWidget.add(heightLabel);
		
		/*
		 * 
		 * FPS Value Label
		 * 
		 */
		
		//fpsValueLabel = new GLabel("@@@@", "fpsValueLabel");
		//fpsValueLabel.setBounds(14,  177, getStringWidth(fpsValueLabel), 16);
		
		//centralWidget.add(fpsValueLabel);
		
		/*
		 * 
		 * Width Spin Box
		 * 
		 */
		
		widthSpinBox = new JSpinner(new SpinnerNumberModel(1080, 1, Integer.MAX_VALUE, 20));
		widthSpinBox.setBounds(new Rectangle(1, below(widthLabel), 54, 22));
		JSpinner.NumberEditor widthSpinEditor = new JSpinner.NumberEditor(widthSpinBox, "#");
		widthSpinBox.setEditor(widthSpinEditor);
		widthSpinBox.setName("widthSpinBox");
		
		centralWidget.add(widthSpinBox);
		
		/*
		 * 
		 * Height Spin Box
		 * 
		 */
		
		heightSpinBox = new JSpinner(new SpinnerNumberModel(1920, 1, Integer.MAX_VALUE, 20));
		heightSpinBox.setBounds(new Rectangle(leftOf(heightLabel, 5), below(heightLabel), 54, 22));
		JSpinner.NumberEditor heightSpinEditor = new JSpinner.NumberEditor(heightSpinBox, "#");
		heightSpinBox.setEditor(heightSpinEditor);
		heightSpinBox.setName("heightSpinBox");
		
		centralWidget.add(heightSpinBox);
		
		/*
		 * 
		 * Capture Region Label
		 * 
		 */
		
		captureRegionLabel = new GLabel("Capture Region", "captureRegionLabel");
		captureRegionLabel.setSize(getStringWidth(captureRegionLabel), 20);
		captureRegionLabel.setLocation(centeredOn(captureRegionLabel, liveImage), above(captureRegionLabel, liveImage));
		
		centralWidget.add(captureRegionLabel);
		
		/*
		 * 
		 * Current Split Image Label
		 * 
		 */
		
		currentSplitImageLabel = new GLabel("Current Split Image", "currentSplitImageLabel");
		currentSplitImageLabel.setBounds(centeredOn(currentSplitImageLabel, currentSplitImage), above(currentSplitImageLabel, currentSplitImage), getStringWidth(currentSplitImageLabel) + 4, 20);
		currentSplitImageLabel.setLocation(centeredOn(currentSplitImageLabel,  currentSplitImage), above(currentSplitImageLabel, currentSplitImage));
		
		centralWidget.add(currentSplitImageLabel);
		
		/*
		 * 
		 * FPS Label
		 * 
		 */
		
		fpsLabel = new GLabel("FPS", "fpsLabel");
		final int fpsLabelWidth = getStringWidth(fpsLabel);
		fpsLabel.setBounds(leftOf(liveImage, fpsLabelWidth + 3), maxFPSButton.getY(), fpsLabelWidth, 20);
		
		centralWidget.add(fpsLabel);
		
		/*
		 * 
		 * FPS Limit Label
		 * 
		 */
		
		fpsLimitLabel = new GLabel("FPS Limit:", "fpsLimitLabel");
		fpsLimitLabel.setBounds(maxFPSButton.getX(), belowButton(maxFPSButton, 6), getStringWidth(fpsLimitLabel), 16);
		
		centralWidget.add(fpsLimitLabel);
		
		/*
		 * 
		 * FPS Limit Spin Box
		 * 
		 */
		
		fpsLimitSpinBox = new JSpinner(new SpinnerNumberModel(30, 30, 300, 30));
		fpsLimitSpinBox.setBounds(heightSpinBox.getX(), fpsLimitLabel.getY(), heightSpinBox.getWidth(), heightSpinBox.getHeight());
		JSpinner.NumberEditor fpsEditor = new JSpinner.NumberEditor(fpsLimitSpinBox, "#");
		fpsLimitSpinBox.setEditor(fpsEditor);
		fpsLimitSpinBox.setName("fpsLimitSpinBox");
		
		centralWidget.add(fpsLimitSpinBox);
		
		/*
		 * 
		 * Current Split Image File Label
		 * 
		 */
		
		currentSplitImageFileLabel = new GLabel("No Split Image Provided", "currentSplitImageFileLabel");
		currentSplitImageFileLabel.setSize(getStringWidth(currentSplitImageFileLabel), 16);
		currentSplitImageFileLabel.setMaximumSize(currentSplitImageFileLabel.getSize());
		currentSplitImageFileLabel.setLocation(centeredOn(currentSplitImageFileLabel, currentSplitImage), belowButton(undoSplitButton));
		
		centralWidget.add(currentSplitImageFileLabel);
		
		/*
		 * 
		 * X Spin Box
		 * 
		 */
		xSpinBox = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 20));
		xSpinBox.setBounds(widthSpinBox.getX(), below(xLabel), widthSpinBox.getWidth(), widthSpinBox.getHeight());
		JSpinner.NumberEditor xSpinEditor = new JSpinner.NumberEditor(xSpinBox, "#");
		xSpinBox.setEditor(xSpinEditor);
		xSpinBox.setName("xSpinBox");
		
		centralWidget.add(xSpinBox);
		
		/*
		 * 
		 * Y Spin Box
		 * 
		 */
		
		ySpinBox = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 20));
		ySpinBox.setBounds(heightSpinBox.getX(), below(yLabel), heightSpinBox.getWidth(), heightSpinBox.getHeight());
		JSpinner.NumberEditor ySpinEditor = new JSpinner.NumberEditor(ySpinBox, "#");
		ySpinBox.setEditor(ySpinEditor);
		ySpinBox.setName("ySpinBox");
		
		centralWidget.add(ySpinBox);
		
		/*
		 * 
		 * Comparison Method Label
		 * 
		 */
		
		comparisonMethodLabel = new GLabel("Comparison Method", "comparisonMethodLabel");
		comparisonMethodLabel.setBounds(0, 299, getStringWidth(comparisonMethodLabel), 16);
		
		centralWidget.add(comparisonMethodLabel);
		
		/*
		 * 
		 * Comparison Method Combo Box
		 * 
		 */
		
		comparisonMethodComboBox = new JComboBox<Comparison>(Comparison.values());
		comparisonMethodComboBox.setBounds(rightOf(comparisonMethodLabel, 53), comparisonMethodLabel.getY(),  81,  22);
		comparisonMethodComboBox.setName("comparisonMethodComboBox");
		comparisonMethodComboBox.setFont(GLabel.DEFAULT_FONT_SETTINGS.getFont());
		
		centralWidget.add(comparisonMethodComboBox);
		
		/*
		 * 
		 * Pause Double Spin Box
		 * 
		 */
		
		pauseDoubleSpinBox = new JSpinner(new SpinnerNumberModel(10, 0, 120, 0.5d));
		pauseDoubleSpinBox.setBounds(similarityThresholdDoubleSpinBox.getX(), pauseTimeAfterSplitLabel.getY(), similarityThresholdDoubleSpinBox.getWidth(), similarityThresholdDoubleSpinBox.getHeight());
		pauseDoubleSpinBox.setName("pauseDoubleSpinBox");
		
		centralWidget.add(pauseDoubleSpinBox);
		
		/*
		 * 
		 * Custom Threshold Check Box
		 * 
		 */
		customThresholdCheckBox = new GCheckBox("Custom thresholds", "customThresholdCheckBox");
		customThresholdCheckBox.setBounds(similarityThresholdLabel.getX(), below(similarityThresholdLabel), calculateCheckBoxWidth(customThresholdCheckBox), 17);
		
		centralWidget.add(customThresholdCheckBox);
		
		/*
		 * 
		 * Custom Pause Time Check Box
		 * 
		 */
		
		customPauseTimeCheckBox = new GCheckBox("Custom pause times", "customPauseTimeCheckBox");
		customPauseTimeCheckBox.setBounds(pauseTimeAfterSplitLabel.getX(), below(pauseTimeAfterSplitLabel), calculateCheckBoxWidth(customPauseTimeCheckBox), 17);
		
		centralWidget.add(customPauseTimeCheckBox);
		
		/*
		 * 
		 * Group Dummy Splits Check Box
		 * 
		 */
		
		groupDummySplitsCheckBox = new GCheckBox("Group dummy splits when undoing/skipping", "groupDummySplitsCheckBox");
		groupDummySplitsCheckBox.setBounds(row3column2, below(pauseLabel, 6), calculateCheckBoxWidth(groupDummySplitsCheckBox), 17);
		
		centralWidget.add(groupDummySplitsCheckBox);
		
		/*
		 * 
		 * Frame And Widget 
		 * 
		 */
		
		Dimension MIN_SIZE = new Dimension(rightOf(startAutoSplitterButton, 16), below(startAutoSplitterButton, 16));		
		centralWidget.setSize(MIN_SIZE);
		frame.setSize(MIN_SIZE);
		frame.setMinimumSize(MIN_SIZE);
		frame.setMaximumSize(MIN_SIZE);
		frame.setResizable(false);
		
		frame.setVisible(true);
	}
	
	private int getStringWidth(JLabel label) {
		return label.getFontMetrics(label.getFont()).stringWidth(label.getText());
	}
	
	private int calculateButtonWidth(JButton button) {
		return button.getFontMetrics(button.getFont()).stringWidth(button.getText()) + (button.getBorder().getBorderInsets(button).left * 2) + 12;
	}
	
	private int calculateCheckBoxWidth(GCheckBox box) {
		return getStringWidth(new GLabel(box.getText(), "")) + 20;
	}
	
	private int getStringWidth(JComponent component, String text) {
		return component.getFontMetrics(component.getFont()).stringWidth(text);
	}
	
	private int leftOf(JComponent component, int amount) {
		return component.getX() - amount;
	}
	
	private int rightOf(JComponent component) {
		if(!(component instanceof DynamicallySized)) {
			return component.getX() + component.getWidth();
		}
		return component.getX() + ((DynamicallySized) component).getActualWidth();
	}
	
	private int rightOf(JComponent component, int spacing) {
		return rightOf(component) + spacing;
	}
	
	private int belowButton(JButton button) {
		if (button instanceof DynamicallySized) {
			DynamicallySized dynamic = (DynamicallySized) button;
			return button.getY() + dynamic.getActualHeight();
		}
		else {
			return button.getY() + button.getHeight();
		}
	}
	
	private int belowButton(JButton button, int spacing) {
		return belowButton(button) + spacing;
	}
	
	private int below(JComponent component) {
		if(component instanceof JButton) {
			if(!(component instanceof DynamicallySized)) {
				return component.getY() + component.getHeight() * 2 + component.getBorder().getBorderInsets(component).bottom + 1;
			}
			throw new UnsupportedOperationException("Cannot compute lower bounds of of dynamically sized JButton!");
		}
		else if (component instanceof DynamicallySized) {
			DynamicallySized dynamic = (DynamicallySized) component;
			return component.getY() + dynamic.getActualHeight();
		}
		else {
			return component.getY() + component.getHeight();
		}
	}
	
	private int below(JComponent component, int spacing) {
		return below(component) + spacing;
	}
	
	private int above(JComponent upperComponent, JComponent lowerComponent) {
		System.out.println(lowerComponent.getY() - upperComponent.getHeight());
		return lowerComponent.getY() - upperComponent.getHeight();
	}
	
	private int centeredOn(JComponent componentToCenter, JComponent component) {
		int mid;
		if(!(component instanceof DynamicallySized)) {
			mid = component.getX() + component.getWidth() / 2;
		}
		else {
			System.out.println(((DynamicallySized) component).getActualWidth());
			mid = component.getX() + ((DynamicallySized)component).getActualWidth() / 2;
		}
		
		int pos;
		if(!(componentToCenter instanceof DynamicallySized)) {
			pos = componentToCenter.getWidth() / 2;
		}
		else {
			System.out.println(((DynamicallySized) component).getActualWidth());
			pos = ((DynamicallySized) component).getActualWidth() / 2;
		}
		
		pos = mid - pos;
		
		return pos;
		
	}
	
}
