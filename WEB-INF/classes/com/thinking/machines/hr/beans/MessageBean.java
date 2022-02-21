package com.thinking.machines.hr.beans;
public class MessageBean implements java.io.Serializable{
    private String message;
    private String heading;
    private Boolean generateButton;
    private Boolean generateTwoButton;
    private String buttonOneText;
    private String buttonTwoText;
    private String buttonOneAction;
    private String buttonTwoAction;
    public MessageBean(){
        message = "";
    }
    public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    public String getHeading() {
		return this.heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
    public Boolean getGenerateButton() {
        return this.generateButton;
    }
    public void setGenerateButton(Boolean generateButton) {
        this.generateButton = generateButton;
    }
    public Boolean getGenerateTwoButton() {
        return this.generateTwoButton;
    }
    public void setGenerateTwoButton(Boolean generateTwoButtons) {
        this.generateTwoButton = generateTwoButtons;
    }
    public String getButtonOneText() {
        return this.buttonOneText;
    }
    public void setButtonOneText(String buttonOneText) {
        this.buttonOneText = buttonOneText;
    }
    public String getButtonTwoText() {
        return this.buttonTwoText;
    }
    public void setButtonTwoText(String buttonTwoText) {
        this.buttonTwoText = buttonTwoText;
    }
    public String getButtonOneAction() {
        return this.buttonOneAction;
    }
    public void setButtonOneAction(String buttonOneAction) {
        this.buttonOneAction = buttonOneAction;
    }
    public String getButtonTwoAction() {
        return this.buttonTwoAction;
    }
    public void setButtonTwoAction(String buttonTwoAction) {
        this.buttonTwoAction = buttonTwoAction;
    }
}