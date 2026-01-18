[![](https://jitpack.io/v/Yesferal/HornsApp-Core.svg)](https://jitpack.io/#Yesferal/HornsApp-Core)
[![Workflow for Kotlin Standard Action](https://github.com/Yesferal/HornsApp-Core/actions/workflows/ci.yml/badge.svg)](https://github.com/Yesferal/HornsApp-Core/actions/workflows/ci.yml)
# Horns App - Kotlin Multiplatform
This is a Kotlin Multiplatform that will be import in Android and iOS projects.

## How to generate a Local Build

### iOS
First, we would need to generate a podspec file just the first time. In order to do that we should run:
```
./gradlew podspec
```

However, we already have created a file manually, so we will skip that line for now.

After that we need to run the next line each time we do a local change:
```
./gradlew buildReleaseXCFramework
```

Finally, in the ios module we need to update the local module:
```
pod update
```
```
pod install
```

Note: We add `iosX64` and `iosSimulatorArm64` in order to make locale build works on Simulator.

## How to create a new Release version

### Create a Tag
First, we have to create a new git tag
```
git tag '1.0.0'
```
then push this tag into the Remote Repository
```
git push origin --tags   
```
### [iOS only] Push a new version in PodSpecs Repository
As an optional step you could clean the cache, just in case
```
pod cache clean --all 
```

Also, you may validate the .podspec file
```
pod spec lint --verbose  
```

Finally, you should push the new library version. This version will be published in our [HornsApp-PodSpecs Repository](https://github.com/Yesferal/HornsApp-PodSpecs)
```
pod repo push HornsApp-PodSpecs HornsAppCore.podspec
```

#### Podspec
The `HornsAppCore.podspec` file contains the description of our library. 
This file will first execute a script in order to build a xcframework.

#### Script
The script folder contains the `prepare_command.script` that will be executed by HornsAppCore.podspec file,
as a prepare command. This script contains pre-conditions that are necessary in order to publish our library.

### [Android only]
Make sure to run the JitPack job that depends on the Github Tags.

## License
```
Copyright 2020 HornsApp Contributors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```