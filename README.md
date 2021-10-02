[![](https://jitpack.io/v/Yesferal/HornsApp-Core.svg)](https://jitpack.io/#Yesferal/HornsApp-Core)
# Horns App - Kotlin Multiplatform
This is a Kotlin Multiplatform that will be import in Android and iOS projects.

## How to create a new version

### Create a Tag
First, we have to create a new git tag
```
git tag '1.0.0'
```
then push this tag into the Remote Repository
```
git push origin --tags   
```
### [iOS] Push a new version in PodSpecs Repository
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
The script folder contains the `pre-build.script` that will be executed by HornsAppCore.podspec file,
as a prepare command. This script contains pre-conditions that are necessary in order to publish our library.

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