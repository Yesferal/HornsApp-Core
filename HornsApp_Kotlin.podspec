Pod::Spec.new do |spec|
  spec.name = 'HornsApp_Kotlin'
  spec.version = '0.1.0'
  spec.homepage = 'https://github.com/Yesferal/HornsApp-KotlinMultiplatform'
  spec.source = { :git => "git@github.com:Yesferal/HornsApp-KotlinMultiplatform.git", :tag => "#{spec.version}" }
  spec.authors = { "Yesferal Cueva" => "yesferal@gmail.com" }
  spec.license = { :type => "Apache-2.0", :file => "LICENSE" }
  spec.summary = 'HornsApp Kotlin Multiplatform Core Library'
  spec.static_framework = true
  spec.vendored_frameworks = 'build/fat-framework/release/HornsApp_Kotlin.framework'
  spec.libraries = "c++"
  spec.module_name = "#{spec.name}_core"
  spec.ios.deployment_target = '13.0'
end

 s.script_phase = { :name => 'Writing to files', :script => '(./script/pre-build.script)', :execution_position => :before_compile }