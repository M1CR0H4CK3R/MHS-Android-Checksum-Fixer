MH Stories Android Checksum Fixer v1.00 by Marcus Carter

It is recommended to read this document using a monospaced font
such as Courier New, Fixedsys, or Consolas. The reader can find a
section by searching for the letters inside of the square
brackets after the name of each section in the Table of Contents.


			-----------------------
			-----------------------
			-- Table of Contents --
			-----------------------
			-----------------------


	1.			REQUIREMENTS					[RQMT]
	2.			SETUP AND USAGE					[SPNU]
		2a.			WHERE TO EXTRACT FILES			[WREX]
		2b.			RUNNING THE PROGRAM			[RPRG]
	3.			BUILDING (WINDOWS ONLY FOR NOW)			[BLDG]
		3a.			IMPORTING PROJECT TO ECLIPSE IDE	[IMPT]
	4.			CREDITS AND LICENSE				[CRDT]


			---------------------------
			---------------------------
			-- REQUIREMENTS ([RQMT]) --
			---------------------------
			---------------------------


This program requires AT LEAST Java 1.8.0_110 to run (I haven't tested any versions of Java other than 1.8.0_221, though). In other words, JRE 1.8.0_221 or greater is recommended. Build instructions are only provided for Windows, although the .jar file SHOULD run on most versions of Linux or Mac OS-X that are capable of running the required Java Runtime Environment (JRE).


			------------------------------
			------------------------------
			-- SETUP AND USAGE ([SPNU]) --
			------------------------------
			------------------------------


The 'MHS-Android-Checksum-Fixer-v1.00.7z' file provided should be extracted directly to the Desktop of the user's device using 7-zip. Using a file manager on a ROOTED Android device, open "/data/data/jp.co.capcom.mhsspen/files/" and copy mhr_game0.sav to your device's Downloads folder.
Next, transfer the file to PC somehow and put it in the folder that you extracted from the .7z file with 7-zip (should be 'MHS-Android-Checksum-Fixer'). Edit the file as seen fit (might need to wait for Android support to get added to the save editor for 3DS, but those who know what to look for can use a hex editor). Finally, follow the instructions in the next section, then check back here.

The fixed files should appear nearly instantly in the 'output' folder in the .jar file's folder. Transfer all 4 files to the Android device's Downloads folder, use the file manager to copy them to "/data/data/jp.co.capcom.mhsspen/files/", and that's it!


			----------------------------------
			----------------------------------
			-- RUNNING THE PROGRAM ([RPRG]) --
			----------------------------------
			----------------------------------


On Windows:
Just double-click on the 'MHS-Android-Checksum-Fixer.jar' file, and that's it.

On Linux:
In terminal, chdir to the folder where the .jar file is (make sure that Java is properly installed), type "java -jar MHS-Android-Checksum-Fixer.jar", and press Enter.

If everything was done correctly, there will be no message at all.


			-----------------------
			-----------------------
			-- BUILDING ([BLDG]) --
			-----------------------
			-----------------------


Requirements:
1. Java Development Kit (JDK) 1.8.0_221 or greater
2. The javaw.exe and jar.exe files' directory in PATH
3. Windows

Instructions:
To compile a .jar, download the repository, and extract it to a new folder (or use "git checkout" in Git). Copy all files in the "drive-root" folder in the root of the C drive (or whichever one Java is installed on). Open Command Prompt, navigate to the root of the C drive, and type in the following command:
    jar cvfm MHS-Checksum-Fixer.jar manifest.txt META-INF org SHA1Fix.class


			-----------------------------------------------
			-----------------------------------------------
			-- IMPORTING PROJECT TO ECLIPSE IDE ([IMPT]) --
			-----------------------------------------------
			-----------------------------------------------


Download the repository, and extract it to a new folder (or use "git checkout" in Git). Add a new project, save it, copy the contents of this repository to the project's folder, then reopen the project in Eclipse. Done!


			----------------------------------
			----------------------------------
			-- CREDITS AND LICENSE ([CRDT]) --
			----------------------------------
			----------------------------------


Credits:

This program was written from the ground up by me,
Marcus Carter (MarcusCarter on GBAtemp, M1CR0H4CK3R on
GitHub, and Maq47#3451 on Discord), despite knowing
almost nothing about coding beforehand. I asked for
help diagnosing an error I had on Stack Exchange,
but other than that, no help was obtained whatsoever.
I asked on the r/CodingHelp discord for help, but
got absolutely no response in the 5 days it took to
make this program. Apache's commons-io is used in
the .jar, so I have applied their license, and
mentioned them here.


Licensing:

In addition to the Apache License 2.0 that this
repository goes by, I add the following addendum:

Anyone may post this on their website, as long as
they include a link to the original thread on GBAtemp,
as well as this original README.txt file with the same
hex sequence, phrase, and date at the end of the file.
Also, all uploaders must provide their Social Security #,
if any (this last part is both a joke and a test to see who
reads this file). Anyone who does not follow these rules
will be publicly shamed and bothered to no end until the
files are removed.





04477A6B81A69F2F11006D3E25700A1907435C77
"Selfie Sticks are dumb - case closed."
July 4th, 1776
