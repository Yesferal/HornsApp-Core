plugins {
    kotlin("multiplatform") version "1.5.10"
}

group = "com.yesferal.hornsapp.core"
version = "0.1.0"

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

    val ios32 = iosArm32("ios32")
    val ios64 = iosArm64("ios64")
    val libraryName = "HornsApp-Kotlin"
    configure(listOf(ios32, ios64)) {
        binaries.framework {
            baseName = libraryName
        }
    }
    tasks.register<org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask>("debugFatFramework") {
        baseName = libraryName
        destinationDir = buildDir.resolve("fat-framework/debug")
        from(
            ios32.binaries.getFramework("Debug"),
            ios64.binaries.getFramework("Debug")
        )
    }

    tasks.register<org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask>("releaseFatFramework") {
        // The fat framework must have the same base name as the initial frameworks.
        baseName = libraryName
        // The default destination directory is "<build directory>/fat-framework".
        destinationDir = buildDir.resolve("fat-framework/release")
        // Specify the frameworks to be merged.
        from(
            ios32.binaries.getFramework("Release"),
            ios64.binaries.getFramework("Release")
        )
    }
}
