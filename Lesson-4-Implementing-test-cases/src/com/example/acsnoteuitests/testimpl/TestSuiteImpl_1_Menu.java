package com.example.acsnoteuitests.testimpl;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.acsnoteuitests.utils.Utils;
import com.robotium.solo.Solo;

public class TestSuiteImpl_1_Menu {
	private static final String ALL_NOTES_MENU_ICON = "iv_icon";
	private Solo solo;
	private Context context;
	private Utils utils;

	public TestSuiteImpl_1_Menu(Solo solo, Context context) {
		this.solo = solo;
		this.context = context;
		utils = new Utils(solo, context);
	}

	public void allNotesMenu() {
		utils.clickOnViewByName(ALL_NOTES_MENU_ICON);
		utils.checkText("Agenda");
		utils.checkText("Favorites");
		utils.checkText("Protected");
		utils.checkText("All Notes");
		utils.checkText("Protected");
		utils.checkText("Calendar");
		utils.checkText("Category");
		utils.checkText("Backup SD");
		utils.checkText("Settings");
		utils.clickOnViewByName(ALL_NOTES_MENU_ICON);
	}
	
	public void categoryItems(){
		utils.clickOnViewByName(ALL_NOTES_MENU_ICON);
		utils.clickOnText("Category");
		solo.waitForActivity(Utils.COLOR_ACTIVITY);
		utils.checkText("All Notes");
		utils.checkText("General");
		utils.checkText("Personal");
		utils.checkText("Family");
		utils.checkText("Business");
		utils.checkText("Grocery");
		utils.checkText("Travel");
		utils.checkText("Friends");
		utils.checkText("Restaurant");
		utils.checkText("Sport");
		utils.checkText("Reload");
		utils.checkText("Save");
		utils.clickOnText("Cancel");
		solo.waitForActivity(Utils.HOME_ACTIVITY);
		utils.clickOnText("All Notes");
	}
	
	public void settingsItems(){
		utils.clickOnViewByName(ALL_NOTES_MENU_ICON);
		utils.clickOnText("Settings");
		solo.waitForActivity(Utils.SETTINGS_ACTIVITY);
		utils.checkText("Category");
		utils.checkText("Organize Notes");
		utils.checkText("Associate each category with a color");
		utils.checkText("List");
		utils.checkText("Default Color");
		utils.checkText("Date and Time");
		utils.checkText("Date Format");
		utils.checkText("12/31/2012");
		utils.checkText("First day of the week");
		utils.checkText("Monday");
		utils.checkText("Show week number");
		utils.checkText("No");
		utils.checkText("Notification");
		utils.checkText("Set Ringtone");
		utils.checkText("Continuous");
		utils.checkText("Yes");
		solo.scrollDown();
		solo.sleep(1000);
		utils.checkText("Continuous");
		utils.checkText("Yes");
		utils.checkText("Vibrate");
		utils.checkText("Yes");
		utils.checkText("Repetition");
		utils.checkText("5");
		utils.checkText("Security");
		utils.checkText("Manage PIN Code");
		utils.checkText("Create a PIN Code to protect your sensitive notes");
		utils.checkText("PIN Code Lost");
		utils.checkText("Reset The PIN Code. All protected notes will be erased");
		utils.checkText("About");
		utils.checkText("Contact us");
		utils.checkText("Please send us your feedback or report any problem you meet");
		utils.checkText("Legal Information");
		utils.checkText("Attributions");
		solo.scrollDown();
		solo.sleep(1000);
		utils.checkText("View Licence");
		solo.goBack();
		solo.waitForActivity(Utils.HOME_ACTIVITY);
		utils.clickOnText("All Notes");
	}
	
	public void sortNotesMode(){
		utils.clickOnViewByName("ib_menuMore");
		utils.checkText("Sort Mode");
		utils.checkText("By Name");
		utils.checkText("Modification");
		utils.checkText("By Reminder");
		utils.checkText("By Color");
		utils.checkText("List");
		utils.checkText("Grid");
		solo.goBack();
		solo.waitForActivity(Utils.HOME_ACTIVITY);
	}

}
