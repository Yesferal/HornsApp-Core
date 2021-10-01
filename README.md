# Horns App - Kotlin Multiplatform
This is a Kotlin Multiplatform that will be import in Android adn iOS projects.

## How to create a version

### Create a Tag
Create a new git tag
```
git tag '0.1.1'
```
and push the new tag into Remote Repository
```
git push origin --tags   
```
### Push the new version
First, you could clean the cache, just in case
```
pod cache clean --all 
```

Also, you could validate the .podspec file
```
pod spec lint --verbose  
```

Finally, you should push the new library version
```
pod repo push HornsApp-PodSpecs HornsAppCore.podspec
```

## Podspec
The `HornsAppCore.podspec` file contains the description of the library

## Script
The script folder contains the `pre-build.script` that will be executed by HornsAppCore.podspec file,
as a prepare command. This script contains pre-conditions that are needed in order to publish the library.

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