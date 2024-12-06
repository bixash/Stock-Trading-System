import React, { useState, useEffect, useRef } from 'react';
import SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';

const App: React.FC = () => {
    const [message, setMessage] = useState<string>('');
    const [name, setName] = useState<string>('');
    const stompClientRef = useRef<Client | null>(null);

    useEffect(() => {
        const socket = new SockJS('http://localhost:8081/ws');
        const stompClient = new Client({
            webSocketFactory: () => socket,
            reconnectDelay: 5000,
            debug: (str: string) => {
                console.log(str);
            },
            onConnect: () => {
                console.log('Connected to WebSocket');
                stompClient.subscribe('/topic/greetings', (response) => {
                    console.log('Received message:', response.body);
                    setMessage(JSON.parse(response.body).content);
                });
            },
            onStompError: (frame) => {
                console.error('Broker reported error: ' + frame.headers['message']);
                console.error('Additional details: ' + frame.body);
            },
        });

        stompClient.activate();
        stompClientRef.current = stompClient;

        return () => {
            stompClient.deactivate();
        };
    }, []);

    const sendMessage = () => {
        const stompClient = stompClientRef.current;
        if (stompClient && stompClient.connected) {
            console.log('Sending message:', name);
            stompClient.publish({
                destination: '/app/hello',
                body: name,
            });
        } else {
            console.error('Stomp client is not connected');
        }
    };

    return (
        <div>
            <input 
                type="text" 
                placeholder="Enter your name" 
                value={name} 
                onChange={(e) => setName(e.target.value)} 
            />
            <button onClick={sendMessage}>Send</button>
            <p>{message}</p>
        </div>
    );
};

export default App;

