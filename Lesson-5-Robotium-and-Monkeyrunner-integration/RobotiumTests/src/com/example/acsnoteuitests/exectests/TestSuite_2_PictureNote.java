package com.example.acsnoteuitests.exectests;

import com.example.acsnoteuitests.testimpl.TestSuiteImpl_1_Menu;
import com.example.acsnoteuitests.testimpl.TestSuiteImpl_2_PictureNote;
import com.robotium.solo.Solo;

public class TestSuite_2_PictureNote extends BaseTest
{
    private TestSuiteImpl_2_PictureNote pictureNote;

    public TestSuite_2_PictureNote() throws ClassNotFoundException
    {
        super();
    }

    @Override
    protected void setUp() throws Exception
    {
        solo = new Solo(getInstrumentation(), getActivity());
        context = this.getInstrumentation().getContext();
        pictureNote = new TestSuiteImpl_2_PictureNote(solo, context);
    }

    @Override
    public void tearDown() throws Exception
    {
    	solo.finishOpenedActivities();
    }

    public void test_01_createPictureNote()
    {
    	pictureNote.createPictureNote();
    }
    
    
}
