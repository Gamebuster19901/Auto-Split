package com.gamebuster19901.autosplit.input;

import static java.awt.event.KeyEvent.*;

import java.util.HashSet;

/**
 * 
 * These keys either have no visual representation, or have multiple
 * locations on most keyboards
 *
 */

public enum SpecialKey {
	
	ENTER(VK_ENTER),
	NUMPAD_ENTER(VK_ENTER, KEY_LOCATION_NUMPAD),
	
	BACKSPACE(VK_BACK_SPACE),
	
	TAB(VK_TAB),
	
	CANCEL(VK_CANCEL),
	
	CLEAR(VK_CLEAR),
	
	SHIFT(VK_SHIFT),
	
	LEFT_CONTROL(VK_CONTROL, KEY_LOCATION_LEFT),
	
	RIGHT_CONTROL(VK_CONTROL, KEY_LOCATION_RIGHT),
	
	CONTROL(VK_CONTROL),
	
	LEFT_ALT(VK_ALT, KEY_LOCATION_LEFT),
	
	RIGHT_ALT(VK_ALT, KEY_LOCATION_RIGHT),
	
	ALT(VK_ALT),
	
	PAUSE(VK_PAUSE),
	
	CAPS_LOCK(VK_CAPS_LOCK),
	
	ESC(VK_ESCAPE),
	
	SPACE(VK_SPACE),
	
	PAGE_UP(VK_PAGE_UP),
	
	PAGE_DOWN(VK_PAGE_DOWN),
	
	END(VK_END),
	
	HOME(VK_HOME),
	
	LEFT(VK_LEFT),
	
	UP(VK_UP),
	
	RIGHT(VK_RIGHT),
	
	DOWN(VK_DOWN),
	
	NUM_0(VK_NUMPAD0),
	NUM_1(VK_NUMPAD1),
	NUM_2(VK_NUMPAD2),
	NUM_3(VK_NUMPAD3),
	NUM_4(VK_NUMPAD4),
	NUM_5(VK_NUMPAD5),
	NUM_6(VK_NUMPAD6),
	NUM_7(VK_NUMPAD7),
	NUM_8(VK_NUMPAD8),
	NUM_9(VK_NUMPAD9),
	
	NUM__0(VK_NUMPAD0, KEY_LOCATION_NUMPAD),
	NUM__1(VK_NUMPAD1, KEY_LOCATION_NUMPAD),
	NUM__2(VK_NUMPAD2, KEY_LOCATION_NUMPAD),
	NUM__3(VK_NUMPAD3, KEY_LOCATION_NUMPAD),
	NUM__4(VK_NUMPAD4, KEY_LOCATION_NUMPAD),
	NUM__5(VK_NUMPAD5, KEY_LOCATION_NUMPAD),
	NUM__6(VK_NUMPAD6, KEY_LOCATION_NUMPAD),
	NUM__7(VK_NUMPAD7, KEY_LOCATION_NUMPAD),
	NUM__8(VK_NUMPAD8, KEY_LOCATION_NUMPAD),
	NUM__9(VK_NUMPAD9, KEY_LOCATION_NUMPAD),
	
	NUM_MULTIPLY(VK_MULTIPLY),
	NUM_ADD(VK_ADD),
	NUM_SUBTRACT(VK_SUBTRACT),
	NUM_DECIMAL(VK_DECIMAL),
	NUM_DIVIDE(VK_DIVIDE),
	
	NUM__MULTIPLY(VK_MULTIPLY, KEY_LOCATION_NUMPAD),
	NUM__ADD(VK_ADD, KEY_LOCATION_NUMPAD),
	NUM__SUBTRACT(VK_SUBTRACT, KEY_LOCATION_NUMPAD),
	NUM__DECIMAL(VK_DECIMAL, KEY_LOCATION_NUMPAD),
	NUM__DIVIDE(VK_DIVIDE, KEY_LOCATION_NUMPAD),
	
	DELETE(VK_DELETE),
	NUM_DELETE(VK_DELETE, KEY_LOCATION_NUMPAD),
	
	NUM_LOCK(VK_NUM_LOCK),
	SCROLL_LOCK(VK_SCROLL_LOCK),
	
