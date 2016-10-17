package com.github.RebeccaStevens;

import inputmanager.InputType;

public class UesrInput {

	private InputType type;
	private int inputCode;
	
	public UesrInput(InputType type, int inputCode) {
		this.setType(type);
		this.setInputCode(inputCode);
	}

	/**
	 * @return the type
	 */
	public InputType getType() {
		return type;
	}

	/**
	 * @return the inputCode
	 */
	public int getInputCode() {
		return inputCode;
	}

	/**
	 * @param type
	 */
	public void setType(InputType type) {
		this.type = type;
	}

	/**
	 * @param inputCode
	 */
	public void setInputCode(int inputCode) {
		this.inputCode = inputCode;
	}
}
