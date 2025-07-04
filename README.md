<h1>Single-Threaded and Multi-Threaded Server</h1>
A comprehensive comparison and implementation of single-threaded and multi-threaded server architectures, demonstrating the performance differences and use cases for each approach.
<h2>🚀 Overview</h2>
This project showcases two fundamental server architectures:
<ul>
  <li><b>Single-Threaded Server:</b> Processes one client request at a time in a sequential manner. When a client sends a request to the server then the request is accepted by the port defined in the server where it is continuosly trying to listen to any request coming to it. As soon as server detects a request on the port, it creates a socket for the client and invokes a single thread worker which basically responds to the client socket with a message in the form of bytestream. The client's socket recieves this message and is now ready for further communication. It is a 3-way handshake process which is a part of TCP connection.
  <br><br>
<img width="491" alt="image" src="https://github.com/user-attachments/assets/88c9adc2-0882-4389-9e23-ede86087e19b" />
<br><br>
    <img width="491" alt="image" src="https://github.com/user-attachments/assets/d2894996-1e4d-4814-a038-3c27cee39a3d" />
<br><br>
    <img width="1025" alt="image" src="https://github.com/user-attachments/assets/ff816bc1-f9f4-4d9e-bace-e5166e94e56d" />
<br><br>
    The single threaded server is tested with 60k requests in a 60 seconds time frame which evaluates to 1k RPS througput rate using JMeter. The results depict that there were almost null failed requests to server. So here in single threaded case, every time a new requests is coming to the server, the server is creating a socket for it, processing it using single thread worker and then closing the socket for the respected client. If there is another request, then the server opens another socket and processes the second request and the process goes on.
  </li>
</ul>
