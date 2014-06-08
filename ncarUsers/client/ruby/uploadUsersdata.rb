#!/usr/bin/ruby
require 'rubygems'
require 'rest-open-uri'
require 'uri'
require 'cgi'


def uploadUsers(content)
  base_uri = 'http://localhost:8080/ncarUsers/rrh/users'
  begin
      response = open(base_uri, :method => :put, 'Content-Type' => "text/plain", :body => content)
  rescue OpenURI::HTTPError => e
      response_code = e.io.status[0].to_i
	puts response_code 
      if response_code !=  "200" 
        puts "Sorry, Can't post the users"
      else
        raise e
      end
    end

  end

def upload(filename)
   File.open(filename) do |file|
   content = file.read
   uploadUsers(content)
   end
end


# Main program.
unless ARGV[0]
  puts "Usage: #{$0} [file name]"
  exit
end
upload(ARGV[0])