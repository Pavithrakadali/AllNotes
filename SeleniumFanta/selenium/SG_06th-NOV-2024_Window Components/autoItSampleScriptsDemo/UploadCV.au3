
$filePath=$CmdLine[1];

if (WinExists("Open")) Then
	ControlSetText("Open", "", "Edit1", $filePath);
	Sleep(2000);
	ControlClick("Open", "&Open", "Button1");
EndIf