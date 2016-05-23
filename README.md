# Android Fastlane

## Initial setup

* Installing fastlane `sudo gem install fastlane --verbose`
* Initializing fastlane for a project
    * Navigate to the project folder
    * `fastlane init`, this will trigger a setup for a basic setup skip automating screengrab and uploading to store

## Creating your own actions

Writing your own actions is out of the scope of this article since it's basically just ruby scripting. It is fairly straight forward if you know basic scripting and use other scripts as inspiration.

In this repo you can find a custom action `jacoco_gradle` that triggers the custom gradle task defined in `jacoco.gradle`.

**There is a bug in GradleAction, and the current workaround is to specifically add `project_dir: "."` when invoking `.run`. A pull request has been made for this issue.**

 ## Creating a pipeline with Fastlane.