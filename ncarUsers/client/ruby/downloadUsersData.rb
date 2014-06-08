#!/usr/bin/ruby

require 'rubygems'
require 'json'
require 'open-uri'
$KCODE = 'UTF8'

def download(filename)
  file=File.new(filename, 'w')
  base_uri = 'http://localhost:8080/ncarUsers/rrh/users/'

  # Make the HTTP request and read the response entity-body as a JSON
  # document.
  json = open(base_uri).read

  # Parse the JSON document into a Ruby data structure.
  json = JSON.parse(json)

  # Iterate over the data structure...
  json.each { |r| file.puts r['USERNAME'] + '|' + r['PASSWORD'] + '|' + r['FIRST_NAME'] +  '|' +  r['LAST_NAME'] + 
              '|' + r['EMAIL'] + '|' +  r['LAB'] + '|' + r['DIVISION']; }
end

# Main program.
unless ARGV[0]
  puts "Usage: #{$0} [file name]"
  exit
end
download(ARGV[0])