	F1(VK_F1),
	F2(VK_F2),
	F3(VK_F3),
	F4(VK_F4),
	F5(VK_F5),
	F6(VK_F6),
	F7(VK_F7),
	F8(VK_F8),
	F9(VK_F9),
	F10(VK_F10),
	F11(VK_F11),
	F12(VK_F12),
	F13(VK_F13),
	F14(VK_F14),
	F15(VK_F15),
	F16(VK_F16),
	F17(VK_F17),
	F18(VK_F18),
	F19(VK_F19),
	F20(VK_F20),
	F21(VK_F21),
	F22(VK_F22),
	F23(VK_F23),
	F24(VK_F24),
	
	PRINT_SCREEN(VK_PRINTSCREEN),
	INSERT(VK_INSERT),
	HELP(VK_HELP),
	META(VK_META),
	
	NUM_UP(VK_KP_UP),
	NUM_DOWN(VK_KP_DOWN),
	NUM_LEFT(VK_KP_LEFT),
	NUM_RIGHT(VK_KP_RIGHT),
	
	LEFT_WINDOWS(VK_WINDOWS, KEY_LOCATION_LEFT),
	RIGHT_WINDOWS(VK_WINDOWS, KEY_LOCATION_RIGHT),
	WINDOWS(VK_WINDOWS),
	
	CONTEXT(VK_CONTEXT_MENU),
	
	FINAL(VK_FINAL),
	
	CONVERT(VK_CONVERT),
	
	NONCONVERT(VK_NONCONVERT),
	
	ACCEPT(VK_ACCEPT),
	
	MODECHANGE(VK_MODECHANGE),
	
	KANA(VK_KANA),
	
	KANJI(VK_KANJI),
	
	ALPHANUMERIC(VK_ALPHANUMERIC),
	
	KATAKANA(VK_KATAKANA),
	
	HIRAGANA(VK_HIRAGANA),
	
	FULL_WIDTH(VK_FULL_WIDTH),
	
	HALF_WIDTH(VK_HALF_WIDTH),
	
	ROMAN(VK_ROMAN_CHARACTERS),
	
	ALL_CANDIDATES(VK_ALL_CANDIDATES),
	
	PREVIOUS_CANDIDATE(VK_PREVIOUS_CANDIDATE),
	
	CODE_INPUT(VK_CODE_INPUT),
	
	KATAKANA_2(VK_JAPANESE_KATAKANA),
	
	HIRAGANA_2(VK_JAPANESE_HIRAGANA),
	
	ROMAN_2(VK_JAPANESE_ROMAN),
	
	KANA_LOCK(VK_KANA_LOCK),
	
	INPUT_TOGGLE(VK_INPUT_METHOD_ON_OFF),
	
	CUT(VK_CUT),
	COPY(VK_COPY),
	PASTE(VK_PASTE),
	UNDO(VK_UNDO),
	REDO(VK_AGAIN),
	FIND(VK_FIND),
	PROPS(VK_PROPS),
	STOP(VK_STOP),
	
	COMPOSE(VK_COMPOSE),
	ALT_GRAPH(VK_ALT_GRAPH),
	BEGIN(VK_BEGIN),
	
	NOT_SPECIAL(-1)
	
	;
	
	private static HashSet<SpecialKey> keys = new HashSet<SpecialKey>();
	
	private int keyCode;
	private int keyLocation = KEY_LOCATION_STANDARD;
	
	private SpecialKey(int keyCode) {
		this.keyCode = keyCode;
	}
	
	private SpecialKey(int keyCode, int keyLocation) {
		this(keyCode);
		this.keyLocation = keyLocation;
	}
	
	public String toString() {
		if(keyLocation != KEY_LOCATION_STANDARD) {
			String name = name();
			switch(keyLocation) {
				case KEY_LOCATION_LEFT:
					name = "LEFT_" + name;
					break;
				case KEY_LOCATION_RIGHT:
					name = "RIGHT" + name;
					break;
				case KEY_LOCATION_NUMPAD:
					name = "NUM" + name;
					break;
				default:
					System.out.println("Unexpected key location " + keyLocation + " for " + name());
					break;
			}
		}
		return name();
	}
	
	public static SpecialKey getSpecialKey(int keycode) {
		return getSpecialKey(keycode, KEY_LOCATION_STANDARD);
	}
	
	public static SpecialKey getSpecialKey(String text) {
		for(SpecialKey key : keys) {
			if(key.toString().equals(text)) {
				return key;
			}
		}
		return NOT_SPECIAL;
	}
	
	public static SpecialKey getSpecialKey(int keyCode, int keyLocation) {
		for(SpecialKey key : keys) {
			if(key.keyCode == keyCode && key.keyLocation == keyLocation) {
				return key;
			}
		}
		return NOT_SPECIAL;
	}
	
}
