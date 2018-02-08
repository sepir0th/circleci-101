# More documentation about how to customize your build
# can be found here:
# https://docs.fastlane.tools
fastlane_version "2.68.0"

# This value helps us track success metrics for Fastfiles
# we automatically generate. Feel free to remove this line
# once you get things running smoothly!
generated_fastfile_id "b3257c42-83c8-4d54-a607-584fe31cbac6"

default_platform :android

# Fastfile actions accept additional configuration, but
# don't worry, fastlane will prompt you for required
# info which you can add here later
lane :beta do
  # build the release variant
  build_android_app(task: "assembleRelease")

  # upload to Beta by Crashlytics
  crashlytics(
    api_token: "6c7ff41da047fa088f9c7de0bc9d2c4ff3b796ea",
    build_secret: "56e2565c456720d16a2ab97d2e326d02b985eb5ebbd4624f5a3b49414af1030f"
  )
end
