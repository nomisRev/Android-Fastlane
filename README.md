# Android Fastlane

## Initial setup

* Installing fastlane `sudo gem install fastlane --verbose`
* Initializing fastlane for a project
    * Navigate to the project folder
    * `fastlane init`, this will trigger a setup for a basic setup skip automating screengrab and uploading to store

## Creating your own actions

**Warning there is still a bug in GradleAction, I fixed this and made a pull request but this is still pending. A workaround is also explained below.**

* Creating your own fastlane action can be done by running `fastlane new_action`
* Fastlane will then ask you for a name (Must be lower case, and use a '_' between words. Do not use '.')
* Let's create a simple action and let's call it `jacoco_report`. As you could have guessed we'll be using this fastlane action to invoke a gradle script to generate jacoco coverage report
* You can now find a file in /fastlane/actions/jacoco_report.rb



 ## Creating a pipeline with Fastlane.

 * Let's say we want have following things in our pipeline
     1. `gradle clean` we want to do this to make sure we start with a clean project in order to prevent weird bugs due to old files.
     2. `gradle assemble` in order to generate the apks.
     3. `gradle lint checkstyle findbugs pmd` in order to run our static analyser tools and generate their reports.
     4. `gradle test` run our unit tests
     5. `gradle connectedAndroidTest` run our instrumentation (UI) tests
     6. `gradle `