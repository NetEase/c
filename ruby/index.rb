require 'socket'
server = TCPServer.open (2000)
print "begin to start server,open port (2000)"
loop do
client = server.accept
client.puts "The connection is now in place"
client.puts "The time is #(Time.now)"
client.puts "The connection is now closed. Thank you for connecting"
client.close
end