package com.example.acsnoteuitests.testimpl;

import com.example.acsnoteuitests.R;
import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.acsnoteuitests.utils.Utils;
import com.robotium.solo.Solo;

public class TestSuiteImpl_2_PictureNote {
	private static final String DELETE_NOTE_IMAGE_BUTTON = "ib_trash";
	private static final String PREVIEW_PHOTO_IMAGE_VIEW = "iv_imageViewPreview";
	private static final String CREATE_NOTE_IMAGE_BUTTON = "ib_createNote";
	private static final String TEST_PICTURE_NOTE = "Test picture note";
	private Solo solo;
	private Context context;
	private Utils utils;
	public static final String MONKEYRUNNER_TAG = "MonkeyrunnerInvocation";

	public TestSuiteImpl_2_PictureNote(Solo solo, Context context) {
		this.solo = solo;
		this.context = context;
		utils = new Utils(solo, context);
	}

	public void createPictureNote() {
		utils.clickOnViewByName(CREATE_NOTE_IMAGE_BUTTON);
		utils.clickOnText(R.string.picture_note);
		Log.i(MONKEYRUNNER_TAG, "sendPhoto() start ...");
		solo.sleep(8000);
		utils.checkText(R.string.attach);
		utils.checkText(R.string.voice);
		utils.checkText(R.string.photo);
		solo.enterText(0, TEST_PICTURE_NOTE);
		utils.clickOnText(R.string.save);
		solo.waitForActivity(Utils.HOME_ACTIVITY);
		utils.clickOnText(TEST_PICTURE_NOTE);
		solo.waitForActivity(Utils.HOME_EDITOR);
		solo.sleep(2000);
		utils.clickOnViewByName(PREVIEW_PHOTO_IMAGE_VIEW);
		Log.i(MONKEYRUNNER_TAG, "goBack() start ...");
		solo.waitForActivity(Utils.HOME_EDITOR);
		deleteNoteOnEditNoteScreen();
		solo.waitForActivity(Utils.HOME_ACTIVITY);
	}

	private void deleteNoteOnEditNoteScreen() {
		utils.clickOnViewByName(DELETE_NOTE_IMAGE_BUTTON);
		utils.checkText(R.string.note);
		utils.checkText(R.string.delete);
		utils.checkText(R.string.no);
		utils.clickOnText(R.string.yes);
	}

}
