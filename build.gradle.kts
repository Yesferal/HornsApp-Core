plugins {
    kotlin("multiplatform") version "1.5.10"
    id("maven-publish")
}

val libraryVersion = "0.2.0"
group = "com.yesferal.hornsapp.core"
version = libraryVersion

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
        sourceSets["jvmMain"].dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
        }
    }

    val iosX64 = iosX64()
    val iosArm64 = iosArm64()
    val libraryName = "HornsAppCore"
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
