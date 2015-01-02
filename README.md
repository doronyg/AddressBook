AddressBook
===========
Usage/compilation instructions:
* To compile just load the code to Android Studio (version 1.0 and above please).
Code was tested on a Nexus 7 (2013) running Lollipop (so I am not sure how nice would it look on a phone).

* To run the tests - run from the dropdown TestAll.

* Although this code was developed on a PC, using gradle you should have no problems compiling it on a Mac (hurray Gradle).

General remarks on the task:

As an Android developer, I chose Android platform and implemented a simple address book with minimal functionality (only shows the full name, address & picture).

The code has three major parts:

* The activity which behaves as the controller in this case (if the code was any bigger, probably this part should have been refactored out to a different class).
* The models which are saved in a DB.
* The views which are created by a the recycler view adapter.

The code was developed using a TDD approach - tests were written and then the modules.
As testing Android is layouts and custom views is extremely time consuming, tests are focused on the creation of the DB and the parsing of data which is done by GSON although there is a test which is testing the population of a view.

Added featured that should be added given more time:

* Ability to show more data about each user (could have taken an extra hour - most data is in the DB already, but I never created the layout to show it)
* Ability to add new users manually (another extra hour).
* Ability to delete users (another half an hour).
* Add loading spinners when loading from network.
* Add proper messages when an error occurs (i.e. no network).
* Supporting a large variatty of devices (could take days)

To make this project more robust, some more verifications as to the consistency of the data could be made. Otherwise, as the code is mostly tested and as I am writing "defensive code" that would usually not crush (lessons learned from writing an app with over a million downloads), the app is generally robust.

