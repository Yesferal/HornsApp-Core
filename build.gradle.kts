plugins {
    kotlin("multiplatform") version "1.5.10"
    id("maven-publish")
}

val libraryVersion = "0.1.3"
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
    js(LEGACY) {
        browser {

        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }

    val iosX64 = iosX64()
    val iosArm64 = iosArm64()
    val libraryName = "HornsAppCore"
    configure(listOf(iosX64, iosArm64)) {
        binaries.framework {
            baseName = libraryName
        }
    }
    tasks.register<org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask>("debugFatFramework") {
        baseName = libraryName
        destinationDir = buildDir.resolve("fat-framework/debug")
        from(
            iosX64.binaries.getFramework("Debug"),
            iosArm64.binaries.getFramework("Debug")
        )
    }

    tasks.register<org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask>("releaseFatFramework") {
        // The fat framework must have the same base name as the initial frameworks.
        baseName = libraryName
        // The default destination directory is "<build directory>/fat-framework".
        destinationDir = buildDir.resolve("fat-framework/release")
        // Specify the frameworks to be merged.
        from(
            iosX64.binaries.getFramework("Release"),
            iosArm64.binaries.getFramework("Release")
        )
    }

    tasks.register("buildDebugXCFramework", Exec::class.java) {
        description = "Create a Debug XCFramework"
        dependsOn("linkDebugFrameworkIosArm64")
        dependsOn("linkDebugFrameworkIosX64")

        val arm64FrameworkPath = "$rootDir/build/bin/iosArm64/debugFramework/${libraryName}.framework"
        val arm64DebugSymbolsPath = "$rootDir/build/bin/iosArm64/debugFramework/${libraryName}.framework.dSYM"

        val x64FrameworkPath = "$rootDir/build/bin/iosX64/debugFramework/${libraryName}.framework"
        val x64DebugSymbolsPath = "$rootDir/build/bin/iosX64/debugFramework/${libraryName}.framework.dSYM"

        val xcFrameworkDest = File("$rootDir/$libraryName.xcframework")
        executable = "xcodebuild"
        args(mutableListOf<String>().apply {
            add("-create-xcframework")
            add("-output")
            add(xcFrameworkDest.path)

            // Real Device
            add("-framework")
            add(arm64FrameworkPath)
            add("-debug-symbols")
            add(arm64DebugSymbolsPath)

            // Simulator
            add("-framework")
            add(x64FrameworkPath)
            add("-debug-symbols")
            add(x64DebugSymbolsPath)
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
