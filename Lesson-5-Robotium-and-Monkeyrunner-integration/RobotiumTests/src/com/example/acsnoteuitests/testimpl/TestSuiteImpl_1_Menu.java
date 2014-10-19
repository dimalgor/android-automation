package com.example.acsnoteuitests.testimpl;

import com.example.acsnoteuitests.R;
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
		utils.checkText(R.string.agenda);
		utils.checkText(R.string.favorites); 
		utils.checkText(R.string.protectedStr);
		utils.checkText(R.string.all_notes);
		utils.checkText(R.string.protectedStr);
		utils.checkText(R.string.calendar);
		utils.checkText(R.string.category);
		utils.checkText(R.string.backup_sd);
		utils.checkText(R.string.settings);
		utils.clickOnViewByName(ALL_NOTES_MENU_ICON);
	}
	
	public void categoryItems(){
		utils.clickOnViewByName(ALL_NOTES_MENU_ICON);
		utils.clickOnText(R.string.category);
		solo.waitForActivity(Utils.COLOR_ACTIVITY);
		utils.checkText(R.string.all_notes);
		utils.checkText(R.string.general);
		utils.checkText(R.string.personal);
		utils.checkText(R.string.family);
		utils.checkText(R.string.business);
		utils.checkText(R.string.grocery);
		utils.checkText(R.string.travel);
		utils.checkText(R.string.friends);
		utils.checkText(R.string.restaurant);
		utils.checkText(R.string.sport);
		utils.checkText(R.string.reload);
		utils.checkText(R.string.save);
		utils.clickOnText(R.string.cancel);
		solo.waitForActivity(Utils.HOME_ACTIVITY);
		utils.clickOnText(R.string.all_notes);
	}
	
	public void settingsItems(){
		utils.clickOnViewByName(ALL_NOTES_MENU_ICON);
		utils.clickOnText(R.string.settings);
		solo.waitForActivity(Utils.SETTINGS_ACTIVITY);
		utils.checkText(R.string.category);
		utils.checkText(R.string.organize_notes);
		utils.checkText(R.string.associate_color);
		utils.checkText(R.string.list);
		utils.checkText(R.string.default_color);
		utils.checkText(R.string.date_and_time);
		utils.checkText(R.string.date_format);
		utils.checkText("12/31/2012");
		utils.checkText(R.string.first_day_of_the_week);
		utils.checkText(R.string.monday);
		utils.checkText(R.string.show_week_number);
		utils.checkText(R.string.no);
		utils.checkText(R.string.notification);
		utils.checkText(R.string.set_Ringtone);
		utils.checkText(R.string.continuous);
		utils.checkText(R.string.yes);
		solo.scrollDown();
		solo.sleep(1000);
		utils.checkText(R.string.continuous);
		utils.checkText(R.string.yes);
		utils.checkText(R.string.vibrate);
		utils.checkText(R.string.yes);
		utils.checkText(R.string.repetition);
		utils.checkText("5");
		utils.checkText(R.string.security);
		utils.checkText(R.string.manage_pin_code);
		utils.checkText(R.string.create_pin);
		utils.checkText(R.string.pin_code_lost);
		utils.checkText(R.string.reset_pin);
		utils.checkText(R.string.about);
		utils.checkText(R.string.contact_us);
		utils.checkText(R.string.please_send_feedback);
		utils.checkText(R.string.legal_nformation);
		utils.checkText(R.string.attributions);
		solo.scrollDown();
		solo.sleep(1000);
		utils.checkText(R.string.view_licence);
		solo.goBack();
		solo.waitForActivity(Utils.HOME_ACTIVITY);
		utils.clickOnText(R.string.all_notes);
	}
	
	public void sortNotesMode(){
		utils.clickOnViewByName("ib_menuMore");
		utils.checkText(R.string.sort_mode);
		utils.checkText(R.string.by_name);
		utils.checkText(R.string.modification);
		utils.checkText(R.string.by_reminder);
		utils.checkText(R.string.by_color);
		utils.checkText(R.string.list);
		utils.checkText(R.string.grid);
		solo.goBack();
		solo.waitForActivity(Utils.HOME_ACTIVITY);
	}
	
	public void createNewNoteMenu(){
		utils.clickOnViewByName("ib_createNote");
		utils.checkText(R.string.create_new_note);
		utils.checkText(R.string.text_note);
		utils.checkText(R.string.toDo_list);
		utils.checkText(R.string.painting);
		utils.checkText(R.string.voice_note);
		utils.checkText(R.string.picture_note);		
		utils.checkText(R.string.attach);
		utils.checkText(R.string.qr_code);
		utils.checkText(R.string.cancel);
		solo.goBack();
		solo.waitForActivity(Utils.HOME_ACTIVITY);
	}
}
