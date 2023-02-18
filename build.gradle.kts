plugins {
    kotlin("multiplatform") version "1.5.21"
    id("maven-publish")
}

val libraryVersion = "0.5.5"
group = "com.yesferal.hornsapp.core"
version = libraryVersion

// Libraries
val mockitoVersion = "4.0.0"

repositories {
    mavenCentral()
}

kotlin {

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }

    sourceSets {
        sourceSets["commonMain"].dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
        }
        sourceSets["jvmTest"].dependencies {
            implementation("junit:junit:4.13.2")
            implementation("org.mockito:mockito-core:$mockitoVersion")
            implementation("org.mockito:mockito-inline:$mockitoVersion")
        }
    }

    val libraryName = "HornsAppCore"

    // Simulator Architecture
    val iosX64 = iosX64()
    // Device Architecture
    val iosArm64 = iosArm64()
    configure(listOf(iosX64, iosArm64)) {
        binaries.framework {
            baseName = libraryName
        }
    }

    tasks.register("buildReleaseXCFramework", Exec::class.java) {
        description = "Create a Release XCFramework"
        dependsOn("linkReleaseFrameworkIosArm64")
        dependsOn("linkReleaseFrameworkIosX64")

        val arm64FrameworkPath = "$rootDir/build/bin/iosArm64/releaseFramework/${libraryName}.framework"
        val arm64ReleaseSymbolsPath = "$rootDir/build/bin/iosArm64/releaseFramework/${libraryName}.framework.dSYM"

        val x64FrameworkPath = "$rootDir/build/bin/iosX64/releaseFramework/${libraryName}.framework"
        val x64ReleaseSymbolsPath = "$rootDir/build/bin/iosX64/releaseFramework/${libraryName}.framework.dSYM"

        val xcFrameworkDest = File("$rootDir/build/bin/xcframework/releaseFramework/$libraryName.xcframework")
        executable = "xcodebuild"
        args(mutableListOf<String>().apply {
            add("-create-xcframework")
            add("-output")
            add(xcFrameworkDest.path)

            // Real Device
            add("-framework")
            add(arm64FrameworkPath)
            add("-debug-symbols")
            add(arm64ReleaseSymbolsPath)

            // Simulator
            add("-framework")
            add(x64FrameworkPath)
            add("-debug-symbols")
            add(x64ReleaseSymbolsPath)
        })

        doFirst {
            xcFrameworkDest.deleteRecursively()
        }
    }
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            artifact(tasks["sourcesJar"])
            version = libraryVersion
        }
    }
}
