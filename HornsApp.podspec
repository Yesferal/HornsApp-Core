Pod::Spec.new do |spec|
  spec.name = 'Hornsapp_Kotlin'
  spec.version = '0.1.0'
  spec.homepage = 'https://github.com/Yesferal/HornsApp_Kotlin'
  spec.source = { :git => "https://github.com/Yesferal/HornsApp_Kotlin.git", :tag => "{spec.version}" }
  spec.authors = { "Yesferal Cueva" => "yesferal@gmail.com" }
  spec.license = { :type => "Apache-2.0", :file => "LICENSE" }
  spec.summary = 'HornsApp Kotlin Multiplatform Core Library'
  spec.static_framework = true
  spec.vendored_frameworks = "Hornsapp_Kotlin.framework"
  spec.libraries = "c++"
  spec.module_name = "#{spec.name}_core"
  spec.ios.deployment_target = '13.0'
end
