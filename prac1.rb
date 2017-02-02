module Speak
	def speak(sound)
		puts "#{sound}"
	end
end

class Abc
	include Speak
end

class Xyz
	include Speak
end

demo = Abc.new
demo.speak("hi!")
demo2 = Xyz.new
demo2.speak("how are you?")