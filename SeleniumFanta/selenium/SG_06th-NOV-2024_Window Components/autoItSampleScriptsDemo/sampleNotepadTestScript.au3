#comments-start
1. Open notepad
#comments-end

Run("notepad.exe");
Sleep(2000);


#comments-start
2. Write some text in it
#comments-end

Send("Good Morning");
Send("{ENTER}");
Send("Welcome to SG Testing Institute");
Send("{ENTER}");
Send("Good Day");
Sleep(2000);


#comments-start
3. Save the notepad, by pressing the "Ctrl+Shift+s" short cut key
#comments-end
Send("^+s");
Sleep(2000);


#comments-start
4. "Save as" window will open, enter file path & click on "Save" button
#comments-end

If (WinExists("Save as")) Then
	ControlSetText("Save as", "", "Edit1", "C:\MorningBatch_Combined\autoItSampleScriptsDemo\sample.txt");
	Sleep(2000);
	ControlClick("Save as", "&Save", "Button2");
	
	Sleep(2000);
	
	If (WinExists("Confirm Save As")) Then
		ControlClick("Confirm Save As", "&Yes", "Button1");
	EndIf
	Sleep(2000);
	WinClose("sample.txt - Notepad");
Else
	MsgBox(0, "Error Message", "Failed to open the 'Save As' window", 15);
EndIf



